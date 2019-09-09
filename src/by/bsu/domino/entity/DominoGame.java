package by.bsu.domino.entity;

import by.bsu.domino.exception.DominoGameException;

import java.io.IOException;
import java.util.ArrayList;

public class DominoGame {
    public static final int MAX_PLAYER_AMOUNT = 4;
    public static final int MIN_PLAYER_AMOUNT = 2;

    private ArrayList<Player> players;
    private ArrayList<DominoFigure> figures;
    private boolean isActive;

    public DominoGame(){
            this.figures = new ArrayList<>();
            this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) throws DominoGameException {
        if(players.size() >= 4){
            throw new DominoGameException("Unable to add player: max amount of players in game");
        } else {
            players.add(player);
            //todo replace 2 with MAX_NUMBER
            if(players.size() == 2){
                this.start();
            }
        }
    }

    public void start(){
        broadcastMessage("4 players joined. Game started");
    }

    public void broadcastMessage(String message){
        players.forEach(p -> {
            try{
                p.getSession().getBasicRemote().sendText(message);
            } catch(IOException e){
                //TODO normal handler;
                e.printStackTrace();
            }

        });
    }

    public void broadcastGame(){
            players.forEach(p -> {
                try{
                    p.getSession().getBasicRemote().sendText(figures.toString());
                } catch(IOException e){
                    //TODO normal handler;
                    e.printStackTrace();
                }

            });
    }

    public boolean isPlayerInGame(Player player){
        return players.contains(player);
    }

    public boolean isActive(){
        return this.isActive;
    }

    public boolean availableToJoin(){
        return players.size() < MAX_PLAYER_AMOUNT && !isActive;
    }
}
