package edu.corvinus.ZH2_03.controller;

import edu.corvinus.ZH2_03.model.RegisterModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
public class RegisterController
{
    @Controller
    public class WebController implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/home2").setViewName("home2");
        }

        @GetMapping("/")
        public String showForm(@Valid RegisterModel registerModel) {
            return "register";
        }

        @PostMapping("/")
        public String checkPersonInfo(@Valid RegisterModel registerModel, BindingResult bindingResult) {

            if (bindingResult.hasErrors()) {
                return "regerror";
            }

            return "redirect:/home2";
        }
    }
}
