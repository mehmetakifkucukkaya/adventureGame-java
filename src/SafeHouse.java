public class SafeHouse extends  SafeLocation{
    public SafeHouse(Player player) {
        super(player, "Guvenli Ev");
    }

    public boolean getLocation()
    {
        player.setHealth(player.getRealHealth());
        System.out.println("Şu an Güvenli Evdesiniz");
        System.out.println("Canınız fullendi");
        return  true;
    }

}
