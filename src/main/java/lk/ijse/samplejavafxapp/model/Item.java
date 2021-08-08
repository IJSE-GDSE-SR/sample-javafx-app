package lk.ijse.samplejavafxapp.model;

public class Item {
    private int ID;
    private String name;
    private double buyingPrice;
    private double sellingPrice;
    private double qty;

    public Item() {
    }

    public Item(int id, String name, double buyingPrice, double sellingPrice, double qty) {
        this.ID = id;
        this.name = name;
        this.buyingPrice = buyingPrice;
        this.sellingPrice = sellingPrice;
        this.qty = qty;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(double buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", buyingPrice='" + buyingPrice + '\'' +
                ", sellingPrice='" + sellingPrice + '\'' +
                ", qty='" + qty + '\'' +
                '}';
    }
}
