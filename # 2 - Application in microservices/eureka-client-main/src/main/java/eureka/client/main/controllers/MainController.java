package eureka.client.main.controllers;

import eureka.client.main.entities.Product;
import eureka.client.main.services.ProductServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class MainController {

//    private UserRepository userRepository;
    private final ProductServiceImplementation productService;

        @GetMapping
    public String showProductList(Model model,
                                  @RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "word", required = false) String word,
                                  @RequestParam(value = "minPrice", required = false) Integer minPrice,
                                  @RequestParam(value = "maxPrice", required = false) Integer maxPrice
    ) { if (page == null) page = 1;
        model.addAttribute("products", productService.getProductsWithPagingAndFiltering(page, word, minPrice, maxPrice));
        model.addAttribute("word", word);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);
//        model.addAttribute(userRepository.getUser(this));
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
        productService.incrementViewCounter(id);
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