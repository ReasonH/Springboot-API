package com.api.music.domain.songs;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSong is a Querydsl query type for Song
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSong extends EntityPathBase<Song> {

    private static final long serialVersionUID = -1610806203L;

    public static final QSong song = new QSong("song");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> length = createNumber("length", Integer.class);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> track = createNumber("track", Integer.class);

    public QSong(String variable) {
        super(Song.class, forVariable(variable));
    }

    public QSong(Path<? extends Song> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSong(PathMetadata metadata) {
        super(Song.class, metadata);
    }

}

