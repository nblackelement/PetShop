package ru.mirea.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.mirea.model.Login;
import ru.mirea.service.UserService;

import javax.servlet.ServletException;


@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody Login data) throws ServletException {

        return userService.registration(data);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Login data) throws ServletException {

        return userService.login(data);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.PUT)
    public String refresh(@RequestHeader(value="Authorization") String token) throws ServletException {

        return userService.refreshToken(token);
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public double showBalance(@RequestHeader(value="Authorization") String token) throws ServletException {

        return userService.getBalance(token);
    }


}
