package com.tgr.common.exception;

import lombok.Getter;

@Getter
public class ErrorResponse {
  private final int status;
  private final String code;
  private final String message;

  public ErrorResponse(int status, String code, String message) {
    this.status = status;
    this.code = code;
    this.message = message;
  }

  public static ErrorResponse of(ErrorCode errorCode) {
    return new ErrorResponse(errorCode.getStatus(), errorCode.getCode(), errorCode.getMessage());
  }
}
