package com.api.music.dto;

import com.api.music.domain.locale.LocaleCode;
import lombok.Getter;

@Getter
public class LocaleCodeResponseDto {
    String locale;

    public LocaleCodeResponseDto(LocaleCode entity){
        this.locale = entity.getLocale();
    }
}
