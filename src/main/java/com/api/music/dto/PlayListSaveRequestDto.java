package com.api.music.dto;

import com.api.music.domain.playlist.PlayList;
import com.api.music.domain.playlistsong.PlayListSong;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class PlayListSaveRequestDto {
    String name;
    String userId;

    @Builder
    public PlayListSaveRequestDto(String name, String userId){
        this.name = name;
        this.userId = userId;
    }

    public PlayList toEntity(){
        return PlayList.builder()
                .name(name)
                .userId(userId)
                .songs(null)
                .build();
    }
}
