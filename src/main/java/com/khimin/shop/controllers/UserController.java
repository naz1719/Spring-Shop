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
 @Autowired
    private UserRepository userRepository;


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
     * -------------------Edit Product--------------------------------------------------------
     */
    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable User id, Model model) {
        id =userRepository.findOne(id.getId());
        model.addAttribute("product", id);
        userRepository.save(id);
        return "productform";
    }

    /**
     * -------------------New Product--------------------------------------------------------
     */
    @RequestMapping("user/new")
    public String newProduct(Model model) {
        model.addAttribute("user", new User());
        return "productform";
    }

//    /**
//     * -------------------Update Product--------------------------------------------------------
//     */
//    @RequestMapping(value = "product", method = RequestMethod.POST)
//    public String saveProduct(User product) {
//        userRepository.save(product);
//        return "redirect:/product/" + product.getId();
//    }

    /**
     * -------------------Delete Product--------------------------------------------------------
     */
    @RequestMapping("user/delete/{id}")
    public String delete(@PathVariable ObjectId id) {
        userRepository.delete(id);
        return "redirect:/users";
    }

}
