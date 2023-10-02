package com.learning.TodoApp.utils;

import com.learning.TodoApp.entity.TaskStatus;
import com.learning.TodoApp.entity.ToDoTask;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Utility {
    public static List<ToDoTask> filterCompletedTask(List<ToDoTask> list) {
        List<ToDoTask> list1 = list.stream().filter(value->value.getStatus()==TaskStatus.COMPLETED).toList();
        return list1;
    }

    public static List<ToDoTask> filterNotCompleted(List<ToDoTask> list) {
        return list.stream().filter(value->value.getStatus()!=TaskStatus.COMPLETED).toList();
    }

    public static String formatDate(Date date){
        if(date ==null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy hh:mm a");
        String strDate = formatter.format(date);
        return strDate;
    }

    public static String formatDate2(Date date){
        if(date ==null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }

    public static String formatDate3(Date date){
        if(date ==null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        String strDate = formatter.format(date);
        return strDate;
    }
}
