package com.example.sfgpetcare.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class PetController {
    @RequestMapping({"/pets","/pets/index","/pets/index.html"})
    public String getIndex(){
        return "pets/index";
    }
}
