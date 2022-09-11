package com.tgr.songpyeon.dto.request;

import javax.validation.constraints.NotBlank;

public record CreateSongpyeonRequest(@NotBlank String content, String sender,
                                     @NotBlank String receiver, String password,
                                     String hint) {
}
