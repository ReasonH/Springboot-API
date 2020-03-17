package com.api.music.controller;

import com.api.music.dto.AddType;
import com.api.music.dto.PlayListAddRequestDto;
import com.api.music.dto.PlayListSaveRequestDto;
import com.api.music.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PlayListApiController {
    final PlayListService playListService;

    @PostMapping("/playlists")
    public Long createPlayList(@RequestBody PlayListSaveRequestDto
                               requestDto) {
        return playListService.create(requestDto);
    }

    @PutMapping("/playlists/{userid}/lists/{name}")
    public void addSong(@PathVariable("userid") String userid,
                        @PathVariable("name") String name,
                        @RequestBody PlayListAddRequestDto requestDto,
                        @RequestParam("type")AddType addType
                        ){
        if (addType == AddType.SONG)
            playListService.addSong(userid, name, requestDto);
        else if (addType == AddType.ALBUM)
            playListService.addAlbum(userid, name, requestDto);

    }
}
