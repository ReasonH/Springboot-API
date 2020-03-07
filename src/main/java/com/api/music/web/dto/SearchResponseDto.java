package com.api.music.web.dto;

import com.api.music.domain.albums.Album;
import com.api.music.domain.songs.Song;
import lombok.Builder;

import java.util.List;

public class SearchResponseDto {
    private List<Album> albums;
    private List<Song> songs;

    @Builder
    public SearchResponseDto(List<Album> albums, List<Song> songs){
        this.albums = albums;
        this.songs = songs;
    }
}
