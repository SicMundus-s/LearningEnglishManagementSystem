package mirea.example.learningenglishmanagementsystem.controllers;

import lombok.AllArgsConstructor;
import mirea.example.learningenglishmanagementsystem.models.User;
import mirea.example.learningenglishmanagementsystem.services.UserService;
import mirea.example.learningenglishmanagementsystem.services.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@RequestMapping("/simple-english")
@AllArgsConstructor
public class WordController {

    private final UserService userService;
    private final WordService wordService;

    @GetMapping("/1000-popular-words")
    public ModelAndView lastWordPassed() {

        ModelAndView modelAndView = new ModelAndView("1000PopularWords");

        modelAndView.addObject("words", wordService.findAll());

        return modelAndView;
    }


    @PostMapping("/1000-popular-words")
    public void test() {

    }

    @PostMapping("/intervalPov")
    public void intervalPov() {

    }

    private String getLogin(Authentication authentication) {
        String login = null;
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            login = ((UserDetails) principal).getUsername();
        } else {
            login = principal.toString();
        }
        return login;
    }


}
