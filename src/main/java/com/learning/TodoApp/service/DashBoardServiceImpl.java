package com.learning.TodoApp.service;

import com.learning.TodoApp.dto.KharchaSummaryPojo;
import com.learning.TodoApp.entity.Kharcha;
import com.learning.TodoApp.dto.FromToDateDTO;
import com.learning.TodoApp.entity.KharchaCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class DashBoardServiceImpl implements DashBoardService{
    @Autowired
    KharchaService kharchaService;
    @Autowired
    FromToDateDTO fromToDateDTO;
    @Override
    public List<Kharcha> getKharchaList() {
        List<Kharcha> list = kharchaService.getAllKharcha();
        if(fromToDateDTO.getFromDate()!=null){
            list = filterFrom(list, fromToDateDTO.getFromDate());
        }
        if(fromToDateDTO.getToDate()!=null){
            list = filterTo(list, fromToDateDTO.getToDate());
        }
        Collections.sort(list);
        return list;
    }

    @Override
    public void setKharchaInitializer(FromToDateDTO obj) {
        fromToDateDTO.setFromDate(obj.getFromDate());
        fromToDateDTO.setToDate(obj.getToDate());
    }

    @Override
    public KharchaSummaryPojo getSummary(List<Kharcha> list) {
        KharchaSummaryPojo kharchaSummaryPojo = new KharchaSummaryPojo();
        Double onFood = 0.0;
        Double onEntertainment = 0.0;
        Double onRent = 0.0;
        Double onMarketing = 0.0;
        Double onMiscellaneous = 0.0;
        Double onLoan = 0.0;
        Double onInsurance = 0.0;
        Double total = 0.0;
        for(Kharcha kharcha : list){
            KharchaCategory category = kharcha.getKharchaCategory();
            Double amount = kharcha.getAmount();
            total += amount;
            switch (category){
                case FOOD: onFood+=amount;break;
                case RENT: onRent+=amount;break;
                case MARKETING:onMarketing+=amount;break;
                case ENTERTAINMENT:onEntertainment+=amount;break;
                case MISCELLANEOUS:onMiscellaneous+=amount;break;
                case LOAN:onLoan+=amount;break;
                case INSURANCE: onInsurance+=amount;break;
            }
        }
        kharchaSummaryPojo.setTotal(total);
        kharchaSummaryPojo.setOnFood(onFood);
        kharchaSummaryPojo.setOnEntertainment(onEntertainment);
        kharchaSummaryPojo.setOnRent(onRent);
        kharchaSummaryPojo.setOnMarketing(onMarketing);
        kharchaSummaryPojo.setOnMiscellaneous(onMiscellaneous);
        kharchaSummaryPojo.setOnLoan(onLoan);
        kharchaSummaryPojo.setOnInsurance(onInsurance);
        kharchaSummaryPojo.setToDate(fromToDateDTO.getToDate());
        kharchaSummaryPojo.setFromDate(fromToDateDTO.getFromDate());
        return kharchaSummaryPojo;
    }

    private List<Kharcha> filterTo(List<Kharcha> list, Date toDate){
        List<Kharcha> newList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String toDateStr = formatter.format(toDate);
        for(Kharcha kharcha : list){
            String spentOnStr = formatter.format(kharcha.getSpentOn());
            if(toDateStr.compareTo(spentOnStr)>=0){
                newList.add(kharcha);
            }
        }
        return newList;
    }

    private List<Kharcha> filterFrom(List<Kharcha> list, Date fromDate) {
        List<Kharcha> newList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String fromDateStr = formatter.format(fromDate);
        for(Kharcha kharcha : list){
            String spentOnStr = formatter.format(kharcha.getSpentOn());
            if(fromDateStr.compareTo(spentOnStr)<=0){
                newList.add(kharcha);
            }
        }
        return newList;
    }
}
