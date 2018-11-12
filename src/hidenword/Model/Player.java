package hidenword.Model;

import java.util.ArrayList;

public class Player {
    private String pseudo;
    private int score;
    private int winGame;
    private int defeatGame;
    private int playerCurrentTry;
    private StringBuilder searchWord;
    private char currentChar;

    public Player(String pseudo) {
        this.pseudo = pseudo;
        this.score = 0;
        this.playerCurrentTry = 0;
        searchWord = new StringBuilder();
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getScore() {
        return score;
    }

    public int getPlayerCurrentTry() {
        return playerCurrentTry;
    }

    public void playerTry(){
        this.playerCurrentTry++;
    }
    
    public StringBuilder getSearchWord(){
        return searchWord;
    }

    public char getCurrentChar() {
        return currentChar;
    }

    public void setCurrentChar(char currentChar) {
        this.currentChar = currentChar;
    }
    
    public void initSearchWord(String word){
        int length = word.length();
        for (int i = 0; i < length - 1; i++){
            searchWord.append("_");
        }
        searchWord.setCharAt(0,word.charAt(0));
        searchWord.setCharAt(length,word.charAt(length-1));
    }
    
    public void setCharFoundinSearchWord(ArrayList<Integer> indexes){
        int size = indexes.size();
        for(int i =0; i < size - 1;i++){
            searchWord.setCharAt(i,currentChar);
        }
    }
}
