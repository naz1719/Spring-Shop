package com.khimin.shop.controllers;

import com.khimin.shop.models.Product;
import com.khimin.shop.models.User;
import com.khimin.shop.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nazar on 4/4/17.
 */
@Controller
public class UserController {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * -------------------Retrieve All Products--------------------------------------------------------
     */
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ModelAttribute("users")
    public Page<User> list(@PageableDefault(size = 8, direction = Sort.Direction.ASC, sort = "price") Pageable pageable) {
        return userRepository.findAll(pageable);
    }
    /**
     * -------------------Retrieve Single Products--------------------------------------------------------
     */
    @RequestMapping("user/{id}")
    public String showProduct(@PathVariable ObjectId id, Model model) {
        model.addAttribute("info", userRepository.findOne(id));
        return "userInfo";
    }
    /**
     * -------------------New Product--------------------------------------------------------
     */
    @RequestMapping("user/new")
    public String newProduct(Model model) {
        model.addAttribute("user", new User());
        return "user";
    }

    /**
     * -------------------Edit Product--------------------------------------------------------
     */
    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable ObjectId id, Model model) {
        model.addAttribute("user", userRepository.findOne(id));
        return "user";
    }

    /**
     * -------------------Save Product--------------------------------------------------------
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userRepository.save(user);
        return "redirect:/user/" + user.getId();
    }

    /**
     * -------------------Delete Product--------------------------------------------------------
     */
    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable ObjectId id) {
        userRepository.delete(id);
        return "redirect:/users";
    }

}
