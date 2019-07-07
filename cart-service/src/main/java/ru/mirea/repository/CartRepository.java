package ru.mirea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.model.Cart;

import java.util.List;
import java.util.Optional;


@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {

    Cart save(Cart s);
    List<Cart> findByUserId(Integer id);
    Optional<Cart> findById(Integer id);

}
