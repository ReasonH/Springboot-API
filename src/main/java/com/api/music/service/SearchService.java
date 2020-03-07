package com.api.music.service;

import com.api.music.domain.albums.Album;
import com.api.music.domain.albums.AlbumRepository;
import com.api.music.web.dto.AlbumResponseDto;
import com.api.music.web.dto.SearchResponseDto;
import com.api.music.web.dto.SongResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class SearchService {
    private final AlbumRepository albumRepository;
    private final SongResponseDto songResponseDto;
    private final SearchResponseDto searchResponseDto;

    @Transactional
    public SearchResponseDto findByTitle (String title, String locale) {
    }
}
