package ru.mirea.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mirea.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User save(User s);
    User findByLogin(String login);
    User findById(Long id);

}
