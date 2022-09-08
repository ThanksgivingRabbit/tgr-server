package com.tgr.common.exception.custom;

import com.tgr.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class AuthenticateException extends RuntimeException{
  private final ErrorCode errorCode;

  public AuthenticateException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
