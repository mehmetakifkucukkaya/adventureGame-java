import java.util.Scanner;

public class Game {
    Player player;
    Location location;

    public  void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen isminizi giriniz: ");

        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCharacter();
    }
}
