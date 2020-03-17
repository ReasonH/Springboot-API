package com.api.music.service;

import com.api.music.domain.albums.Album;
import com.api.music.domain.albums.AlbumRepository;
import com.api.music.domain.songs.Song;
import com.api.music.dto.AlbumListResponseDto;
import com.api.music.dto.AlbumResponseDto;
import com.api.music.dto.SearchResponseDto;
import com.api.music.dto.SongResponseDto;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MusicService {
    private final AlbumRepository albumRepository;

    @Transactional(readOnly = true)
    public List<AlbumResponseDto> findAlbumBySearchWord (String searchWord, String locale) {
        return albumRepository.isRightLocale(locale).stream()
                .filter(album -> album.getTitle().contains(searchWord))
                .map(AlbumResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongResponseDto> findSongBySearchWord (String searchWord, String locale) {
        return albumRepository.isRightLocale(locale).stream()
                .flatMap(album -> album.getSongs().stream().filter(song -> song.getTitle().contains(searchWord)))
                .map(SongResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Song> findBySongUnits(String title, String locale){
        return albumRepository.isRightLocale(locale).stream()
                .flatMap(album -> album.getSongs().stream().filter(song -> song.getTitle().equals(title)))
                .collect(Collectors.toList());
    }

    @Transactional
    public List<Song> findByAlbumUnits(String title, String locale){
        return albumRepository.isRightLocale(locale).stream()
                .filter(album -> album.getTitle().equals(title))
                .flatMap(album -> album.getSongs().stream())
                .collect(Collectors.toList());
    }

    public SearchResponseDto findBySearchWord(String title, String locale) {
        return SearchResponseDto.builder()
                .albums(findAlbumBySearchWord(title, locale))
                .songs(findSongBySearchWord(title, locale))
                .build();
    }

    @Transactional(readOnly = true)
    public AlbumListResponseDto getAlbumList(Pageable pageable, String locale, StringBuffer currentUri) {
        int requestIndex = (pageable.getPageNumber() - 1); // page index는 내부적으로는 0부터 시작
        pageable = PageRequest.of(requestIndex, 10); // page request 생성

        // Querydsl 사용하여 locale code 적용한 상태로 pageable dto를 뽑아온다
        Page<AlbumResponseDto> page = albumRepository.getAlbumList(locale, pageable).map(AlbumResponseDto::new);

//        PagedResourcesAssembler<AlbumResponseDto> assembler = new PagedResourcesAssembler<>(null, null);
//        PagedModel<EntityModel<AlbumResponseDto>> pagedModel = assembler.toModel(page); // page 객체 기반 pagedModel 생성

        String first = null;
        if (!page.isFirst())
            first = (currentUri + "?locale=" + locale + "&page=1");
        String prev = null;
        if (page.hasPrevious())
            prev = (currentUri + "?locale=" + locale + "&page=" +
                    String.format("%d", pageable.getPageNumber()));
        String last = null;
        if (!page.isLast())
            last = (currentUri + "?locale=" + locale + "&page=" +
                    String.format("%d", page.getTotalPages()));
        String next = null;
        if (page.hasNext())
            next = (currentUri + "?locale=" + locale + "&page=" +
                    String.format("%d", pageable.getPageNumber()+2));

//        String prev = pagedModel.getPreviousLink().map(Link::getHref).orElse(null);
//        String next = pagedModel.getNextLink().map(Link::getHref).orElse(null);;

        return AlbumListResponseDto.builder()
                .pages(AlbumListResponseDto.AlbumPageLinks.builder()
                        .first(first)
                        .prev(prev)
                        .last(last)
                        .next(next)
                        .build()
                ).content(page.getContent())
                .build();
    }
}
