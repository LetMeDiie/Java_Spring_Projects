package kz.letmedie.paste.service.impl.past_list_filter;

import kz.letmedie.paste.entity.Paste;

import java.util.List;

public interface PastFilter {
    List<Paste> filter(List<Paste> pastes);
}
