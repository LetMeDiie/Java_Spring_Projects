package kz.letmedie.paste.api;

import kz.letmedie.paste.entity.PasteExpiration;
import kz.letmedie.paste.entity.PasteStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasteRequest {
    private String data;
    private PasteExpiration pasteExpiration;
    private PasteStatus pasteStatus;
}
