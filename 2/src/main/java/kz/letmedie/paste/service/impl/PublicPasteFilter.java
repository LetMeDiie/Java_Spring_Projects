package kz.letmedie.paste.service.impl;

import kz.letmedie.paste.entity.Paste;
import kz.letmedie.paste.entity.PasteStatus;
import kz.letmedie.paste.service.PastFilter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PublicPasteFilter implements PastFilter {
    @Override
    public List<Paste> filter(List<Paste> pastes) {
        //filter public past
        List<Paste> filtered = pastes.stream()
                .filter(paste -> paste.getStatus() == PasteStatus.PUBLIC && paste.isAlive())
                .collect(Collectors.toList());

        //sort by date
            List sortedAndFilteredPastes = filtered.stream()
                    .sorted((paste1, paste2) -> paste1.getCreatedDate().compareTo(paste2.getCreatedDate()))
                    .collect(Collectors.toList());
        return sortedAndFilteredPastes;
    }
}
