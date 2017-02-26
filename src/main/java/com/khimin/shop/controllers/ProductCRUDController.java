package com.khimin.shop.controllers;

import com.khimin.shop.entities.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by nazar on 2/26/17.
 */
@Controller
public class ProductCRUDController {
    @Autowired
    ProductRepository productRepository;

    /**
     * -------------------Edit Product--------------------------------------------------------
     */
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable ObjectId id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        return "productform";
    }

    /**
     * -------------------New Product--------------------------------------------------------
     */
    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * -------------------Update Product--------------------------------------------------------
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "redirect:/product/" + product.getId();
    }

    /**
     * -------------------Delete Product--------------------------------------------------------
     */
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable ObjectId id) {
        productRepository.delete(id);
        return "redirect:/products";
    }
}
