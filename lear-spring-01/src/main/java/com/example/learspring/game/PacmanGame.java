package com.example.learspring.game;

import org.springframework.stereotype.Component;

@Component
public class PacmanGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("pacman up");
    }

    @Override
    public void down() {
        System.out.println("pacman down");
    }

    @Override
    public void left() {
        System.out.println("pacman left");
    }

    @Override
    public void right() {
        System.out.println("pacman right");
    }
}
