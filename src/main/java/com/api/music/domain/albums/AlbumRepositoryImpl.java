package com.api.music.domain.albums;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.api.music.domain.albums.QAlbum.album;

@RequiredArgsConstructor
public class AlbumRepositoryImpl implements AlbumRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Album> findBySearchWord(String searchword) {
        return queryFactory.selectFrom(album)
                .where(album.title.like(searchword))
                .fetch();
    }
}
