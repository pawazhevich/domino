package by.bsu.domino.controller;


import by.bsu.domino.dao.UserDao;
import by.bsu.domino.entity.DominoGame;
import by.bsu.domino.entity.GameContainer;
import by.bsu.domino.entity.Player;
import by.bsu.domino.entity.User;
import by.bsu.domino.exception.DominoGameException;

import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/dominoGame/{userId}")
public class DominoServer {

    private static GameContainer gameContainer = new GameContainer();

    @OnOpen
    public void onOpen(Session session, @PathParam("userId") int id){
        UserDao dao = new UserDao();
        User user = dao.getById(id);
        Player player = new Player(user, session);

        DominoGame game =  gameContainer.getAvailableGame();
        try{
            game.addPlayer(player);
        } catch(DominoGameException e){
            e.printStackTrace();
        }
    }

    @OnMessage
    public void onMessage(Session session, String message){
        System.out.println("Socket Message: " + message);
    }

}
