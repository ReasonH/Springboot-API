package com.api.music.domain.albums;

import com.api.music.domain.locale.LocaleCode;
import com.api.music.domain.songs.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    private List<LocaleCode> localeCodes = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private List<Song> songs = new ArrayList<>();

    @Builder
    public Album(String title, List<LocaleCode> localeCodes , List<Song> songs){
        this.title = title;
        this.localeCodes = localeCodes;
        this.songs = songs;
    }
}
