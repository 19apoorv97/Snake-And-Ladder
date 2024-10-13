package com.example.snakeladders.services;

import com.example.snakeladders.models.Dice;
import com.example.snakeladders.models.GameBoard;
import com.example.snakeladders.models.Player;

import java.util.LinkedList;
import java.util.Queue;

public class GamePlayService {
    GameBoard gameBoard;
    Dice dice;
    Queue<Player> playerQueue;
    Boolean hasSomeoneWonYet;
    StringBuilder strBuilder;

    public GamePlayService(int numberOfPlayers){
         gameBoard = GameBoard.getBoardInstance();
         dice = new Dice(1);
         playerQueue = new LinkedList<>();
         hasSomeoneWonYet = false;
         strBuilder = new StringBuilder();

         for(int i =0;i<numberOfPlayers;i++){
             Player p = new Player(i+1);
             gameBoard.setPlayerPosition(i+1,0);
             playerQueue.add(p);
         }
    }

    public String play(){
        while(!hasSomeoneWonYet){
            strBuilder.setLength(0);
            Player player = playerQueue.poll();
            strBuilder.append("player turn : ").append(player.getId());
            int pos = gameBoard.getPlayerPosition(player.getId());
            strBuilder.append(", on pos : ").append(pos);
            int diceRoll = dice.rollTheDice();
            strBuilder.append(", got dice Roll : ").append(diceRoll);
            int newPos = move(pos,diceRoll);
            strBuilder.append(", newPostion : ").append(newPos);
            gameBoard.setPlayerPosition(player.getId(), newPos);
            hasSomeoneWonYet = hasPlayerWon(newPos);
            playerQueue.add(player);
            System.out.println(strBuilder.toString());
        }
        return strBuilder.toString();
    }

    public int move(int currentCoordinate, int diceRoll){
        if(currentCoordinate + diceRoll <=100){
            int newCoordinates = currentCoordinate + diceRoll;
            if(gameBoard.getSnake(newCoordinates)!=null){
                strBuilder.append(", OH.. bitten by Snake");
                newCoordinates = gameBoard.getSnake(newCoordinates);
            }else if(gameBoard.getLadder(newCoordinates)!=null){
                strBuilder.append(", Yeah!! found the ladder");
                newCoordinates = gameBoard.getLadder(newCoordinates);
            }
            return newCoordinates;
        }
        return currentCoordinate;
    }

    public boolean hasPlayerWon(int currPos){
        if(currPos == 100) {
            System.out.println("Yes Someone won");
            return true;
        }
        return false;
    }
}