package com.api.music.domain.albums;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.api.music.domain.albums.QAlbum.album;

public class AlbumRepositoryImpl extends QuerydslRepositorySupport implements AlbumRepositoryCustom{

    private final JPAQueryFactory queryFactory;
    public AlbumRepositoryImpl(JPAQueryFactory queryFactory) {
        super(Album.class);
        this.queryFactory = queryFactory;
    }

    @Override
    public List<Album> isRightLocale(String locale) {
        return queryFactory.selectFrom(album)
                .where(validateCopyright(locale))
                .fetch();
        //TO-DO: return dto로 변경
    }

    @Override
    public Page<Album> getAlbumList(String locale, Pageable pageable) {
        JPQLQuery<Album> query;
        query = queryFactory.selectFrom(album)
                .where(validateCopyright(locale));

        List<Album> albums = getQuerydsl().applyPagination(pageable, query).fetch();
        return new PageImpl<>(albums, pageable, query.fetchCount());
    }

    private BooleanExpression validateCopyright(String locale){
        if(StringUtils.isEmpty(locale)){
            return null;
        }
        return album.localeCodes.any().locale.in(locale, "all");
    }
}
