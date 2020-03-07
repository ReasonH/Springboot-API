package com.api.music.domain.songs;

import com.api.music.domain.albums.Album;
import com.api.music.domain.albums.AlbumRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRepository extends JpaRepository<Album, Long> {
}
