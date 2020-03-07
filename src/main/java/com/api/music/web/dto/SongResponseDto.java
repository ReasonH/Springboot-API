package com.api.music.web.dto;

import lombok.Builder;

public class SongResponseDto {
    private String title;
    private int track;
    private int length;

    @Builder
    public SongResponseDto(String title, int track, int length){
        this.title = title;
        this.track = track;
        this.length = length;
    }
}
