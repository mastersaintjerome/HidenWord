
package hidenword.Model;

import hidenword.App.GameState;
import hidenword.Model.Player;
import hidenword.Utils.FileProcessor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public abstract class Game {
    protected String word;
    protected int maxTry;
    protected GameState gameState;

    protected Game(String word,int maxTry){
        this.word = word;
        this.maxTry = maxTry;
        gameState = GameState.RUN;
    }
    
    public String getWord() {
        return word;
    }

    public int getMaxTry() {
        return maxTry;
    }

    protected void randomWord() throws IOException{
        Locale currentLocale = Locale.getDefault();
        String localeLanguage = currentLocale.getLanguage();
        FileProcessor fileProcessor = new FileProcessor(localeLanguage.toUpperCase());
        int max = fileProcessor.getNbLine();
        Random rand = new Random(); 
        int randNumber = rand.nextInt(max - 0 + 1) + 0;
        word = fileProcessor.getLineAtIndex(randNumber);
    }
    
    protected boolean charInWord(char c){
        return ((word.indexOf(c)) != -1);
    }
    
    protected ArrayList<Integer> findIndexes(char c){
        ArrayList<Integer> indexes = new ArrayList<Integer>();
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
    
    protected boolean isGameOver(Player player){
        return ((player.getPlayerCurrentTry() == maxTry) && (!player.getSearchWord().toString().equals(word)));
    }
    
    protected boolean isWin(Player player){
        return ((player.getSearchWord().toString().equals(word)));
    }
    
    protected void playerGameturn(Player player){
        char c = player.getCurrentChar();
        if(charInWord(c)){
            player.setCharFoundinSearchWord(findIndexes(c));
        }
        player.playerTry();
        if(isGameOver(player)){
            gameState = GameState.LOST;
        }else if(isWin(player)){
            gameState = GameState.WIN;
        }
    }
    
    protected abstract void gameTurn();
}