package com.tgr.common;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
  private Integer status;
  private String message;
  private T data;

  @Builder
  public ApiResponse(Integer status, String message, T data) {
    this.message = message;
    this.status = status;
    this.data = data;
  }
}
