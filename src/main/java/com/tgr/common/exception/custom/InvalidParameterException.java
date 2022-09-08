package com.tgr.common.exception.custom;

import com.tgr.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class InvalidParameterException extends RuntimeException{
  private final ErrorCode errorCode;

  public InvalidParameterException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
