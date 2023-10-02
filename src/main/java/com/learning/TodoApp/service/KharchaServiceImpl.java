package com.learning.TodoApp.service;

import com.learning.TodoApp.entity.Kharcha;
import com.learning.TodoApp.repository.KharchaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KharchaServiceImpl implements KharchaService{

    @Autowired
    KharchaRepo kharchaRepo;

    @Override
    public List<Kharcha> getAllKharcha() {
        return kharchaRepo.findAll();
    }

    @Override
    public Optional<Kharcha> getKharchaById(Integer id) {
        return kharchaRepo.findById(id);
    }

    @Override
    public void deleteKharchaById(Integer id) {
        kharchaRepo.deleteById(id);
    }

    @Override
    public void addKharcha(Kharcha kharcha) {
        kharchaRepo.save(kharcha);
    }

    @Override
    public void updateKharcha(Kharcha kharcha) {
        kharchaRepo.save(kharcha);
    }
}
