package com.api.music.web.dto;

import com.api.music.domain.locale.LocaleCode;

public class LocaleCodeResponseDto {
    String locale;

    public LocaleCodeResponseDto(LocaleCode entity){
        this.locale = entity.getLocale();
    }
}
