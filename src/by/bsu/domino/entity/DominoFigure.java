package by.bsu.domino.entity;

public class DominoFigure {
    private int top;
    private int bot;

    public DominoFigure(int top, int bot) {
        this.top = top;
        this.bot = bot;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getBot() {
        return bot;
    }

    public void setBot(int bot) {
        this.bot = bot;
    }

    public boolean isSuit(int first, int second){
        if(top == first || top == second || bot == first || bot == second)
            return true;
        return false;
    }

    public void rotate(){
        top = top + bot;
        bot = top - bot;
        top = top - bot;
    }

    public boolean isDouble(){
        if(top == bot)
            return true;
        return false;
    }

    public int getValue(){
        return top + bot;
    }

    @Override
    public String toString() {
        return "["
                + bot +
                " | " + top +
                ']';
    }
}
