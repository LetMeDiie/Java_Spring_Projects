package kz.letmedie.paste.repository;
import kz.letmedie.paste.entity.Paste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasteRepository extends JpaRepository<Paste,Long> {
    Optional<Paste> findByHash(String hash);
}
