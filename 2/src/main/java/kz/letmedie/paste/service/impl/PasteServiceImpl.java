package kz.letmedie.paste.service.impl;

import kz.letmedie.paste.api.PasteRequest;
import kz.letmedie.paste.api.PasteResponse;
import kz.letmedie.paste.api.PasteUrl;
import kz.letmedie.paste.entity.Paste;
import kz.letmedie.paste.exception.PasteExpiredException;
import kz.letmedie.paste.exception.PasteNotFoundException;
import kz.letmedie.paste.repository.PasteRepository;
import kz.letmedie.paste.service.PasteService;
import kz.letmedie.paste.service.impl.hash.HashingService;
import kz.letmedie.paste.service.impl.past_list_filter.PastFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PasteServiceImpl implements PasteService {
    private final PasteRepository repository;
    private final PastFilter pastFilter;
    private final HashingService hashingService;

    @Value("${app.paste.baseUrl}")
    private String baseUrl;

    @Override
    public Paste getByHash(String hash) {
        Paste paste = repository.findByHash(hash)
                .orElseThrow(() -> new PasteNotFoundException("Paste with hash " + hash + " not found."));

        if(!paste.isAlive())
            throw new PasteExpiredException("Paste with hash" + hash + "expired and unavailable");
        return paste;
    }

    @Override
    public List<Paste> getFirstPublicPaste(int amount) {
        List<Paste> pastes = repository.findAll();
        pastes = pastFilter.filter(pastes);

        List<Paste> limitedPastes = pastes.stream()
                .limit(amount)
                .collect(Collectors.toList());
        return limitedPastes;
    }

    @Override
    public PasteUrl create(PasteRequest pasteRequest) {
        Paste paste = new Paste();
        String hash = hashingService.hashing(pasteRequest);
        paste.setHash(hash);
        paste.setExpiration(pasteRequest.getPasteExpiration());
        paste.setData(pasteRequest.getData());
        paste.setStatus(pasteRequest.getPasteStatus());
        repository.save(paste);

        PasteUrl pasteUrl = new PasteUrl(baseUrl + hash);
        return pasteUrl;
    }
}

