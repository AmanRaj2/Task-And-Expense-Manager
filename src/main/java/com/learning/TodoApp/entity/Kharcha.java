package com.learning.TodoApp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "hisab_kitab")
public class Kharcha implements Comparable<Kharcha>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date spentOn;
    KharchaCategory kharchaCategory;
    String description;

    @Override
    public int compareTo(Kharcha o) {
        if(spentOn.before(o.getSpentOn())){
            return 1;
        }
        return -1;
    }
}
