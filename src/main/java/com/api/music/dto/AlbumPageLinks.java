package com.api.music.dto;

import lombok.Builder;

public class AlbumPageLinks {
    String first;
    String prev;
    String last;
    String next;

    @Builder
    public AlbumPageLinks(String first, String prev, String last, String next){
        this.first = first;
        this.prev = prev;
        this.last = last;
        this.next = next;
    }
}
