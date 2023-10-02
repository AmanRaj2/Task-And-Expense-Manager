package com.learning.TodoApp.service;

import com.learning.TodoApp.dto.KharchaSummaryPojo;
import com.learning.TodoApp.entity.Kharcha;
import com.learning.TodoApp.dto.FromToDateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DashBoardService {
    List<Kharcha> getKharchaList();

    void setKharchaInitializer(FromToDateDTO fromToDateDTO);

    KharchaSummaryPojo getSummary(List<Kharcha> list);
}
