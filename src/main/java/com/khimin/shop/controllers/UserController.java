package com.khimin.shop.controllers;

import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.User;
import com.khimin.shop.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nazar on 4/12/17.
 */
@Controller
public class UserController {
    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * List all users.
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(@PageableDefault(size = 8, direction = Sort.Direction.ASC, sort = "username") Pageable pageable, Model model) {
        model.addAttribute("users", userRepository.findAll(pageable));
        LOG.info("All users");
        return "profile/users";
    }

    /**
     * View a specific user by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("user/{id}")
    public String showProduct(@PathVariable Long id, Model model) throws UsernameNotFoundException {
        model.addAttribute("user", userRepository.findOne(id));
        LOG.info("User id: " + id);
        return "profile/usershow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Long id, Model model) throws UsernameNotFoundException {
        model.addAttribute("userform", userRepository.findOne(id));
        LOG.info("Find user id before edit: " + id);
        return "profile/userForm";
    }

    /**
     * Delete user by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable Long id) throws UsernameNotFoundException {
        userRepository.delete(id);
        LOG.info("Deleted user id : " + id);
        return "redirect:/users";
    }

    @RequestMapping(value = "userform", method = RequestMethod.POST)
    public String updateUser(User user) throws UsernameNotFoundException, EmailExistsException {
        userRepository.save(user);
        LOG.info("Update user: " + user);
        return "redirect:/user/" + user.getId();
    }

}
