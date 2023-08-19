import java.util.Scanner;

public class Player {
    Scanner scanner = new Scanner(System.in);
    private int damage;
    private int health;
    private int money;

    public Player(String name) {
        this.name = name;
        this.inv = new Inventory();  // Envanteri oluşturuyoruz
    }

    public int getTotalDamage(){
        return  this.getDamage() + this.getInv().getDamage();
    }
    public int getRealHealth() {
        return realHealth;
    }

    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }

    private int realHealth;
    private String name,characterName;
    private Inventory inv;

    public void selectCharacter()
    {
        switch (characterMenu())
        {
            // Samuray
            case 1:
                initPlayer("Samuray",5,21,15);
                break;
            // Okcu
            case 2:
                initPlayer("Okcu",70,18,20);
                break;
            // Sovalye
            case 3:
                initPlayer("Sovalye",8,24,5);
                break;
            // Oyuncu karakter seçmezse otomatik olarak Samuray seçilir
            default:
                initPlayer("Samuray",5,21,15);
                break;
        }
        System.out.println("Seçtiğiniz Karakter Bilgileri:\n" + "Karakter: " + getName() + " ,Hasar: " + getDamage() + " ,Sağlık " + getHealth() + " ,Para: " + getMoney());
    }

    private int characterMenu() {
        // Karakteri seçtiren menümüz
        System.out.println("Oyun Karakterinizi Seçiniz: ");
        System.out.println("1-) Samuray\t ->  Hasar: 5 \t Saglik: 21 \t Para: 15");
        System.out.println("2-) Okcu\t ->  Hasar: 7 \t Saglik: 18 \t Para: 20");
        System.out.println("3-) Sovalye\t ->  Hasar: 8 \t Saglik: 24 \t Para: 5");

        System.out.print("Seçiminiz: ");
        int charID = scanner.nextInt();

        while ( charID < 1 || charID > 3)
        {
            System.out.println("Geçerli bir karakter seçiniz! ");
            System.out.print("Seçiminiz: ");
            charID = scanner.nextInt();
        }
        return charID;
    }

    // Player'ı initalize eden fonksiyon.
    public void initPlayer(String charName, int damage, int health, int money)
    {
        setName(charName);
        setDamage(damage);
        setHealth(health);
        setMoney(money);
        setRealHealth(health);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }




}
