package com.tgr.common.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
  // Server Error
  INTERNAL_SERVER_ERROR(500, "S000", "서버에 문제가 생겼습니다."),

  // Client Error
  METHOD_NOT_ALLOWED(405, "C000", "적절하지 않은 HTTP 메소드입니다."),
  INVALID_TYPE_VALUE(400, "C001", "요청 값의 타입이 잘못되었습니다."),
  INVALID_INPUT_VALUE(400, "C002", "적절하지 않은 값입니다."),
  NOT_FOUND(404, "C003", "해당 리소스를 찾을 수 없습니다."),
  BAD_REQUEST(400, "C004", "잘못된 요청입니다."),
  MISSING_REQUEST_PARAMETER(400, "C005", "필수 파라미터가 누락되었습니다."),

  // Songpyeon domain
  SONGPYEON_NOT_FOUND(400, "SP000", "해당 송편이 존재하지 않습니다."),
  CONTENT_IS_BLANK(400, "SP001", "송편에 내용이 Blank 입니다."),
  CONTENT_IS_TOO_LONG(400, "SP002", "송편 내용은 최대 100자입니다."),
  SENDER_IS_TOO_LONG(400, "SP003", "보낸이는 최대 20자입니다."),
  RECEIVER_IS_BLANK(400, "SP004", "송편의 받는이가 Blank 입니다."),
  RECEIVER_IS_TOO_LONG(400, "SP005", "받는이는 최대 20자입니다."),
  HINT_IS_BLANK(400, "SP006", "비밀번호 힌트는 필수입니다."),
  PASSWORD_IS_TOO_LONG(400, "SP007", "비밀번호는 최대 20자입니다."),
  HINT_IS_TOO_LONG(400, "SP008", "비밀번호 힌트는 최대 50자입니다."),
  PASSWORD_IS_WRONG(401, "SP009", "비밀번호가 틀렸습니다.")
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
