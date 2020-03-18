package com.api.music.dto.playlist;

import com.api.music.domain.playlist.PlayList;
import com.api.music.domain.playlistsong.PlayListSong;
import com.api.music.domain.songs.Song;
import com.api.music.dto.musicservice.SongResponseDto;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PlayListResponseDto {
    private String userId;
    private String name;
    private List<Song> songs;

    public PlayListResponseDto(PlayList entity) {
        this.userId = entity.getUserId();
        this.name = entity.getName();
        this.songs = entity.getPlayListSongs().stream().map(PlayListSong::getSong).collect(Collectors.toList());
    }
}
