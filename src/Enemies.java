import java.util.Random;

public class Enemies {
    private  String name;
    private  int damage,health,award,maxUnit;

    public Enemies(String name, int damage, int health, int award, int maxUnit) {
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.award = award;
        this.maxUnit = maxUnit;
    }

    // Mekanlarda çıkacak rastegele sayıdaki düşmanların sayısını belirleyen metot.
    public int enemiesUnit(){
        Random random = new Random();
        return  random.nextInt(this.maxUnit) + 1;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getMaxUnit() {
        return maxUnit;
    }

    public void setMaxUnit(int maxUnit) {
        this.maxUnit = maxUnit;
    }
}
