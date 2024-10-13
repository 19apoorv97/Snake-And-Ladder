package com.example.snakeladders.models;

import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {
    private Map<Integer,Integer> snakes;
    private Map<Integer,Integer> ladders;
    private Map<Integer, Integer> playerIdToPositionMap;
    private static GameBoard gameBoard;

    private GameBoard(){
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        playerIdToPositionMap = new HashMap<>();
        initializeBoard();
    }

    /*
    * Snakes don’t overlap with ladders.
    * A snake’s start position is greater than its end position.
    * A ladder’s start position is less than its end position.
    * Snakes and ladders don’t start or end at the same positions.*/

    private void initializeBoard() {
        // Hardcoded snakes
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        // Hardcoded ladders
        ladders.put(1,38);
        ladders.put(4,14);
        ladders.put(9,31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 100);
    }

    public void setPlayerPosition(int playerID, int pos) {
        playerIdToPositionMap.put(playerID,pos);
    }

    public Integer getSnake(int position) {
        return snakes.get(position);
    }

    public Integer getLadder(int position) {
        return ladders.get(position);
    }

    public int getPlayerPosition(int id) {
        return playerIdToPositionMap.get(id);
    }

    public void resetBoard() {
        playerIdToPositionMap.clear();
    }

    public static GameBoard getBoardInstance(){
        if(gameBoard==null){
            gameBoard = new GameBoard();
        }
        return gameBoard;
    }
}