package org.example.controllers;

import org.example.entities.Product;
import org.example.repositories.UserRepository;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductList(Model model,
                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "word", required = false) String word,
                                  @RequestParam(value = "minPrice", required = false) Integer minPrice,
                                  @RequestParam(value = "maxPrice", required = false) Integer maxPrice
    ) { if (page == null) page = 1;
        Specification<Product> productSpecification = productService.getProductSpecification(word, minPrice, maxPrice);
        model.addAttribute("products", productService.getProductsWithPagingAndFiltering(productSpecification,
                PageRequest.of(page - 1, 20, Sort.by("count").descending())).getContent());
        model.addAttribute("word", word);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute(userRepository.getUser(this));
        model.addAttribute(productService.getTopByViews());

        return "products";
    }

    @GetMapping("/add_product")
    public String addProduct(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_product";
    }

    @PostMapping("/add")
    public String saveNewProduct(@ModelAttribute(value = "product") Product product) {
        productService.saveOrUpdateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/update_product/{id}")
    public String updateProduct(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("product", productService.findById(id));
        productService.incrementViewCount(id);
        return "update_product";
    }

    @PostMapping("/update")
    public String saveUpdatedProduct(@ModelAttribute(value = "product") Product product) {
        productService.saveOrUpdateProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/remove_product/{id}")
    public String removeProduct(@PathVariable(value = "id") Long id) {
        productService.removeProduct(id);
        return "redirect:/products";
    }

//    @PostMapping("/logout")
//    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (auth != null) new SecurityContextLogoutHandler().logout(request, response, auth);
//        return "redirect:/login?logout";
//    }
}