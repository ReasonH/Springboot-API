package com.api.music.domain.locale;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class LocaleCode {
    @Id
    @Column(name = "localeId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String locale;

    @Builder
    public LocaleCode(String locale) {
        this.locale = locale;
    }
}
