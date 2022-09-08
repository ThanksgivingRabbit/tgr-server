package com.tgr.common.exception.custom;

import com.tgr.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class RecordNotFoundException extends RuntimeException{
  private final ErrorCode errorCode;

  public RecordNotFoundException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }
}
