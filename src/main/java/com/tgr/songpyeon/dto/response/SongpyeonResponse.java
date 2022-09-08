package com.tgr.songpyeon.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.tgr.songpyeon.Songpyeon;
import lombok.Getter;

@Getter
@JsonInclude(Include.NON_NULL)
public class SongpyeonResponse {
  private final String content;
  private final String sender;
  private final String receiver;
  private final String hint;

  private SongpyeonResponse(String content, String sender, String receiver, String hint) {
    this.content = content;
    this.sender = sender;
    this.receiver = receiver;
    this.hint = hint;
  }

  public SongpyeonResponse(Songpyeon entity) {
    this(entity.getContent(), entity.getSender(), entity.getReceiver(), null);
  }

  public SongpyeonResponse(String hint) {
    this(null, null, null, hint);
  }
}
