package hotelAppV3.models;

public abstract class MenuItem extends Price{

    //Een MenuItem is bijv. carpaccio of bier, dus gerecht of een drink

    public MenuItem(String name, double price){
        super(name, price);
    }

}
