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
                secimItemID = armorMenu();
                buyArmor(secimItemID);
                break;
            default:
                break;
        }
    }

    private void buyArmor(int secimItemID) {
        int defense=0,price=0;
        String armorName = null;

        switch (secimItemID)
        {
            case 1:
                defense = 1;
                armorName = "Hafif Zırh";
                price = 15;
                break;
            case 2:
                defense = 3;
                armorName = "Orta Zırh";
                price = 25;
                break;
            case 3:
                defense = 5;
                armorName = "Ağır Zırh";
                price = 40;
                break;
            case 4:
                System.out.println("Çıkış Yapılıyor...");
                break;
            default:
                System.out.println("Geçersiz işlem !");
                break;
        }

        if(price >= 0)
        {
            if(player.getMoney() > price)
            {
                player.getInv().setArmor(defense);
                player.getInv().setArmorName(armorName);
                player.setMoney(player.getMoney() - price);

                System.out.println(armorName+" alındı... Eklenen Defans: "+ player.getInv().getArmor());
                System.out.println("Kalan Para: " + player.getMoney());
            }
        }
        else {
            System.out.println("Yetersiz Para !");
        }

    }


    private int armorMenu() {
        System.out.println("1-) Hafif\t 15 Para - 1 Savunma");
        System.out.println("2-) Orta\t 25 Para - 3 Savunma");
        System.out.println("3-) Ağır\t 45 Para - 5 Savunma");
        System.out.println("4-) İptal");

        System.out.print("Zırh Seçimi yapınız: ");
        int secimArmorID = scanner.nextInt();

        return secimArmorID;
    }

    private void buyWeapon(int itemID) {
        int damage=0,price=0;
        String weaponName = null;

        switch (itemID)
        {
            case 1:
                damage = 2;
                weaponName = "Tabanca";
                price = 15;
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
        if(price > 0)
        {
            if(player.getMoney() >= price)
            {
                player.getInv().setDamage(damage);
                player.getInv().setWeaponName(weaponName);
                player.setMoney(player.getMoney() - price);

                System.out.println(weaponName+" Silahı alındı... Önceki Hasar: "+ player.getDamage() + "\tYeni Hasar: " + player.getTotalDamage());
                System.out.println("Kalan Para: " + player.getMoney());
            }
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
