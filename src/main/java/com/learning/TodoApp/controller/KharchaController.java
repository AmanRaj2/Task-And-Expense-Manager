package com.learning.TodoApp.controller;

import com.learning.TodoApp.entity.Kharcha;
import com.learning.TodoApp.service.KharchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
//@RequestMapping("kharcha")
public class KharchaController {
    @Autowired
    KharchaService kharchaService;

    @GetMapping("/kharchaHome")
    public String kharchaHome(Model model){
        List<Kharcha> list = kharchaService.getAllKharcha();
        Collections.sort(list);
        model.addAttribute("kharchaList",list);
        return "kharchaHome";
    }

    @PostMapping("/saveKharcha")
    public String saveKharcha(@ModelAttribute Kharcha kharcha){
        System.out.println(kharcha.getAmount());
        kharchaService.addKharcha(kharcha);
        return "redirect:/kharchaHome";
    }

    @GetMapping("/deleteKharcha/{id}")
    public String deleteKharcha(@PathVariable Integer id){
        kharchaService.deleteKharchaById(id);
        return "redirect:/kharchaHome";
    }
}
