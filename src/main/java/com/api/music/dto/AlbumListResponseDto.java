package com.api.music.dto;

import lombok.Builder;

import java.util.List;

public class AlbumListResponseDto {
    List<AlbumResponseDto> content;
    AlbumPageLinks links;

    @Builder
    public AlbumListResponseDto(List<AlbumResponseDto> content, AlbumPageLinks links){
        this.content = content;
        this.links = links;
    }

}
