package com.example.snakeladders;

import com.example.snakeladders.services.GamePlayService;

public class Main {
    public static void main(String[] args) {
        GamePlayService gamePlayService = new GamePlayService(2);
        gamePlayService.play();
    }
}