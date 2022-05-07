package bce.barata.task2.controller;

import bce.barata.task2.models.RegisterModel;
import bce.barata.task2.models.ReturnValues;
import bce.barata.task2.models.User;
import bce.barata.task2.repository.UserRepository;
import org.bouncycastle.util.encoders.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import bce.barata.task2.security.Encoder;

import javax.validation.Valid;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Optional;

@Controller
public class WebController
{
    private final UserRepository userRepo;
    //@Autowired
    //private PasswordEncoder passwordEncoder;


    @Autowired
    public WebController(UserRepository userRepo)
    {
        this.userRepo = userRepo;
    }

    @PostMapping("/home")
    public String loginInfo(@Valid User user, BindingResult bindingResult) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bindingResult.hasErrors())
        {
            return "login";
        }

        Optional<User> validUser = userRepo.findByName(user.getName());
        if (validUser.isEmpty()) {
            return "redirect:/";
        }


        if (!validUser.isEmpty())
        {
            User loginUser = validUser.get();
            System.out.println("created hash "+ Encoder.CustomEncoder(user.getPassword(),loginUser.getSalt()));
            System.out.println("fetched pw "+loginUser.getPassword());
            System.out.println("fetched salt "+loginUser.getSalt().toString());
            if (Encoder.CustomEncoder(user.getPassword(), loginUser.getSalt()).equals(loginUser.getPassword()))
            //if (user.getPassword().equals(loginUser.getPassword()))
            {
                return "home";
            }
        }

        return "redirect:/";
    }

    @RequestMapping("/login")
    public String showLogin(User user) {return "login";}

    @GetMapping("/")
    public String redirectLogin(User user) {return "redirect:/login";}

    @PostMapping("/register")
    public String showRegister(RegisterModel registerModel) {return "register";}

    @PostMapping("/home2")
    public String registerInfo(@Valid RegisterModel registerModel, BindingResult bindingResult) throws NoSuchAlgorithmException, InvalidKeySpecException {
        if (bindingResult.hasErrors())
        {
            return "register";
        }

        final boolean isUserRegistered = userRepo.findByName(registerModel.getName()).isPresent();

        if (!isUserRegistered)
        {
            User regUser = new User();
            ReturnValues rv = new ReturnValues();
            rv = Encoder.CustomEncoder(registerModel.getPassword());
            regUser.setName(registerModel.getName());
            regUser.setPassword(rv.getPassword());
            regUser.setSalt(rv.getSalt());
            //regUser.setPassword(registerModel.getPassword());
            userRepo.save(regUser);
            return "home2";
        }
        if (isUserRegistered)
        {
            return "alreadyuser";
        }
        return "home2";

    }

    /*@PostMapping("/home2")
    public String succRegistPost()
    {
        return "home2";
    }*/

}
