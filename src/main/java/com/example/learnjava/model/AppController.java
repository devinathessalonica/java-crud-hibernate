package com.example.learnjava.model;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private BarangService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Barang> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);

        return "barang/index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Barang product = new Barang();
        model.addAttribute("product", product);

        return "barang/new_product";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Barang product, @RequestParam("id") int fooId) {
        product.setStatus(1);
        // product.setId(fooId);
        service.save(product);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("barang/edit_product");
        Barang product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        Barang product = service.get(id);
        product.setStatus(0);
        service.save(product);
        // service.delete(id);
        return "redirect:/";
    }
}
