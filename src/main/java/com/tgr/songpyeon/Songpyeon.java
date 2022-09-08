package com.tgr.songpyeon;

import com.tgr.common.BaseEntity;
import com.tgr.common.exception.ErrorCode;
import com.tgr.common.exception.custom.EssentialFieldBlankException;
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
    this.content = content;
    this.code = code;
    this.sender = sender;
    this.receiver = receiver;
    this.password = password;
    this.hint = hint;
  }

  private void setContent(String content) {
    if (StringUtils.isBlank(content)) {
      throw new EssentialFieldBlankException(ErrorCode.CONTENT_IS_BLANK);
    }
    this.content = content;
  }
}
