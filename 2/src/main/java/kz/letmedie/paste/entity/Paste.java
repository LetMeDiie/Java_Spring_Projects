package kz.letmedie.paste.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Paste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data;
    private String hash;
    private LocalDateTime createdDate;

    @Enumerated(EnumType.STRING)
    private PasteExpiration expiration;

    @Enumerated(EnumType.STRING)
    private PasteStatus status;


    public boolean isAlive() {
        if (expiration == PasteExpiration.INFINITE) {
            return true;
        }
        LocalDateTime expirationTime = createdDate.plus(expiration.getDuration());
        return expirationTime.isAfter(LocalDateTime.now());
    }

    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            createdDate = LocalDateTime.now();
        }
    }
}
