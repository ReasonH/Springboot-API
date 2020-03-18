package com.api.music.dto.playlist;

import com.api.music.domain.playlist.PlayList;
import com.api.music.domain.playlistsong.PlayListSong;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PlayListSaveRequestDto {
    String userId;
    String name;

    @Builder
    public PlayListSaveRequestDto(String userId, String name){
        this.userId = userId;
        this.name = name;
    }

    public PlayList toEntity(){
        return PlayList.builder()
                .userId(userId)
                .name(name)
                .playListSongs(null)
                .build();
    }
}
