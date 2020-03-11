package com.api.music.dto;

import com.api.music.domain.songs.Song;
import lombok.Getter;

@Getter
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
