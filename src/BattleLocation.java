import java.util.Locale;

public abstract class BattleLocation extends Location{
    protected Enemies enemy;
    public BattleLocation(Player player,String name,Enemies enemy) {
        super(player);
        this.enemy = enemy;
        this.name = name;
    }

    public boolean getLocation()
    {
        int enemyUnit = enemy.enemiesUnit(); // Kaç tane düşman çıkacağını döndürüyor
        System.out.println("Şu anda " + this.getName() + " mekanındasınız");
        System.out.println("Burada " + enemyUnit + " tane " + enemy.getName() + " var o yüzden dikkatli olmalısın !");
        System.out.println("<S>avaş veya <K>aç :");
        String secimEylem = scanner.next();
        secimEylem = secimEylem.toUpperCase(Locale.ROOT);
        if(secimEylem.equals("S"))
        {
            if(fight(enemyUnit))
            {
                System.out.println(this.getName() + " bölgesindeki savaşı kazandınız !");
                return true;
            }
            else
            {
                System.out.println("Öldünüz !");
                return false; // Oyun biter
            }
        }
        return true;
    }

    public boolean fight(int unit){

        playerStats();
        System.out.println("\n");
        enemyStats();
        System.out.println("\n");

        return true;
    }

    private void enemyStats() {
        System.out.println(enemy.getName() +" Bilgileri:\n----------------------");
        System.out.println("Sağlık: " + enemy.getHealth());
        System.out.println("Hasar: " + enemy.getDamage());
        System.out.println("Ganimet: "+enemy.getAward());
    }

    private void playerStats() {
        System.out.println("Karakter Bilgileri:\n----------------------");
        System.out.println("Sağlık: " + player.getHealth());
        System.out.println("Hasar: " +player.getDamage());
        System.out.println("Para: "+player.getMoney());

        if(player.getInv().getDamage() > 0 )
        {
            System.out.println("Silah: " + player.getInv().getWeaponName());
        }

        if(player.getInv().getArmor() > 0 )
        {
            System.out.println("Zırh: " + player.getInv().getArmorName());
        }


    }
}
