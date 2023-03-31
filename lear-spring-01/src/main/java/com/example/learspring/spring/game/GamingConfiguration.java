package com.example.learspring.spring.game;

import com.example.learspring.game.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole gamePacman() {
        return new PacmanGame();
    }

    @Bean
    public GamingConsole gameSuperContra() {
        return new SuperContraGame();
    }

    @Bean
    public GamingConsole gameMario() {
        return new MarioGame();
    }

    @Bean
    public GameRunner gameRunner(GamingConsole gamePacman) {
        var gameRunner = new GameRunner(gamePacman);
        return gameRunner;
    }

}
