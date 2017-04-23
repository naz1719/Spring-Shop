package com.khimin.shop.controllers;

import com.khimin.shop.service.UserService;
import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by khimin on 4/23/17.
 */
@Controller
public class SingUpController {
    private static Logger LOG = LoggerFactory.getLogger(SingUpController.class);

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("registration")
    public String newProduct(Model model) {
        model.addAttribute("user", new User());
        return "singUp/registration";
    }

    /**
     * Save user to database.
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveProduct(User user) throws UsernameNotFoundException, EmailExistsException {
        userService.registerNewUserAccount(user);
        LOG.info("Save user: " + user);
        return "redirect:/user/" + user.getId();
    }
}
