package mirea.example.learningenglishmanagementsystem.controllers;

import mirea.example.learningenglishmanagementsystem.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dictionary")
public class WordController {

    @GetMapping("/1000-popular-words")
    public String findOne(@ModelAttribute("user") User user) {
        return "findOne";
    };

}
