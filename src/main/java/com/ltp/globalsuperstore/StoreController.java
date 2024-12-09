package com.ltp.globalsuperstore;

import org.apache.catalina.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.ZoneId;
import java.time.LocalDate;
import java.util.ArrayList;

@Controller
public class StoreController {

    private ArrayList<Item> items = new ArrayList<Item>();

    @GetMapping("/")
    public String getForm(Model model){

        Item item = new Item();

        model.addAttribute("categories", Constants.CATEGORIES);
        model.addAttribute("item", item);
        return "form";
    }

    @GetMapping("/inventory")
    public String getInventory(Model model){
        System.out.println(items);

        model.addAttribute("items", items);
        return "inventory";
    }

    @PostMapping("/submitItem")
    public String handleSubmit(@ModelAttribute Item item){

        items.add(item);

        return "redirect:/inventory";
    }
}
