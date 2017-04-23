package com.khimin.shop.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * Created by khimin on 4/23/17.
 */
@Controller
public class UserCabinetController {
    private static Logger LOG = LoggerFactory.getLogger(UserCabinetController.class);
//
//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    @ResponseBody
//    public String currentUserName(Principal principal) {
//        LOG.info(principal.getName());
//        return principal.getName();
//    }
}
