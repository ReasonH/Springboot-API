package com.api.music.domain.albums;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.api.music.domain.albums.QAlbum.album;
import static com.api.music.domain.songs.QSong.song;

@RequiredArgsConstructor
public class AlbumRepositoryImpl implements AlbumRepositoryCustom{
    private final JPAQueryFactory queryFactory;

    @Override
    public List<Album> isRightLocale(String locale) {
        return queryFactory.selectFrom(album)
                .where(validateCopyright(locale))
                .fetch();
        //TO-DO: return dto로 변경
    }
    private BooleanExpression validateCopyright(String locale){
        if(StringUtils.isEmpty(locale)){
            return null;
        }
        return album.localeCodes.any().locale.in(locale, "all");
    }
}
