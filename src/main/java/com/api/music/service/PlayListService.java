package com.api.music.service;

import com.api.music.domain.playlist.PlayListRepository;
import com.api.music.domain.playlistsong.PlayListSong;
import com.api.music.domain.playlistsong.PlayListSongRepository;
import com.api.music.dto.playlist.AddType;
import com.api.music.dto.playlist.PlayListResponseDto;
import com.api.music.dto.playlist.PlayListSongAddRequestDto;
import com.api.music.dto.playlist.PlayListSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


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
    public void addSong(String userId, String name, PlayListSongAddRequestDto requestDto){
        musicService.findBySongUnits(requestDto.getTitle(), requestDto.getLocale())
                .forEach(song -> playListSongRepository.save(
                        new PlayListSong(playListRepository.findByUserIdAndName(userId, name), song)
                ));
    }

    @Transactional
    public void addAlbum(String userId, String name, PlayListSongAddRequestDto requestDto) {
        musicService.findByAlbumUnits(requestDto.getTitle(), requestDto.getLocale())
                .forEach(song -> playListSongRepository.save(
                        new PlayListSong(playListRepository.findByUserIdAndName(userId, name), song)
                ));
    }

    @Transactional(readOnly = true)
    public PlayListResponseDto getPlayList(String userId, String name) {
        return new PlayListResponseDto(playListRepository.findByUserIdAndName(userId, name));
    }

    public PlayListResponseDto updatePlayList(AddType addType, String userId,
                                              String name, PlayListSongAddRequestDto requestDto) {
        if(addType == AddType.SONG)
            addSong(userId, name, requestDto);
        else if(addType == AddType.ALBUM)
            addAlbum(userId, name, requestDto);
        return getPlayList(userId, name);
    }

    @Transactional(readOnly = true)
    public List<PlayListResponseDto> getPlayListLists(String userId) {
        return playListRepository.findAllByUserId(userId).stream()
                .map(PlayListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void deletePlayList(String userId, String name) {
        playListRepository.delete(playListRepository.findByUserIdAndName(userId, name));
    }
}
