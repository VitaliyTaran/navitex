package com.taran.navitex.controller;

import com.taran.navitex.exception.NavitexServiceException;
import com.taran.navitex.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sensor")
public class SensorController {
    private SensorService service;

    @Autowired
    public void setService(SensorService service) {
        this.service = service;
    }

    @GetMapping("/all/")
    public String showSensors(Model model) {
        model.addAttribute("sensors", service.findAll());
        return "sensors";
    }

    @GetMapping("/{id}")
    public String showSensorById(@PathVariable("id") String id, Model model) {
        try {
            model.addAttribute("sensor", service.find(id));
            return "sensor";
        } catch (NavitexServiceException e) {
            return "error";
        }
    }

}
