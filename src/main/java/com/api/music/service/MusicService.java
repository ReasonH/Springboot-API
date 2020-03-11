package com.api.music.service;

import com.api.music.domain.albums.AlbumRepository;
import com.api.music.dto.AlbumResponseDto;
import com.api.music.dto.SearchResponseDto;
import com.api.music.dto.SongResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final AlbumRepository albumRepository;

    @Transactional(readOnly = true)
    public List<AlbumResponseDto> findAlbumBySearchWord (String title, String locale) {
        return albumRepository.isRightLocale(locale).stream()
                .filter(album -> album.getTitle().contains(title))
                .map(AlbumResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongResponseDto> findSongBySearchWord (String title, String locale) {
        return albumRepository.isRightLocale(locale).stream()
                .flatMap(album -> album.getSongs().stream().filter(song -> song.getTitle().contains(title)))
                .map(SongResponseDto::new)
                .collect(Collectors.toList());
    }

    public SearchResponseDto findBySearchWord(String title, String locale) {
        return SearchResponseDto.builder()
                .albums(findAlbumBySearchWord(title, locale))
                .songs(findSongBySearchWord(title, locale))
                .build();
    }
}
