package com.api.music.domain.albums;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AlbumRepositoryCustom {
    List<Album> isRightLocale(String locale);
    Page<Album> getAlbumList(String locale, Pageable pageable);
}
