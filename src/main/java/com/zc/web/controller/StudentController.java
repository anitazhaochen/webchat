package com.zc.web.controller;

import com.zc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("stu")
public class StudentController {

    @RequestMapping("list")
    public String list(Model model) {
        model.addAttribute("username", "zc");
        model.addAttribute("age", 20);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1001, "zhangsan", "男"));
        studentList.add(new Student(1002, "李四", "男"));
        studentList.add(new Student(1003, "王五", "男"));
        model.addAttribute("studentList", studentList);
        return "stu/list";
    }
}

