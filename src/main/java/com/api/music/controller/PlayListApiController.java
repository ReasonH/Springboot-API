package com.api.music.controller;

import com.api.music.dto.playlist.AddType;
import com.api.music.dto.playlist.PlayListResponseDto;
import com.api.music.dto.playlist.PlayListSongAddRequestDto;
import com.api.music.dto.playlist.PlayListSaveRequestDto;
import com.api.music.service.PlayListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;
import java.util.List;

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
    public ResponseEntity<PlayListResponseDto> addSong(@PathVariable("userid") String userid,
                                                       @PathVariable("name") String name,
                                                       @RequestBody PlayListSongAddRequestDto requestDto,
                                                       @RequestParam("type")AddType addType) {
        return new ResponseEntity<>(playListService.updatePlayList(addType, userid, name, requestDto), HttpStatus.ACCEPTED);
    }

    @GetMapping("/playlists/{userid}")
    public ResponseEntity<List<PlayListResponseDto>> getPlayList(@PathVariable("userid") String userid){
        return new ResponseEntity<>(playListService.getPlayListLists(userid), HttpStatus.OK);
    }

    @DeleteMapping("/playlists/{userid}/lists/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePlayList(@PathVariable("userid") String userid,
                               @PathVariable("name") String name){
        playListService.deletePlayList(userid, name);
    }
}
