package com.redes.praticabdredes.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index()
    {
        return "/html/index.html";
    }
    @GetMapping("/adicionar")
    public String add()
    {
        return "/html/adicionar.html";
    }
}
