
package hidenword.App.Game;

import hidenword.App.Core.File.FileProcessor;
import hidenword.App.Game.GameStrategy.GameTurnStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Game Classe, all the game logic
 * @author Gaëtan
 */
final public class Game {
    private String word;
    private int maxTry;
    private GameState gameState;
    final private GameTurnStrategy gameTurn;
    private List<Player> players;
    private GameState state;
    final private Logger logger;
    private int turnCounter;
    
    /**
     * Create a new Game
     * @param gameTurn
     */
    public Game(GameTurnStrategy gameTurn){
        this.gameTurn = gameTurn;
        logger = Logger.getLogger(Game.class.getName());
        turnCounter = (int) (Math.random()*2);
    }
    
    /**
     * Start a Game
     */
    public void start(){
        try {
            gameState = GameState.RUN;
            randomWord();
            for(int i = 0;i < players.size();i++){
                players.get(i).initSearchWord(word);
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Init the Players and maxTry
     * @param players
     * @param maxTry
     */
    public void init(List<Player> players,int maxTry){
        this.players = players;
        this.maxTry = maxTry;
    }
    
    /**
     * Game state of a Game
     */
    public enum GameState {

        /**
         * Running
         */
        RUN,

        /**
         * Game stop Win or Defeat of a Gamer
         */
        END,

        /**
         * Pause
         */
        PAUSE
    }
    
    /**
     *
     * @return the word to found
     */
    public String getWord() {
        return word;
    }

    /**
     *
     * @return the max try
     */
    public int getMaxTry() {
        return maxTry;
    }

    /**
     * return the players a List
     * @return Players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * return the current turn counter
     * @return turnCounter
     */
    public int getTurnCounter() {
        return turnCounter;
    }

    /**
     * Next turn counter (turnCounter++)
     */
    public void turnCounter() {
        this.turnCounter++;
    }

    /**
     * Set a random word to found
     * @throws IOException
     */
    private void randomWord() throws IOException{
        Locale currentLocale = Locale.getDefault();
        String localeLanguage = currentLocale.getLanguage();
        FileProcessor fileProcessor = new FileProcessor(localeLanguage.toUpperCase());
        int max = fileProcessor.getNbLine();
        Random rand = new Random(); 
        int randNumber = rand.nextInt(max - 0 + 1) + 0;
        word = fileProcessor.getLineAtIndex(randNumber);
    }
    
    /**
     *
     * @param c
     * @return check if a char is in the word
     */
    private boolean charInWord(char c){
        return ((word.indexOf(c)) != -1);
    }
    
    /**
     *
     * @param c
     * @return ArrayList<Integer> with all indexes where the char is.
     */
    private List<Integer> findIndexes(char c){
        List<Integer> indexes = new ArrayList<Integer>();
        int index = word.indexOf(c);
        if(index >= -1){
            indexes.add(index);
        }
        while (index >=0){
            System.out.println("Index : "+index);
            index = word.indexOf(c, index+1);
            indexes.add(index);
        }
        return indexes;
    }
    
    /**
     *
     * @param player
     * @return check if the game is over
     */
    public boolean isGameOver(Player player){
        return ((player.getPlayerCurrentTry() == maxTry) && (!player.getSearchWord().toString().equals(word)));
    }
    
    /**
     *
     * @param player
     * @return check if the game is win by a player
     */
    public boolean isWin(Player player){
        return ((player.getSearchWord().toString().equals(word)));
    }
    
    /**
     * A player turn
     * @param player
     */
    public void playerGameturn(Player player){
        char c = player.getCurrentChar();
        //We don't count the try if player is right
        if(charInWord(c)){
            player.setCharFoundinSearchWord(findIndexes(c));
        }else{
            player.playerTry();
        }
        if(isGameOver(player)){
            player.setPlayerGameState(Player.PlayerGameState.LOST);
            gameState = GameState.END;
        }else if(isWin(player)){
            player.setPlayerGameState(Player.PlayerGameState.WIN);
            gameState = GameState.END;
        }
    }
    
    /**
     * Make a Game Turn
     */
    public void nextTurn(){
        gameTurn.nextTurn(this);
    }
}