package com.memo.gymapi.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    //private final MainService mainService;

    @GetMapping(value ="/welcome")
    public String welcome(Model model) {
        model.addAttribute("firstName", "Guillermo");
        //mainService.fillModel(model, jwt);
        return "welcome";
    }

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="unknown") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}