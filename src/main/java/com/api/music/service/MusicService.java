package com.api.music.service;

import com.api.music.domain.albums.AlbumRepository;
import com.api.music.dto.AlbumListResponseDto;
import com.api.music.dto.AlbumResponseDto;
import com.api.music.dto.SearchResponseDto;
import com.api.music.dto.SongResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
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
    public List<AlbumResponseDto> findAlbumBySearchWord (String title, String locale) {
        return albumRepository.isRightLocale(locale).stream()
                .filter(album -> album.getTitle().contains(title))
                .map(AlbumResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<SongResponseDto> findSongBySearchWord (String title, String locale) {
        return albumRepository.isRightLocale(locale).stream()
                .flatMap(album -> album.getSongs().stream().filter(song -> song.getTitle().contains(title)))
                .map(SongResponseDto::new)
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
        int requestIndex = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); // page는 index 처럼 0부터 시작
        pageable = PageRequest.of(requestIndex, 10); // page request 생성

        // Querydsl 사용하여 locale code 적용한 상태로 pageable dto를 뽑아온다
        Page<AlbumResponseDto> page = albumRepository.getAlbumList(locale, pageable).map(AlbumResponseDto::new);

        PagedResourcesAssembler<AlbumResponseDto> assembler = new PagedResourcesAssembler<>(null, null);
        PagedModel<EntityModel<AlbumResponseDto>> pagedModel = assembler.toModel(page); // page 객체 기반 pagedModel 생성

        if (!page.isFirst())
            System.out.println(currentUri + "?locale=" + locale + "&page=0&size=10");
        if (!page.isLast())
            System.out.println(currentUri + "?locale=" + locale + "&page=" +
                    String.format("%d", page.getTotalPages()-1) + "&size=10");
        if (page.hasPrevious())
            System.out.println(pagedModel.getPreviousLink().get().getHref());
        if (page.hasNext())
            System.out.println(pagedModel.getNextLink().get().getHref());

        return AlbumListResponseDto.builder()
                .content(page.getContent())
                .build();
    }
}
