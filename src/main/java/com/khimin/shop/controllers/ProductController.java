package com.khimin.shop.controllers;

import com.khimin.shop.entities.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Product controller.
 */
@Controller
public class ProductController {
    ProductRepository productRepository;
    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * -------------------Retrieve All Products--------------------------------------------------------
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @ModelAttribute("products")
    public Page<Product> list(@PageableDefault(size = 3) Pageable pageable) {
        return productRepository.findAll(pageable);
    }
    /**
     * -------------------Retrieve Single Products--------------------------------------------------------
     */
    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable ObjectId id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        return "productinfo";
    }



}
