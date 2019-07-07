package ru.mirea.model;

import javax.persistence.*;
import java.util.Random;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String login;
    private String password;
    private String keyword;
    private Float balance;

    public User() {}


    public void updateKeyWord() {

        Random random = new Random();
        StringBuilder keyword = new StringBuilder();

        for (int i = 0; i < 5; i++) {

            int num = random.nextInt(52);
            char base = (num < 26) ? 'A' : 'a';
            char letter = (char) (base + num % 26);

            keyword.append(letter);
        }


        this.keyword = keyword.toString();
    }



    public Integer getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getKeyword() {
        return keyword;
    }

    public Float getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

}
