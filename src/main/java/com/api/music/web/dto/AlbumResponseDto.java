package com.api.music.web.dto;

import com.api.music.domain.albums.Album;
import com.api.music.domain.locale.LocaleCode;
import com.api.music.domain.songs.Song;
import sun.util.locale.LocaleExtensions;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumResponseDto {
    private String title;
    private List<LocaleCodeResponseDto> locales;
    private List<SongResponseDto> songs;

    public AlbumResponseDto(Album entity){
        this.title = entity.getTitle();
        this.locales = entity.getLocaleCodes().stream().map(LocaleCodeResponseDto::new).collect(Collectors.toList());
        this.songs = entity.getSongs().stream().map(SongResponseDto::new).collect(Collectors.toList());
    }
}