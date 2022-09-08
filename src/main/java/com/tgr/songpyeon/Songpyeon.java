package com.tgr.songpyeon;

import com.tgr.common.BaseEntity;
import com.tgr.common.exception.ErrorCode;
import com.tgr.common.exception.custom.InvalidParameterException;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "songpyeon")
public class Songpyeon extends BaseEntity {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "songpyeon_id")
  private Long id;

  @Column(name = "content", length = 100, nullable = false)
  private String content;

  @Column(name = "code", nullable = false, unique = true)
  private UUID code;

  @Column(name = "sender", length = 20)
  private String sender;

  @Column(name = "receiver", length = 20, nullable = false)
  private String receiver;

  @Column(name = "password", length = 20)
  private String password;

  @Column(name = "hint", length = 50)
  private String hint;

  @Builder
  public Songpyeon(String content, UUID code, String sender, String receiver,
      String password, String hint) {
    setContent(content);
    setCode(code);
    setSender(sender);
    setReceiver(receiver);
    setPassword(password, hint);
  }

  private void setContent(String content) {
    if (StringUtils.isBlank(content)) {
      throw new InvalidParameterException(ErrorCode.CONTENT_IS_BLANK);
    }
    if (content.length() > 100) {
      throw new InvalidParameterException(ErrorCode.CONTENT_IS_TOO_LONG);
    }
    this.content = content;
  }

  private void setCode(UUID code) {
    if (Objects.isNull(code)) {
      this.code = UUID.randomUUID();
      return;
    }
    this.code = code;
  }

  private void setSender(String sender) {
    if (StringUtils.isBlank(content)) {
      this.sender = null;
      return;
    }
    if (sender.length() > 20) {
      throw new InvalidParameterException(ErrorCode.CONTENT_IS_TOO_LONG);
    }
    this.sender = sender;
  }

  private void setReceiver(String receiver) {
    if (StringUtils.isBlank(receiver)) {
      throw new InvalidParameterException(ErrorCode.RECEIVER_IS_BLANK);
    }
    if (receiver.length() > 20) {
      throw new InvalidParameterException(ErrorCode.RECEIVER_IS_TOO_LONG);
    }
    this.receiver = receiver;
  }

  private void setPassword(String password, String hint) {
    if (StringUtils.isBlank(password)) {
      return;
    }
    if (StringUtils.isBlank(hint)) {
      throw new InvalidParameterException(ErrorCode.HINT_IS_BLANK);
    }
    if (password.length() > 20) {
      throw new InvalidParameterException(ErrorCode.PASSWORD_IS_TOO_LONG);
    }
    if (hint.length() > 50) {
      throw new InvalidParameterException(ErrorCode.HINT_IS_TOO_LONG);
    }
    this.password = password;
    this.hint = hint;
  }
}
