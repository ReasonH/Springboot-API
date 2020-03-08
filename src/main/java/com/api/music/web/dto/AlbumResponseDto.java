package com.api.music.web.dto;

import com.api.music.domain.albums.Album;
import com.api.music.domain.locale.LocaleCode;
import com.api.music.domain.songs.Song;
import lombok.Builder;

import java.util.List;

public class AlbumResponseDto {
    private String title;
    private List<LocaleCode> locales;
    private List<Song> songs;

    @Builder
    public AlbumResponseDto(Album entity){
        this.title = entity.getTitle();
        this.locales = entity.getLocaleCodes();
        this.songs = entity.getSongs();
    }
}
