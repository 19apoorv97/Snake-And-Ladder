package com.example.snakeladders.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Random;

public class Dice {
    int numberOfDices;
    Random random;
    private static final int sixFacedDice = 6;

    public Dice(int numberOfDices){
        random = new Random();
        this.numberOfDices = numberOfDices;
    }

    public int rollTheDice(){
        int sum = 0;
        for(int i=0;i<numberOfDices;i++){
            sum += random.nextInt(sixFacedDice)+1;
        }
        return sum;
    }
}
