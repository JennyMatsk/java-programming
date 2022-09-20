package lab4;

public class HealthyCell {

    protected int x, y;

    // Необходимо для модификации массива кожи
    protected Skin skin;

    public HealthyCell(int x, int y, Skin skin) {
        this.x = x;
        this.y = y;
        this.skin = skin;
    }

    public void update() {
    }

    public String getCellSymbol() {
        return "\uD83D\uDE04";
    }
}
