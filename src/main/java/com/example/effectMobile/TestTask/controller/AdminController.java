package com.example.effectMobile.TestTask.controller;

import com.example.effectMobile.TestTask.service.AdminService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    private  final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
}
