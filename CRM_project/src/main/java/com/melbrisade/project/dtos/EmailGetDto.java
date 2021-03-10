package com.melbrisade.project.dtos;

import lombok.Data;

@Data
public class EmailGetDto {
    private Long id;
    private String recipient;
    private String subject;
    private String content;
    private String template;
    private int status;
}
