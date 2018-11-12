package hidenword.Model;

import hidenword.Model.Game;
import hidenword.Model.Player;
import java.io.IOException;

public class SoloGame extends Game{
    private Player player;

    public SoloGame(Player player, String word,int maxTry) throws IOException {
        super(word,maxTry);
        this.player = player;
        this.randomWord();
    }

    public Player getPlayer() {
        return player;
    }

    @Override
    protected void gameTurn() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }	
}
