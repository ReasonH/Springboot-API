package com.api.music.domain.albums;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlbum is a Querydsl query type for Album
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAlbum extends EntityPathBase<Album> {

    private static final long serialVersionUID = -2061070107L;

    public static final QAlbum album = new QAlbum("album");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<String, StringPath> locale = this.<String, StringPath>createList("locale", String.class, StringPath.class, PathInits.DIRECT2);

    public final ListPath<com.api.music.domain.songs.Song, com.api.music.domain.songs.QSong> songs = this.<com.api.music.domain.songs.Song, com.api.music.domain.songs.QSong>createList("songs", com.api.music.domain.songs.Song.class, com.api.music.domain.songs.QSong.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public QAlbum(String variable) {
        super(Album.class, forVariable(variable));
    }

    public QAlbum(Path<? extends Album> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlbum(PathMetadata metadata) {
        super(Album.class, metadata);
    }

}

