package bce.barata.ZH2_03.controller;

import bce.barata.ZH2_03.models.RegisterModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Controller
public class WebController
{
    @GetMapping("/")
    public String redirectLogin(RegisterModel registerModel) {return "register";}

    @PostMapping("/register")
    public String showRegister(RegisterModel registerModel) {return "register";}

    @PostMapping("/home2")
    public String registerInfo(@Valid RegisterModel registerModel, BindingResult bindingResult) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bindingResult.hasErrors())
        {
            return "register";
        }
        if (registerModel.getPassword().equals(registerModel.getPassword2()))
        {
            return "home2";
        }

        return "register";

    }
}
