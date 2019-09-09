package by.bsu.domino.entity;

import java.util.ArrayList;
import java.util.Optional;

public class GameContainer {
    private ArrayList<DominoGame> games;

    public GameContainer(){
        this.games = new ArrayList<>();
    }

    public DominoGame getAvailableGame(){
        Optional<DominoGame> optionalGame = games.stream().filter(DominoGame::availableToJoin).findAny();
        if(optionalGame.isPresent()){
            return optionalGame.get();
        } else {
            DominoGame game = new DominoGame();
            games.add(game);
            return game;
        }
    }
}
