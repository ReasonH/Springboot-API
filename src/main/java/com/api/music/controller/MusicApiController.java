package com.api.music.controller;

import com.api.music.dto.AlbumResponseDto;
import com.api.music.dto.SearchResponseDto;
import com.api.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MusicApiController {
    private final MusicService musicService;

    @GetMapping("/api/music")
    public SearchResponseDto findBySearchWord(@RequestParam("title") String title,
                                              @RequestParam("locale") String locale){
        return musicService.findBySearchWord(title, locale);
    }

    @GetMapping("/albums")
    public ResponseEntity<Page<AlbumResponseDto>> getAlbumList(@PageableDefault(size = 10) Pageable pageable,
                                                               @RequestParam("locale") String locale) {
        return new ResponseEntity<>(musicService.findAll(pageable, locale), HttpStatus.OK);
    }
}
