package hidenword.App.Game;

import hidenword.App.Network.Session.Session;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Player Class, define a player
 * @author Gaëtan
 */
final public class Player {
    final private String pseudo;
    private int score;
    //private int winGame;
    //private int defeatGame;
    private int playerCurrentTry;
    private StringBuilder searchWord;
    private char currentChar;
    private PlayerGameState playerGameState;
    private final Set<Character> charUsed;
    private Game game;
    private Session session;

    /**
     * Create a new player
     * @param pseudo
     */
    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.score = 0;
        this.playerCurrentTry = 0;
        searchWord = new StringBuilder();
        charUsed = new HashSet();
    }

    /**
     * return the session
     * @return Session
     */
    public Session getSession() {
        return session;
    }

    /**
     * Set the session
     * @param session
     */
    public void setSession(Session session) {
        this.session = session;
    }
    
    /**
     * return the game object
     * @return game
     */
    public Game getGame(){
        return this.game;
    }
    
    /**
     * Set the game
     * @param game
     */
    public void setGame(Game game){
        this.game = game;
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
     * return the current GameState of the player
     * @return PlayerGameState
     */
    public PlayerGameState getPlayerGameState() {
        return playerGameState;
    }
    
    /**
     *
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
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
        charUsed.add(currentChar);
    }

    /**
     * Is char already used
     * @param currentChar
     * @return true if char already used
     */
    public boolean isCharUsed(char currentChar){
        for (Character charUsed1 : charUsed) {
            if (charUsed1 == currentChar) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * init the search word
     * @param word
     */
    public void initSearchWord(String word){
        int length = word.length();
        for (int i = 0; i < length; i++){
            searchWord.append("_");
        }
        searchWord.setCharAt(0,word.charAt(0));
        searchWord.setCharAt(length,word.charAt(length-1));
    }
    
    /**
     * Set the char found in the search word
     * @param indexes
     */
    public void setCharFoundinSearchWord(List<Integer> indexes){
        for (Integer indexe : indexes) {
            searchWord.setCharAt(indexe, currentChar);
        }
    }
}
