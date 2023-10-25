package de.cegos.springproject1.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    @GetMapping(value = "/greeting")
public String greeting(@RequestParam(name = "name", required = false, defaultValue = "world") String name, Model model){
        System.out.printf("Received name %s\n", name);
        model.addAttribute("name", name);
        return "greeting";
    }
}
