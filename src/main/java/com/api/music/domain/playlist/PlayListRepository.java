package com.api.music.domain.playlist;

import com.api.music.domain.albums.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
    PlayList findByUserIdAndName(String userId, String name);
}
