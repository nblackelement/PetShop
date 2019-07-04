package ru.mirea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.model.Item;
import ru.mirea.service.ItemService;

import javax.servlet.ServletException;
import java.util.List;


@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public List<Item> showAll() {

        return itemService.getAllProducts();
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public Item findItem(@PathVariable int id) throws ServletException {

        return itemService.getItemById(id);
    }

    @RequestMapping(value = "/pet", method = RequestMethod.GET)
    public List<Item> showPets() {

        return itemService.getAllPets();
    }

    @RequestMapping(value = "/stuff", method = RequestMethod.GET)
    public List<Item> showStuff() {

        return itemService.getAllStuff();
    }


}
