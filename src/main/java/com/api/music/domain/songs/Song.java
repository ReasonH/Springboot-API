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
    private Integer track;

    @Column
    private Integer length;

    @Builder
    public Song(String title, Integer track, Integer length){
        this.title = title;
        this.track = track;
        this.length = length;
    }
}
