package com.example.learspring.game;

import org.springframework.stereotype.Component;

@Component
public class SuperContraGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("supercontra up");
    }

    @Override
    public void down() {
        System.out.println("supercontra down");
    }

    @Override
    public void left() {
        System.out.println("supercontra left");
    }

    @Override
    public void right() {
        System.out.println("supercontra right");
    }
}
