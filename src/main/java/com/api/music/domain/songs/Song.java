package com.api.music.domain.songs;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private int track;

    @Column
    private int length;

    @Builder
    public Song(String title, int track, int length){
        this.title = title;
        this.track = track;
        this.length = length;
    }
}
