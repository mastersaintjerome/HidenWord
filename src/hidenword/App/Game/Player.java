package hidenword.App.Game;

import java.util.ArrayList;

/**
 * Player Class, define a player
 * @author Gaëtan
 */
final public class Player {
    private String pseudo;
    private int score;
    private int winGame;
    private int defeatGame;
    private int playerCurrentTry;
    private StringBuilder searchWord;
    private char currentChar;
    private PlayerGameState playerGameState;

    /**
     * Create a new player
     * @param pseudo
     */
    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.score = 0;
        this.playerCurrentTry = 0;
        searchWord = new StringBuilder();
    }

    /**
     * Game State of the player
     */
    public enum PlayerGameState {

        /**
         * Win the game
         */
        WIN,

        /**
         * Lost the game
         */
        LOST,
        
        /**
         * Game still running for the player
         */
        RUN
    }
    
    /**
     * Set a new GameState to the player
     * @param playerGameState
     */
    public void setPlayerGameState(PlayerGameState playerGameState){
        this.playerGameState = playerGameState;
    }
    
    /**
     *
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }
    
    /**
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     *
     * @return the current try made by the player
     */
    public int getPlayerCurrentTry() {
        return playerCurrentTry;
    }

    /**
     * add a try play to the player
     */
    public void playerTry(){
        this.playerCurrentTry++;
    }
    
    /**
     *
     * @return the searchWord
     */
    public StringBuilder getSearchWord(){
        return searchWord;
    }

    /**
     *
     * @return The current char of the player, change every game turn
     */
    public char getCurrentChar() {
        return currentChar;
    }

    /**
     * set the current char of the player
     * @param currentChar
     */
    public void setCurrentChar(char currentChar) {
        this.currentChar = currentChar;
    }
    
    /**
     * init the search word
     * @param word
     */
    public void initSearchWord(String word){
        int length = word.length();
        for (int i = 0; i < length - 1; i++){
            searchWord.append("_");
        }
        searchWord.setCharAt(0,word.charAt(0));
        searchWord.setCharAt(length,word.charAt(length-1));
    }
    
    /**
     * Set the char found in the search word
     * @param indexes
     */
    public void setCharFoundinSearchWord(ArrayList<Integer> indexes){
        int size = indexes.size();
        for(int i =0; i < size - 1;i++){
            searchWord.setCharAt(i,currentChar);
        }
    }
}
