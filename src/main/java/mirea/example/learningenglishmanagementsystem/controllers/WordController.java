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

    private final WordService wordService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/1000-popular-words")
    public ModelAndView lastWordPassed(Authentication authentication) {

        ModelAndView modelAndView = new ModelAndView("1000PopularWords");
        Object principal = authentication.getPrincipal();

        String login;
        if(principal instanceof UserDetails) {
            login = ((UserDetails) principal).getUsername();
        } else {
            login = principal.toString();
        }

        modelAndView.addObject("word", userService.findByLogin(login).getPopularWordId());

        return modelAndView;
    }

    @PostMapping()
    public String nextWord(@RequestParam(name = "word") String word) {

        System.out.println(word);
        return "redirect:/simple-english/1000-popular-words";
    }


}
