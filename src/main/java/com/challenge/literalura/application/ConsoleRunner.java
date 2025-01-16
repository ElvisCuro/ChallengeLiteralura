package com.challenge.literalura.application;

import com.challenge.literalura.controller.MenuController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final MenuController menuController;

    @Autowired
    public ConsoleRunner(MenuController menuController) {
        this.menuController = menuController;
    }

    @Override
    public void run(String... args) {
        menuController.mostrarMenu();
    }
}