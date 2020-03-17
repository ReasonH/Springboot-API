package com.api.music.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class PlayListAddRequestDto {
    String locale;
    String title;

    @Builder
    public PlayListAddRequestDto(String locale, String title){
        this.locale = locale;
        this.title = title;
    }
}
