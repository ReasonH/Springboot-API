package com.api.music.dto;

import com.api.music.domain.albums.Album;
import com.api.music.domain.locale.LocaleCode;
import com.api.music.domain.songs.Song;
import lombok.Getter;

import java.util.List;

@Getter
public class AlbumResponseDto {
    private Long id;
    private String title;
    private List<Song> songs;

    public AlbumResponseDto(Album entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.songs = entity.getSongs();
    }
}