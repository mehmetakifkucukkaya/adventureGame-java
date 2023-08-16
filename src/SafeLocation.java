public class SafeLocation extends Location{

    public SafeLocation(Player player,String name ) {
        super(player);
        this.name = name;
    }
    public boolean getLocation()
    {
        return  true;
    }
}
