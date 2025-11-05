package model;

import java.util.Random;
import model.strategyPattern.HighLow;
import model.strategyPattern.PlayStrategy;

public class NumberGuessGame {

    public static final int MAX_KEY = 100; // Initializes the maximum value

    private int key; 
    private int guess;
    private boolean showKeyOn;
    private int attempts;
    private PlayStrategy strategy;
    public String progressMessage;

    public NumberGuessGame() {
        // Sets the variables to initial base values
        key = -1; 
        guess = -1; 
        showKeyOn = false;
        attempts = 0;
        setStrategy(new HighLow(this));
    }

    // Starts a new game by generating a new key and resetting variables
    public void start() {
        key = generateNewKey();
        guess = -1;
        attempts = 0;
        progressMessage = null;
    }

    // Generates a new random key that is different from the previous key
    private int generateNewKey() {
        Random r = new Random();
        int newKey;
        do {
            newKey = r.nextInt(MAX_KEY + 1);
        } while(newKey == key);
        return newKey;
    }

    // Main game logic that processes the player's guess based on the selected strategy
    public void play(int guess) {
        ++attempts;
        strategy.play(guess);
    }

    // Basic Getter and Setter methods
    public int getAttempts() {
        return attempts;
    }

    public PlayStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(PlayStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean isShowKeyOn() {
        return showKeyOn;
    }

    public void setShowKeyOn(boolean showKeyOn) {
        this.showKeyOn = showKeyOn;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getKey() {
        return key;
    }

    // Convenient testing method to display the current state of the game
    @Override
    public String toString() {
        return String.format(
            "key(%d), guess(%d), attempts(%d)",
            key, guess, attempts
        );
    }


}