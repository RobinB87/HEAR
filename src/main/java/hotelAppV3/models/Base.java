package hotelAppV3.models;

public abstract class Base {

    private String name = "";

    public Base(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(){
        this.name = name;
    }
}
