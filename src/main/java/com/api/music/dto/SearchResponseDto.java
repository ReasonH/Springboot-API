package com.api.music.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SearchResponseDto {
    private List<AlbumResponseDto> albums;
    private List<SongResponseDto> songs;

    @Builder
    public SearchResponseDto(List<AlbumResponseDto> albums, List<SongResponseDto> songs){
        this.albums = albums;
        this.songs = songs;
    }
}
