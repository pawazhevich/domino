package by.bsu.domino.entity;

import javax.websocket.Session;
import java.util.Objects;

public class Player extends User {
    private Session session;

    public Player(User user, Session session) {
        super(user.getId(), user.getLogin(), user.getUsername(), user.getPassword());
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Player player = (Player) o;
        return Objects.equals(session, player.session);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), session);
    }

    @Override
    public String toString() {
        return "Player: [" + session.toString() + " , " + super.toString() + " ] ";
    }
}
