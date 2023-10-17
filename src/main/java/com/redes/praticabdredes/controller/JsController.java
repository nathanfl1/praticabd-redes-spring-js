package com.redes.praticabdredes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JsController {

    @GetMapping("/js/home.js")
    public String home()
    {
        return "js/home.js";
    }
     @GetMapping("/js/list.js")
    public String list()
    {
        return "js/list.js";
    }
    @GetMapping("/js/adicionar.js")
    public String adicionar()
    {
        return "js/adicionar.js";
    }
}
