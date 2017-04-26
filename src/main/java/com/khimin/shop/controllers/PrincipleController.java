package com.khimin.shop.controllers;

import com.khimin.shop.models.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by khimin on 4/25/17.
 */
@Controller
public class PrincipleController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String currentUserName(@AuthenticationPrincipal User user, Model model) {
//        model.addAttribute("principle", user.getUsername());
        return "hello";
    }
}
