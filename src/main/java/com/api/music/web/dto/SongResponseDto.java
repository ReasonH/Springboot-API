package com.api.music.web.dto;

import lombok.Builder;

public class SongResponseDto {
    private String title;
    private Integer track;
    private Integer length;

    @Builder
    public SongResponseDto(String title, Integer track, Integer length){
        this.title = title;
        this.track = track;
        this.length = length;
    }
}
