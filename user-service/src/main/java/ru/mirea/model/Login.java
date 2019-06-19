package ru.mirea.model;

// The entity is used for logging
// UserController - {/login}

public class Login {

    private String login;
    private String password;


    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
