package com.api.music.controller;

import com.api.music.dto.musicservice.AlbumListResponseDto;
import com.api.music.dto.musicservice.SearchResponseDto;
import com.api.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
public class MusicApiController {
    private final MusicService musicService;

    @GetMapping("/music")
    public SearchResponseDto findBySearchWord(@RequestParam("title") String title,
                                              @RequestParam("locale") String locale){
        return musicService.findBySearchWord(title, locale);
    }

    @GetMapping("/albums")
    public ResponseEntity<AlbumListResponseDto> getAlbumList(@PageableDefault(size = 10) Pageable pageable,
                                             @RequestParam("locale") String locale,
                                             HttpServletRequest httpServletRequest) {
        return new ResponseEntity<>(musicService.getAlbumList(pageable, locale, httpServletRequest.getRequestURL()), HttpStatus.OK);
    }
}