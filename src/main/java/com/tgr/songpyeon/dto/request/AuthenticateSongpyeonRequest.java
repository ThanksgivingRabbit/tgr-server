package com.tgr.songpyeon.dto.request;

import javax.validation.constraints.NotBlank;

public record AuthenticateSongpyeonRequest(@NotBlank String password) {

}
