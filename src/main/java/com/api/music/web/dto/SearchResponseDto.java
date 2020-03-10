package com.api.music.web.dto;

import com.api.music.domain.albums.Album;
import com.api.music.domain.songs.Song;
import lombok.Builder;

import java.util.List;

public class SearchResponseDto {
    private List<AlbumResponseDto> albums;
    private List<SongResponseDto> songs;

    @Builder
    public SearchResponseDto(List<AlbumResponseDto> albums, List<SongResponseDto> songs){
        this.albums = albums;
        this.songs = songs;
    }
}
