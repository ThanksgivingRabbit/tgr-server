package com.tgr.songpyeon.service;

import com.tgr.common.exception.ErrorCode;
import com.tgr.common.exception.custom.AuthenticateException;
import com.tgr.common.exception.custom.RecordNotFoundException;
import com.tgr.songpyeon.Songpyeon;
import com.tgr.songpyeon.dto.request.AuthenticateSongpyeonRequest;
import com.tgr.songpyeon.dto.request.CreateSongpyeonRequest;
import com.tgr.songpyeon.dto.response.SongpyeonResponse;
import com.tgr.songpyeon.repository.SongpyeonRepository;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SongpyeonService {
  private final SongpyeonRepository songpyeonRepository;

  public SongpyeonService(SongpyeonRepository songpyeonRepository) {
    this.songpyeonRepository = songpyeonRepository;
  }

  @Transactional(readOnly = true)
  public SongpyeonResponse getSongpyeon(UUID code) {
    Songpyeon songpyeon = findSongpyeonByCode(code);
    if (songpyeon.isSecure()) {
      return new SongpyeonResponse(songpyeon.getHint());
    }
    return new SongpyeonResponse(songpyeon);
  }

  @Transactional(readOnly = true)
  public SongpyeonResponse authenticateSongpyeon(UUID code, AuthenticateSongpyeonRequest request) {
    Songpyeon songpyeon = findSongpyeonByCode(code);
    if (songpyeon.authenticate(request.password())) {
      return new SongpyeonResponse(songpyeon);
    }
    throw new AuthenticateException(ErrorCode.PASSWORD_IS_WRONG);
  }

  public SongpyeonResponse createSongpyeon(CreateSongpyeonRequest request) {
    Songpyeon songpyeon = Songpyeon.builder()
        .content(request.content())
        .sender(request.sender())
        .receiver(request.receiver())
        .password(request.password())
        .hint(request.hint())
        .build();
    songpyeonRepository.save(songpyeon);
    return new SongpyeonResponse(songpyeon);
  }

  private Songpyeon findSongpyeonByCode(UUID code) {
    return songpyeonRepository
        .findByCode(code)
        .orElseThrow(() -> new RecordNotFoundException(ErrorCode.SONGPYEON_NOT_FOUND));
  }
}
