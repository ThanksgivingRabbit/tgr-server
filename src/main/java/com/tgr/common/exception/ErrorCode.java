package com.tgr.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  // Server Error
  INTERNAL_SERVER_ERROR(500, "S000", "서버에 문제가 생겼습니다."),

  // Songpyeon domain
  RECORD_NOT_FOUND(400, "SP000", "해당 송편이 존재하지 않습니다."),
  CONTENT_IS_BLANK(400, "SP001", "송편에 내용이 Blank 입니다."),
  CONTENT_IS_TOO_LONG(400, "SP002", "송편 내용은 최대 100자입니다."),
  SENDER_IS_TOO_LONG(400, "SP003", "보낸이는 최대 20자입니다."),
  RECEIVER_IS_BLANK(400, "SP004", "송편의 받는이가 Blank 입니다."),
  RECEIVER_IS_TOO_LONG(400, "SP005", "받는이는 최대 20자입니다."),
  HINT_IS_BLANK(400, "SP006", "비밀번호 힌트는 필수입니다."),
  PASSWORD_IS_TOO_LONG(400, "SP007", "비밀번호는 최대 20자입니다."),
  HINT_IS_TOO_LONG(400, "SP008", "비밀번호 힌트는 최대 50자입니다.")
  ;

  private final int status;
  private final String code;
  private final String message;

  ErrorCode(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }
}
