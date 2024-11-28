package kz.letmedie.paste.controller;

import kz.letmedie.paste.api.PasteRequest;
import kz.letmedie.paste.api.PasteResponse;
import kz.letmedie.paste.api.PasteUrl;
import kz.letmedie.paste.entity.Paste;
import kz.letmedie.paste.service.PasteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class PasteBoxController {
    private final PasteService pasteService;

    @GetMapping("/{hash}")
    public ResponseEntity<Object> getByHash(@PathVariable String hash) {
        Paste paste = pasteService.getByHash(hash);
        return PasteResponse.responseBuilder(
                "Paste successfully found",
                HttpStatus.OK,
                paste
        );
    }

    @GetMapping("/public/{amount}")
    public ResponseEntity<Object> getPublicPasteList(@PathVariable int amount) {
        List<Paste> pasteList=pasteService.getFirstPublicPaste(amount);
        return PasteResponse.responseBuilder(
                "The list of public Paste successfully received",
                HttpStatus.OK,
                pasteList
        );
    }

    @PostMapping("/")
    public ResponseEntity<Object> add(@RequestBody PasteRequest pasteRequest) {
        PasteUrl pasteUrl = pasteService.create(pasteRequest);
        return PasteResponse.responseBuilder(
                "Paste has been successfully created",
                HttpStatus.CREATED,
                pasteUrl
        );
    }
}
