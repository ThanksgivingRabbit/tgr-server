package com.tgr.common.exception;

import com.tgr.common.exception.custom.AuthenticateException;
import com.tgr.common.exception.custom.InvalidParameterException;
import com.tgr.common.exception.custom.RecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
  // 500 : Internal Server Error
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorResponse> handleServerException(Exception e) {
    return handleException(e, ErrorCode.INTERNAL_SERVER_ERROR);
  }

  // 405 : Method Not Allowed
  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(
      HttpRequestMethodNotSupportedException e) {
    return handleException(e, ErrorCode.METHOD_NOT_ALLOWED);
  }

  // 400 : MethodArgumentNotValidException
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
      MethodArgumentNotValidException e) {
    return handleException(e, ErrorCode.INVALID_TYPE_VALUE);
  }

  // 400 : MethodArgumentType
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> handleMethodArgumentTypeMismatchException(
      MethodArgumentTypeMismatchException e) {
    return handleException(e, ErrorCode.INVALID_TYPE_VALUE);
  }

  // 400 : Bad Request, ModelAttribute
  @ExceptionHandler(org.springframework.validation.BindException.class)
  public ResponseEntity<ErrorResponse> handleBindException(BindException e) {
    return handleException(e, ErrorCode.INVALID_INPUT_VALUE);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<ErrorResponse> handleHttpMessageNotReadableException(
      HttpMessageNotReadableException e) {
    return handleException(e, ErrorCode.INVALID_INPUT_VALUE);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
    return handleException(e, ErrorCode.INVALID_INPUT_VALUE);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<ErrorResponse> handleNoHandlerFoundException(NoHandlerFoundException e) {
    return handleException(e, ErrorCode.NOT_FOUND);
  }

  @ExceptionHandler(MissingServletRequestParameterException.class)
  public ResponseEntity<ErrorResponse> handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
    return handleException(e, ErrorCode.MISSING_REQUEST_PARAMETER);
  }

  /**
   * 400: Custom Excpetion
   */

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleRecordNotFoundException(RecordNotFoundException e) {
    return handleException(e, e.getErrorCode());
  }

  @ExceptionHandler(InvalidParameterException.class)
  public ResponseEntity<ErrorResponse> handleInvalidParameterException(InvalidParameterException e) {
    return handleException(e, e.getErrorCode());
  }

  @ExceptionHandler(AuthenticateException.class)
  public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticateException e) {
    return handleException(e, e.getErrorCode());
  }

  private ResponseEntity<ErrorResponse> handleException(Exception e, ErrorCode errorCode) {
    log.warn(e.getMessage(), e);
    ErrorResponse errorResponse = ErrorResponse.of(errorCode);
    return ResponseEntity.status(errorResponse.getStatus()).body(errorResponse);
  }
}
