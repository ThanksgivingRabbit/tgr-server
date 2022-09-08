package com.tgr.songpyeon.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tgr.songpyeon.Songpyeon;
import java.util.UUID;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class SongpyeonResponse {
  private final UUID code;
  private final String content;
  private final String sender;
  private final String receiver;
  private final String hint;

  private SongpyeonResponse(UUID code, String content, String sender, String receiver, String hint) {
    this.code = code;
    this.content = content;
    this.sender = sender;
    this.receiver = receiver;
    this.hint = hint;
  }

  public SongpyeonResponse(Songpyeon entity) {
    this(entity.getCode(), entity.getContent(), entity.getSender(), entity.getReceiver(), null);
  }

  public SongpyeonResponse(String hint) {
    this(null, null, null, null, hint);
  }
}
