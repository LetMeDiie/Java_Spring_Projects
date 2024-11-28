package kz.letmedie.paste.service;

import kz.letmedie.paste.api.PasteRequest;

import java.security.NoSuchAlgorithmException;

public interface HashingService {
    String hashing(PasteRequest pasteRequest);
}
