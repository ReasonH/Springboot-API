package com.api.music.service;

import com.api.music.domain.playlist.PlayListRepository;
import com.api.music.domain.playlistsong.PlayListSong;
import com.api.music.domain.playlistsong.PlayListSongRepository;
import com.api.music.dto.PlayListAddRequestDto;
import com.api.music.dto.PlayListSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class PlayListService {
    private final MusicService musicService;

    private final PlayListRepository playListRepository;
    private final PlayListSongRepository playListSongRepository;

    @Transactional
    public Long create(PlayListSaveRequestDto requestDto) {
        return playListRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public void addSong(String userId, String name, PlayListAddRequestDto requestDto){
        musicService.findBySongUnits(requestDto.getTitle(), requestDto.getLocale())
                .forEach(song -> playListSongRepository.save(
                        new PlayListSong(playListRepository.findByUserIdAndName(userId, name), song)
                ));
    }

    @Transactional
    public void addAlbum(String userId, String name, PlayListAddRequestDto requestDto) {
        musicService.findByAlbumUnits(requestDto.getTitle(), requestDto.getLocale())
                .forEach(song -> playListSongRepository.save(
                        new PlayListSong(playListRepository.findByUserIdAndName(userId, name), song)
                ));
    }
}
