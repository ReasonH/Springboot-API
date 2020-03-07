package com.api.music.domain.albums;

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

    @ElementCollection
    @CollectionTable(
            name = "LOCALES",
            joinColumns = @JoinColumn(name = "id")
    )
    @Column
    private List<String> locale = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY)
    private List<Song> songs = new ArrayList<Song>();

    @Builder
    public Album(String title, List<String> locale, List<Song> songs){
        this.title = title;
        this.locale = locale;
        this.songs = songs;
    }
}
