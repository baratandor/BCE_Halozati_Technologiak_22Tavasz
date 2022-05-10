package edu.corvinus.ZH2_02.controller;

import edu.corvinus.ZH2_02.service.RequestService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class WebController
{
    @Autowired
    private RequestService requestService;
    @RequestMapping("/")
    public String index(HttpServletRequest request)
    {

        String clientIp = requestService.getClientIPAddress(request);
        System.out.println(clientIp.substring(0,7));

        if (clientIp.substring(0,7).equals("146.110"))
        {
            return "corvo";
        }


        return "nemcorvo";
    }

}
