package kz.letmedie.paste.service;

import kz.letmedie.paste.api.PasteRequest;
import kz.letmedie.paste.api.PasteResponse;
import kz.letmedie.paste.api.PasteUrl;
import kz.letmedie.paste.entity.Paste;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PasteService {
    Paste getByHash(String hash);
    List<Paste> getFirstPublicPaste(int amount);
    PasteUrl create(PasteRequest pasteBoxRequest);
}
