package com.vit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;
        
    private List<String> tasks = Arrays.asList("Arestovych", "Vit", "Feygin", "Podolyak", "Reznik", "Zhdanov", "Nevzorov");
    
    private List<String> cities = Arrays.asList("Kyiv", "London", "Paris", "Rome", "Berlin", "Warsaw", "Gdansk");
    
    private List<String> cars = Arrays.asList("Ferrary", "BMW", "Honda", "SSangYong", "Tesla", "Audi", "Lanos");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        model.addAttribute("cities", cities);
        model.addAttribute("cars", cars);

        return "welcome"; //view               
    }

    // /hello?name=java
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") 
			String name, Model model) {

        model.addAttribute("message", name);

        return "welcome"; //view
    }

}
