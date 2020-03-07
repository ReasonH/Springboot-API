package com.api.music.web.dto;

import com.api.music.domain.songs.Song;
import lombok.Builder;

import java.util.List;

public class AlbumResponseDto {
    private String title;
    private List<String> locale;
    private List<Song> songs;

    @Builder
    public AlbumResponseDto(String title, List<String> locale, List<Song> songs){
        this.title = title;
        this.locale = locale;
        this.songs = songs;
    }
}
