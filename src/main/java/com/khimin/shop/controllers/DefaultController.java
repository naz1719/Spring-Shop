package com.khimin.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * Created by nazar on 4/15/17.
 */
@Controller
public class DefaultController {
    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ADMIN")) {
            return "redirect:/users";
        }
        return "redirect:/products";
    }
//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String index(Principal principal) {
//        return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
//    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Principal principal) {
        return "index";
    }
}
