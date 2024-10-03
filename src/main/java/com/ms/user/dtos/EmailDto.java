package com.ms.user.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public record EmailDto(UUID userId,
                       String emailTo,
                       String Subject,
                       String text) {
}
