import java.sql.SQLOutput;
import java.util.Locale;

public abstract class BattleLocation extends Location{
    protected Enemies enemy;

    protected String award;
    public BattleLocation(Player player,String name,Enemies enemy,String award) {
        super(player);
        this.enemy = enemy;
        this.name = name;
        this.award = award;
    }

    public boolean getLocation()
    {
        int enemyUnit = enemy.enemiesUnit(); // Kaç tane düşman çıkacağını döndürüyor
        System.out.println("Şu anda " + this.getName() + " mekanındasınız");
        System.out.println("Burada " + enemyUnit + " tane " + enemy.getName() + " var o yüzden dikkatli olmalısın !");
        System.out.println("<S>avaş veya <K>aç :");
        String secimEylem = scanner.nextLine();
        secimEylem = secimEylem.toUpperCase(Locale.ROOT);
        if(secimEylem.equals("S"))
        {
            if(fight(enemyUnit))
            {
                System.out.println(this.getName() + " bölgesindeki savaşı kazandınız !");
                if (this.award.equals("Food") && player.getInv().isFood() == false) {
                    System.out.println(this.award + " Kazandiniz! ");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && player.getInv().isWater() == false) {
                    System.out.println(this.award + " Kazandiniz! ");
                    player.getInv().setWater(true);
                } else if (this.award.equals("Wood") && player.getInv().isWood() == false) {
                    System.out.println(this.award + " Kazandiniz! ");
                    player.getInv().setWood(true);
                }
                return true;
            }
            if(player.getHealth() <= 0)
            {
                System.out.println("Öldünüz !!!");
                return false;
            }
        }
        return true;
    }

    public boolean fight(int unit){
        int defaultEnemyHealth = enemy.getHealth();

        for(int i = 0 ; i < unit ; i++)
        {
            playerStats();
            System.out.println("\n");
            enemyStats();
            System.out.println("\n");

            // Savaş algoritması

            while(player.getHealth() > 0 && enemy.getHealth() > 0 )
            {
                System.out.println("<V>ur veya <K>aç");
                String secimSavasEylemi = scanner.nextLine();
                secimSavasEylemi = secimSavasEylemi.toUpperCase();

                if(secimSavasEylemi.equals("V"))
                {
                    System.out.println("Düşmana Vurdunuz..");
                    enemy.setHealth(enemy.getHealth() - player.getTotalDamage());
                    afterHit();
                    if(enemy.getHealth() > 0)
                    {
                        System.out.println("\n");
                        System.out.println("Düşman size vurdu !");
                        player.setHealth(player.getHealth() - (enemy.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                }
                else {
                    return false;
                }
            }

            if (enemy.getHealth() < player.getHealth()  )
            {
                System.out.println("Düşmanı etkisiz hale getirdiniz");
                player.setMoney(player.getMoney() + enemy.getAward());
                System.out.println("Güncel Paranız: " + player.getMoney());

                enemy.setHealth(defaultEnemyHealth);  //İlk düşman öldürüldükten sonra ikinci düşmannın canını yeniliyoruz
            }
            else {
                return false;
            }
            System.out.println("--------------------------");
        }
        return true;
    }
        // Her vuruştan sonraki canı gösterir.
        public void afterHit()
    {
        System.out.println("Karakter canı: " + player.getHealth());
        System.out.println( enemy.getName()+" canı: "+ enemy.getHealth());
        System.out.println();
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
