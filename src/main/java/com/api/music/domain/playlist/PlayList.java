package com.api.music.domain.playlist;

import com.api.music.domain.playlistsong.PlayListSong;
import com.api.music.domain.songs.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String userId;

    @OneToMany(mappedBy = "playList")
    private List<PlayListSong> songs;

    @Builder
    public PlayList(String name, String userId, List<PlayListSong> songs){
        this.name = name;
        this.userId = userId;
        this.songs = songs;
    }
}
