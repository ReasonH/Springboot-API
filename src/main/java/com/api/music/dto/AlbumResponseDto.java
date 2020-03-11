package com.api.music.dto;

import com.api.music.domain.albums.Album;
import com.api.music.domain.locale.LocaleCode;
import com.api.music.domain.songs.Song;
import lombok.Getter;

import java.util.List;

@Getter
public class AlbumResponseDto {
    private String title;
    private List<LocaleCode> locales;
    private List<Song> songs;

    public AlbumResponseDto(Album entity){
        this.title = entity.getTitle();
        this.locales = entity.getLocaleCodes();
        this.songs = entity.getSongs();
    }
    
    public Album toEntity(){
        return Album.builder()
                .title(title)
                .localeCodes(locales)
                .songs(songs)
                .build();
    }
}