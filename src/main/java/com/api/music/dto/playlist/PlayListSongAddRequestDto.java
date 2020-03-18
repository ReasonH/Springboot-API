package com.api.music.dto.playlist;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PlayListSongAddRequestDto {
    String locale;
    String title;

    @Builder
    public PlayListSongAddRequestDto(String locale, String title){
        this.locale = locale;
        this.title = title;
    }
}
