package com.api.music.domain.playlist;

import com.api.music.domain.albums.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayListRepository extends JpaRepository<PlayList, Long> {
    PlayList findByUserIdAndName(String userId, String name);
    List<PlayList> findAllByUserId(String userId);
}
