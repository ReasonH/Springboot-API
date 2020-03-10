package com.api.music.domain.albums;

import java.util.List;

public interface AlbumRepositoryCustom {
    List<Album> isRightLocale(String locale);
}
