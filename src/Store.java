public class Store extends SafeLocation{
    public Store(Player player) {
        super(player, "Mağaza");
    }
    public boolean getLocation(){
       storeMenu();
        return true;
    }

    public void storeMenu()
    {
        System.out.println("Mağazaya Hpşgeldiniz !");
        System.out.println("Paranız: " + player.getMoney() );

        System.out.println("1-) Silahlar");
        System.out.println("2-) Zırhlar");
        System.out.println("3-) Çıkış");

        int secimEsya = scanner.nextInt();
        int secimItemID;

        switch (secimEsya)
        {
            case 1:
                secimItemID = weaponMenu();
                buyWeapon(secimItemID);
                break;
            case 2:
                break;

            default:
                break;
        }
    }

    private void buyWeapon(int itemID) {
        int damage=0,price=0;
        String weaponName = null;

        switch (itemID)
        {
            case 1:
                damage = 2;
                weaponName = "Tabanca";
                price = 5;
                break;
            case 2:
                damage = 3;
                weaponName = "Kılıç";
                price = 35;
                break;
            case 3:
                damage = 7;
                weaponName = "Tüfek";
                price = 45;
                break;
                default:
                    System.out.println("Geçersiz işlem !");
                    break;
        }
        // Alınan silaha göre yeni damage ve money değerleri güncelleniyor
        if(player.getMoney() > price)
        {
            player.getInv().setDamage(damage);
            player.getInv().setWeaponName(weaponName);
            player.setMoney(player.getMoney() - price);

            System.out.println(weaponName+" Silahı alındı... Önceki Hasar: "+ player.getDamage() + "\tYeni Hasar: " + (player.getDamage()+player.getInv().getDamage()));
            System.out.println("Kalan Para: " + player.getMoney());
        }
        else {
            System.out.println("Yetersiz Para !");
        }

    }

    private int weaponMenu() {
        System.out.println("1-) Tabanca\t 25 Para - 2 Hasar");
        System.out.println("2-) Kılıç\t 35 Para - 3 Hasar");
        System.out.println("3-) Tüfek\t 45 Para - 7 Hasar");
        System.out.println("4-) İptal");

        System.out.print("Silah Seçimi yapınız: ");
        int secimWeaponID = scanner.nextInt();

        return secimWeaponID;
    }
}
