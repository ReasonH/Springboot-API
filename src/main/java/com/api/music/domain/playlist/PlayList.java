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
    private String userId;

    @Column
    private String name;

    // 삭제 시 관계테이블 요소도 연쇄삭제
    @OneToMany(mappedBy = "playList", cascade = CascadeType.REMOVE)
    private List<PlayListSong> playListSongs;

    @Builder
    public PlayList(String userId, String name, List<PlayListSong> playListSongs){
        this.userId = userId;
        this.name = name;
        this.playListSongs = playListSongs;
    }
}
