package com.api.music.controller;

import com.api.music.dto.SearchResponseDto;
import com.api.music.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
}
