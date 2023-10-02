package com.learning.TodoApp.service;

import com.learning.TodoApp.entity.Kharcha;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public interface KharchaService {
    List<Kharcha> getAllKharcha();
    Optional<Kharcha> getKharchaById(Integer id);
    void deleteKharchaById(Integer id);
    void addKharcha(Kharcha kharcha);
    void updateKharcha(Kharcha kharcha);

}
