package com.learning.TodoApp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Getter
@Setter
@NoArgsConstructor
public class FromToDateDTO {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date fromDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date toDate;
}
