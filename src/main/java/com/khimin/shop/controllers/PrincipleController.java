package com.khimin.shop.controllers;

import com.khimin.shop.annotations.CurrentUser;
import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.User;
import com.khimin.shop.repositories.UserRepository;
import com.khimin.shop.service.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by khimin on 4/25/17.
 */
@Controller
public class PrincipleController {
    private static Logger LOG = LoggerFactory.getLogger(PrincipleController.class);

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //    @RequestMapping(value = "/hello", method = RequestMethod.GET)
//    public String currentUserName(@CurrentUser User user, Model model) {
//        LOG.info(user.getUsername());
////        model.addAttribute("principle", user.getUsername());
//
//        return "hello";
//    }
    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String currentUserName(@CurrentUser MyUserDetailsService.MyUserPrincipal userDetails, Model model) {
        LOG.info(String.valueOf(userDetails.getUser()));
        User user = userDetails.getUser();
        LOG.info("Principle id: " + user.getId());
        model.addAttribute("principle", userRepository.findOne(user.getId()));
        return "cabinet";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("principle/edit/{id}")
    public String edit(@PathVariable Long id, Model model) throws UsernameNotFoundException {
        model.addAttribute("principle", userRepository.findOne(id));
        LOG.info("Find user id before edit: " + id);
        return "principle/principleform";
    }

    @RequestMapping(value = "principle", method = RequestMethod.POST)
    public String updateUser(User user) throws UsernameNotFoundException, EmailExistsException {
        userRepository.save(user);
        LOG.info("Update user: " + user);
        return "redirect:/cabinet";
    }
}
