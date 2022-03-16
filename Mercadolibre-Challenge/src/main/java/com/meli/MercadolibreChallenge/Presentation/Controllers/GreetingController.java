package com.meli.MercadolibreChallenge.Presentation.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController
{
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
