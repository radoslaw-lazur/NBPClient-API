package com.crud.nbpclient.domain.mail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Mail {
    private String mailTo;
    private String toCc;
    private String subject;
    private String message;
}
