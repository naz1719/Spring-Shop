package com.khimin.shop.controllers;

import com.khimin.shop.models.Product;
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
        return "users";
    }

    /**
     * View a specific user by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("user/{id}")
    public String showProduct(@PathVariable Long id, Model model)throws UsernameNotFoundException  {
        model.addAttribute("user", userRepository.findOne(id));
        LOG.info("User id: "+id);
        return "usershow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Long id, Model model) throws UsernameNotFoundException {
        model.addAttribute("user",  userRepository.findOne(id));
        LOG.info("Edited user id: "+id);
        return "userEditForm";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("user/new")
    public String newProduct(Model model) {
        model.addAttribute("user", new User());
        return "userform";
    }

    /**
     * Save user to database.
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveProduct(User user) throws UsernameNotFoundException {
        userRepository.save(user);
        LOG.info("Save user: "+user);
        return "redirect:/user/" + user.getId();
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
        LOG.info("Deleted user id : "+ id);
        return "redirect:/users";
    }

}
