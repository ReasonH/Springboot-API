package com.api.music.domain.playlistsong;

import com.api.music.domain.playlist.PlayList;
import com.api.music.domain.songs.Song;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class PlayListSong {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "PLAYLIST_ID")
    private PlayList playList;

    @ManyToOne
    @JoinColumn(name = "SONG_ID")
    private Song song;

    @Builder
    public PlayListSong(PlayList playList, Song song){
        this.playList = playList;
        this.song = song;
    }
}
