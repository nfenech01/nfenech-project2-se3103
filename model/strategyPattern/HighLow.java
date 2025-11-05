package model.strategyPattern;

import model.NumberGuessGame;

public class HighLow implements PlayStrategy {

    private NumberGuessGame game;

    public HighLow(NumberGuessGame game) {
        this.game = game;
    }

    @Override
    public void play(int guess) {
        int key = game.getKey();
        int diff = guess - key;
        if (diff < 0) {
            game.progressMessage = "Too low!";
        } else if (diff == 0) {
            game.progressMessage = "Correct! Key was " + key + ".";
        } else {
            game.progressMessage = "Too high!";
        }
    }
}
