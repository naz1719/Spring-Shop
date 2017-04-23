package com.khimin.shop.controllers;

import com.khimin.shop.models.Product;
import com.khimin.shop.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Product controller.
 */
@Controller
public class ProductController {
    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * List all products.
     */
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String list(@PageableDefault(size = 8, direction = Sort.Direction.ASC, sort = "price") Pageable pageable, Model model) {
        model.addAttribute("products", productRepository.findAll(pageable));
        LOG.info("All products");
        return "products";
    }

    /**
     * View a specific product by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("product/{id}")
    public String showProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        LOG.info("Product id: " + id);
        return "productshow";
    }

    // Afficher le formulaire de modification du Product
    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("product", productRepository.findOne(id));
        LOG.info("Edited product id: " + id);
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
        LOG.info("Save product: " + product);
        return "redirect:/product/" + product.getId();
    }

    /**
     * Delete product by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("product/delete/{id}")
    public String delete(@PathVariable Long id) {
        productRepository.delete(id);
        LOG.info("Deleted product id : " + id);
        return "redirect:/products";
    }

}
