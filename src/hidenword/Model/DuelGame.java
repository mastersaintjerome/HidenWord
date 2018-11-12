package hidenword.Model;

import hidenword.Model.Game;
import hidenword.Model.Player;
import java.io.IOException;

public class DuelGame extends Game{
    private Player[] players = new Player[2];

    public DuelGame(Player[] players, String word,int maxTry) throws IOException {
        super(word,maxTry);
        this.players = players;
        this.randomWord();
    }

    public Player[] getPlayers() {
        return players;
    }

    public Player getPlayerOne() {
        return players[1];
    }

    public Player getPlayersTwo() {
        return players[2];
    }

    @Override
    protected void gameTurn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}