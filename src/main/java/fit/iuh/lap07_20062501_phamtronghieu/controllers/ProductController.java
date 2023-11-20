package fit.iuh.lap07_20062501_phamtronghieu.controllers;

import fit.iuh.lap07_20062501_phamtronghieu.enums.ProductStatus;
import fit.iuh.lap07_20062501_phamtronghieu.models.Product;
import fit.iuh.lap07_20062501_phamtronghieu.repositories.ProductRepository;
import fit.iuh.lap07_20062501_phamtronghieu.services.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller

public class ProductController {
    @Autowired
    private ProductService productService;


    @Autowired
    private ProductRepository  productRepository;
    @GetMapping("/products")
    public String showCandidateListPaging(Model model,
                                          @RequestParam("page") Optional<Integer> page,
                                          @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Product> productPage= productService.findAll(
                currentPage - 1,pageSize,"id","asc");
        model.addAttribute("productPage", productPage);
        int totalPages = productPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "/admin/products.html";
    }

    @GetMapping("/cart")
    public String showCart(Model model,HttpSession session) {

        List<Product> list = (List<Product>) session.getAttribute("cart");
        System.out.println(list);
        model.addAttribute("products",list);

    return "/admin/cart";
    }



    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id);

        productRepository.deleteById(id);
        return "redirect:/products";
    }
    @GetMapping("/views")
    public String View( Model model) {
        Product product = productRepository.findById(4);

        model.addAttribute("product", product);
        return "view";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Product product = productRepository.findById(id);


        model.addAttribute("product", product);
        return "/admin/editProducts";
    }

    @GetMapping("/addToCart/{id}")
    public String addToCart(@PathVariable("id") long id, Model model, HttpSession httpSession) {


        ArrayList<Product> lst = null;

        Object obj =httpSession.getAttribute("cart");
        if(obj==null)
        {
            lst= new ArrayList<>();
        }else {
            lst=(ArrayList<Product>) obj;
        }


          Product product = productRepository.findById(id);
         lst.add(product);
         httpSession.setAttribute("cart",lst);


        return "redirect:/products";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Validated Product product,
                             BindingResult result, Model model) {

        System.out.println(product.toString());
        product.setDescription("abc update");
        product.setManufacturer("abc update");
        product.setStatus(ProductStatus.ACTIVE);

        if (result.hasErrors()) {
            product.setId(id);
            return "update-user";
        }

        productRepository.save(product);
        return "redirect:/products";
    }
}
