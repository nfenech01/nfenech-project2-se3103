package model.strategyPattern;

import model.NumberGuessGame;

public class CloseFar implements PlayStrategy {

    private NumberGuessGame game;

    public CloseFar(NumberGuessGame game) {
        this.game = game;
    }

    @Override
    public void play(int guess) {
        int prevDiff = Math.abs(game.getKey() - game.getGuess());
        int newDiff = Math.abs(game.getKey() - guess);
        game.setGuess(guess);
        if (newDiff < prevDiff) {
            game.progressMessage = "Getting closer!";
        } else {
            game.progressMessage = "Getting farther!";
        }
    }
}