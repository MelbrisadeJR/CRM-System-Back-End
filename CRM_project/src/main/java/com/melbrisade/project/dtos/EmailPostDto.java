package com.melbrisade.project.dtos;

import lombok.Data;

@Data
public class EmailPostDto {
    private String recipient;
    private String subject;
    private String content;
    private String template;
    private int status;
}
