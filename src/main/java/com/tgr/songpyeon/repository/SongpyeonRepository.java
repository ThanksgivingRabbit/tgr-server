package com.tgr.songpyeon.repository;

import com.tgr.songpyeon.Songpyeon;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongpyeonRepository extends JpaRepository<Songpyeon, Long> {
  Optional<Songpyeon> findByCode(UUID code);
}
