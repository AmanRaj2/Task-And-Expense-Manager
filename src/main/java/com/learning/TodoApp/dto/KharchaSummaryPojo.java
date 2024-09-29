package com.learning.TodoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KharchaSummaryPojo {
    private Double onFood;
    private Double onEntertainment;
    private Double onRent;
    private Double onMarketing;
    private Double onMiscellaneous;
    private Double onLoan;
    private Double onInsurance;
    private Double total;
    private Date fromDate;
    private Date toDate;
}
