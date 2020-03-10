package com.api.music.domain.album;

import com.api.music.domain.albums.Album;
import com.api.music.domain.albums.AlbumRepository;
import com.api.music.domain.locale.LocaleCode;
import com.api.music.domain.locale.LocaleCodeRepository;
import com.api.music.domain.songs.Song;
import com.api.music.domain.songs.SongRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AlbumTest {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private LocaleCodeRepository localeCodeRepository;

    @Autowired
    private SongRepository songRepository;

    @AfterEach
    public void tearDown() throws Exception {
        albumRepository.deleteAll();
        localeCodeRepository.deleteAll();
        songRepository.deleteAll();
    }

    @Test
    public void querydsl_Custom기능_확인() {
        localeCodeRepository.save(LocaleCode.builder()
                .locale("kr")
                .build());
        localeCodeRepository.save(LocaleCode.builder()
                .locale("jp")
                .build());

        songRepository.save(Song.builder()
                .title("hi")
                .track(120)
                .length(130)
                .build());

        songRepository.save(Song.builder()
                .title("hi2")
                .track(140)
                .length(150)
                .build());

        albumRepository.save(Album.builder()
                .title("hello")
                .localeCodes(localeCodeRepository.findAll())
                .songs(songRepository.findAll())
                .build());

        //when
        List<Album> result = albumRepository.findAll();

        assertEquals(result.size(), 1);
        assertEquals(result.get(0).getLocaleCodes().size(), 2);
    }
}