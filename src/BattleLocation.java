public abstract class BattleLocation extends Location{
    Monster monster;
    public BattleLocation(Player player,String name,Monster monster) {
        super(player);
        this.monster = monster;
        this.name = name;
    }

    public boolean getLocation()
    {
        return true;
    }
}
