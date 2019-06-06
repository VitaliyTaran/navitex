package com.taran.navitex.controller;

import com.taran.navitex.service.EdgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
    private EdgeService service;

    @Autowired
    public void setService(EdgeService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String showSensorById() {
        return "home";
    }
    @GetMapping("/edge")
    public String showEdge() {
        return "edge";
    }
}
