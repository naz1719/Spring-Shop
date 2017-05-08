package com.khimin.shop.controllers;

import com.khimin.shop.exception.EmailExistsException;
import com.khimin.shop.models.Category;
import com.khimin.shop.models.Product;
import com.khimin.shop.repositories.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by khimin on 07.05.17.
 */
@Controller
public class CategoryController {
    private static Logger LOG = LoggerFactory.getLogger(ProductController.class);

    private CategoryRepository categoryRepository;

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    /**
     * List all categories.
     */
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("categories", categoryRepository.findAll());
        LOG.info("All categories");
        return "category/categories";
    }

    /**
     * View a specific category by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("category/{id}")
    public String showCategory(@PathVariable Long id, Model model) throws UsernameNotFoundException {
        model.addAttribute("category", categoryRepository.findOne(id));
        LOG.info("Category id: " + id);
        return "category/categoryshow";
    }

    @RequestMapping("category/edit/{id}")
    public String edit(@PathVariable Long id, Model model) throws UsernameNotFoundException {
        model.addAttribute("category", categoryRepository.findOne(id));
        LOG.info("Find category id before edit: " + id);
        return "category/categoryform";
    }

    @RequestMapping("category/new")
    public String newProduct(Model model) {
        model.addAttribute("category", new Product());
        return "category/categoryform";
    }


    @PostMapping(value = "category")
    public String saveUser(Category category) throws UsernameNotFoundException, EmailExistsException {
        categoryRepository.save(category);
        LOG.info("Update category: " + category);
        return "redirect:/category/" + category.getId();
    }

    /**
     * Delete user by its id.
     *
     * @param id
     * @return
     */
    @RequestMapping("category/delete/{id}")
    public String delete(@PathVariable Long id) throws UsernameNotFoundException {
        categoryRepository.delete(id);
        LOG.info("Deleted category id : " + id);
        return "redirect:/categories";
    }
}
