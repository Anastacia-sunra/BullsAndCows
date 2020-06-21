package by.anastacia.game.service;

import by.anastacia.game.entity.Herd;

public class Shepherd {
    private char[] secretCode;

    public char[] getSecretCode() {
        return secretCode;
    }

    public Shepherd(char[] secretCode) {
        this.secretCode = secretCode;
    }

    public Herd countHerd(char[] guess){
        int bulls = 0;
        int cows = 0;
        for(int i = 0; i < secretCode.length; i++){
            if(guess[i] == secretCode[i]){
                bulls++;
            }
        }
        for (int i = 0; i < secretCode.length; i++){
            for (int j = 0; j < secretCode.length; j++){
                if(guess[i] == secretCode[j]){
                    cows++;
                }
            }
        }
        cows = cows - bulls;
        return new Herd(bulls,cows);
    }
}

