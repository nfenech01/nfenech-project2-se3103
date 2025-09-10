package model;

import java.util.Random;

public class NumberGuessGame {

    public static final int MAX_KEY = 100; // Initializes the maximum value

    private int key; 
    private int guess;
    private boolean showKeyOn;
    private int attempts;
    private GameState state;
    private PlayStrategy strategy;
    public String progressMessage;

    public NumberGuessGame() {
        // Sets the variables to initial base values
        key = -1; 
        guess = -1; 
        showKeyOn = false;
        attempts = 0;
        state = GameState.INIT;
        strategy = PlayStrategy.HighLow;
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
        if (strategy == PlayStrategy.HighLow) {
            playHighLow(guess);
        } else if (strategy == PlayStrategy.CloserAway) {
            playCloserAway(guess);
        }
    }

    private void playHighLow(int guess) {
        this.guess = guess;
        int diff = guess - key;
        if (diff < 0) {
            progressMessage = "Too low!";
        } else if (diff == 0) {
            progressMessage = "Correct! Key was " + key + ".";
            state = GameState.WON;
        } else {
            progressMessage = "Too high!";
        }
    }

    private void playCloserAway(int guess) {

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

    public GameState getGameState() {
        return state;
    }

    public void setGameState(GameState state) {
        this.state = state;
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