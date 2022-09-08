package com.tgr.songpyeon.service;

import com.tgr.songpyeon.repository.SongpyeonRepository;
import org.springframework.stereotype.Service;

@Service
public class SongpyeonService {
  private final SongpyeonRepository songpyeonRepository;

  public SongpyeonService(SongpyeonRepository songpyeonRepository) {
    this.songpyeonRepository = songpyeonRepository;
  }


}
