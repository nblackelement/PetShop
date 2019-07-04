package ru.mirea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.model.Item;

import java.util.List;
import java.util.Optional;


@Repository
public interface ItemRepository extends CrudRepository<Item, Integer>{

    Optional<Item> findById(Integer id);
    List<Item> findByType(String type);

}
