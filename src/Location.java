import java.util.Scanner;

public abstract class Location {
    Scanner scanner = new Scanner(System.in);

    protected Player player;
    protected String name;

    public Player getPlayer() {
        return player;
    }
    public abstract boolean getLocation();
    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location(Player player) {
        this.player = player;
    }



}
