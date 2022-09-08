package com.tgr.songpyeon.controller;

import com.tgr.common.ApiResponse;
import com.tgr.songpyeon.dto.request.AuthenticateSongpyeonRequest;
import com.tgr.songpyeon.dto.request.CreateSongpyeonRequest;
import com.tgr.songpyeon.dto.response.SongpyeonResponse;
import com.tgr.songpyeon.service.SongpyeonService;
import java.net.URI;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/songpyeons")
@RestController
public class SongpyeonController {
  private final SongpyeonService songpyeonService;

  public SongpyeonController(SongpyeonService songpyeonService) {
    this.songpyeonService = songpyeonService;
  }

  @GetMapping("/{code}")
  public ResponseEntity<ApiResponse<SongpyeonResponse>> getSongpyeon(
      @RequestParam UUID code
  ) {
    ApiResponse<SongpyeonResponse> response = new ApiResponse<>(
        HttpStatus.OK.value(),
        "송편 조회 성공",
        songpyeonService.getSongpyeon(code)
    );
    return ResponseEntity.ok(response);
  }

  @PostMapping
  public ResponseEntity<ApiResponse<SongpyeonResponse>> createSongpyeon(
      @RequestBody CreateSongpyeonRequest request
  ) {
    ApiResponse<SongpyeonResponse> response = new ApiResponse<>(
        HttpStatus.CREATED.value(),
        "송편 생성 성공",
        songpyeonService.createSongpyeon(request)
    );
    return ResponseEntity.created(URI.create("")).body(response);
  }

  @PostMapping("/{code}/authenticate")
  public ResponseEntity<ApiResponse<SongpyeonResponse>> authenticateSongpyeon(
      @RequestParam UUID code,
      @RequestBody AuthenticateSongpyeonRequest request
  ) {
    ApiResponse<SongpyeonResponse> response = new ApiResponse<>(
        HttpStatus.OK.value(),
        "송편 인증 성공",
        songpyeonService.authenticateSongpyeon(code, request)
    );
    return ResponseEntity.ok(response);
  }
}
