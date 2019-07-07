package ru.mirea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.mirea.model.Cart;
import ru.mirea.repository.CartRepository;

import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;


@Service
public class CartService {

    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public List<Cart> getCartItems(int id) {

        return cartRepository.findByUserId(id);
    }


    public String addItem(int itemId, int userId) {

        Cart cartEntity = new Cart();
        cartEntity.setUserId(userId);
        cartEntity.setItemId(itemId);

        cartRepository.save(cartEntity);
        return "Added.";
    }


    public String deleteItem(int id, int userId) throws ServletException {

        Cart cart = cartRepository.findById(id).orElse(null);
        if (cart == null)
            throw new ServletException("Item not found in cart.");

        if (cart.getUserId() == userId)
            cartRepository.delete(id);
        else
            throw new ServletException("Item not found in cart.");

        return "Deleted.";
    }


    public String pay(int userId, float balance) {

        List<Cart> cart = cartRepository.findByUserId(userId);

        // Purchase
        int sum = 0;
        for (Cart cartEntity: cart) {

            int itemId = cartEntity.getItemId();

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getForObject("http://localhost:8083/item/" + itemId, Object.class);
        }
        return "Done.";
    }


}