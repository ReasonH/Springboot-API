package com.api.music.web.dto;

import com.api.music.domain.songs.Song;
import lombok.Builder;


public class SongResponseDto {
    private String title;
    private Integer track;
    private Integer length;

    public SongResponseDto(Song entity){
        this.title = entity.getTitle();
        this.track = entity.getTrack();
        this.length = entity.getLength();
    }
}
