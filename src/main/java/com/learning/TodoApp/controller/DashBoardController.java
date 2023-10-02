package com.learning.TodoApp.controller;

import com.learning.TodoApp.dto.KharchaSummaryPojo;
import com.learning.TodoApp.entity.Kharcha;
import com.learning.TodoApp.service.DashBoardService;
import com.learning.TodoApp.dto.FromToDateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DashBoardController {
    @Autowired
    DashBoardService dashBoardService;

    @GetMapping("/loadDashboard")
    public String loadDashboard(Model model){
        List<Kharcha> list = dashBoardService.getKharchaList();
        KharchaSummaryPojo kharchaSummaryPojo = dashBoardService.getSummary(list);
        model.addAttribute("kharchaSummary",kharchaSummaryPojo);
        model.addAttribute("dashboardKharchaList",list);
        return "dashboard";
    }

    @PostMapping("/filterKharcha")
    public String filterKharcha(@ModelAttribute FromToDateDTO fromToDateDTO){
        dashBoardService.setKharchaInitializer(fromToDateDTO);
        return "redirect:/loadDashboard";
    }
}
