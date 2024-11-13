package kz.letmedie.paste.service.impl.hash;

import kz.letmedie.paste.api.PasteRequest;

import java.security.NoSuchAlgorithmException;

public interface HashingService {
    String hashing(PasteRequest pasteRequest);
}
