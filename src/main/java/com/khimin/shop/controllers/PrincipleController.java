package com.khimin.shop.controllers;

import com.khimin.shop.annotations.CurrentUser;
import com.khimin.shop.service.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by khimin on 4/25/17.
 */
@Controller
public class PrincipleController {
    private static Logger LOG = LoggerFactory.getLogger(PrincipleController.class);

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String currentUserName(@CurrentUser User user, Model model) {
//        LOG.info(user.getUsername());
////        model.addAttribute("principle", user.getUsername());
//
//        return "hello";
//    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String currentUserName(@CurrentUser MyUserDetailsService.MyUserPrincipal userDetails1, Model model) {
        LOG.info(userDetails1.getUsername()+"yo");

        //        model.addAttribute("principle", user.getUsername());

        return "hello";
    }
}
