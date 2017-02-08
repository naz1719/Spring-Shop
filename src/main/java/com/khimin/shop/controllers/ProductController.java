package com.khimin.shop.controllers;

import com.khimin.shop.entities.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    ProductRepository productRepository;
    /**
     * List all products.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView("products");
        Iterable<Product> all = productRepository.findAll();
        modelAndView.addObject("products", all);
        return modelAndView;
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable ObjectId id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        return "productshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable ObjectId id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        return "productform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("product/new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "productform";
    }

    /**
     * Save product to database.
     *
     * @param product
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public String saveProduct(Product product) {
        productRepository.save(product);
        return "redirect:/product/" + product.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable ObjectId id) {
        productRepository.delete(id);
        return "redirect:/products";
    }

}
