import javax.sql.rowset.serial.SQLOutputImpl;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Player player;
    Location location;

    public  void login(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen isminizi giriniz: ");

        String playerName = scanner.nextLine();
        player = new Player(playerName);
        player.selectCharacter(); // Oyuncuya karakter seçimi yaptırdığımız menü

        start();
    }

    private void start() {
       while (true)
       {
           System.out.println();
           System.out.println("-------------------------------------------");
           System.out.println();
           System.out.println("1-) Güvenli Ev -> Güvende olduğunuz ev. Burada canınız yenilenir");
           System.out.println("2-) Mağara -> Zombilerle karşılaşma ihtimaliniz var !");
           System.out.println("3-) Orman -> Vampirlerle karşılaşma ihtimaliniz var !");
           System.out.println("4-) Nehir -> Ayılarla karşılaşma ihtimaliniz var !");
           System.out.println("5-) Mağaza -> Buradan Silah ve Zırh alabilirsiniz");

           System.out.print("Lütfen gitmek istediğiniz mekanı seçin: ");

           int secilenKonum = scanner.nextInt();

           while (secilenKonum <0 || secilenKonum >5)
           {
               System.out.print("Lütfen geçerli bir mekan seçin: ");
               secilenKonum = scanner.nextInt();
           }

           switch (secilenKonum)
           {
               case 1:
                   location = new SafeHouse(player);
                   break;
               default:
                   location = new SafeHouse(player);
                   break;
           }

          if (! location.getLocation())
          {
              System.out.println("Oyun Bitti !");
              break;
          }
       }
    }
}
