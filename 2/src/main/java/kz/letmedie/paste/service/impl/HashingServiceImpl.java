package kz.letmedie.paste.service.impl;

import kz.letmedie.paste.api.PasteRequest;
import kz.letmedie.paste.service.HashingService;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashingServiceImpl implements HashingService {
    @Override
    public String hashing(PasteRequest pasteRequest) {
        try {
            // Используем SHA-256 для хеширования
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(pasteRequest.getData().getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            // Возвращаем только первые 6 символов хеша
            return hexString.toString().substring(0, 6);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating hash", e);
        }
    }
}
