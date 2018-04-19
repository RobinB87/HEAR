package hotelAppV3.models;

public abstract class Price extends Base {

    double price;

    public Price(String name, double costPrice){
        super(name);
        this.price = costPrice;
    }

    public double getPrice(){
        return price;
    }
}
