package com.api.music.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class AlbumListResponseDto {
    AlbumPageLinks pages;
    List<AlbumResponseDto> content;

    @Getter
    public static class AlbumPageLinks {
        String first;
        String prev;
        String last;
        String next;

        @Builder
        public AlbumPageLinks(String first, String prev, String last, String next) {
            this.first = first;
            this.prev = prev;
            this.last = last;
            this.next = next;
        }
    }

    @Builder
    public AlbumListResponseDto(AlbumPageLinks pages, List<AlbumResponseDto> content){
        this.content = content;
        this.pages = pages;
    }

}
