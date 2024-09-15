import java.util.*;

public class OOP {
    public static void main(String[] args) {
        // Appliance app = new Appliance(); // cannot create an abstract object;
        Appliance fridge = new Fridge(10);
        Fridge fridge1 = new Fridge(); //fridge 1
        Fridge fridge2 = new Fridge(20, "bedroom", 100);
        Dishwasher dishwasher = new Dishwasher(12, "balcony", 4);
        Hover hover = new Hover(2, "living room");

        for (int i = 0; i < 10; i++) {
            ((Fridge) fridge).addProduct("Milk");
        }
        fridge.work();
        System.out.println(fridge.toString());
        System.out.println(fridge2.toString());
        System.out.println(dishwasher);
        System.out.println(hover);

        System.out.println(Fridge.getNumber());
    }
}

abstract class Appliance {

    public String type = "Appliance";
    protected String place;
    protected int guaranteeYears;

    public abstract void work();
    public abstract void setGuaranteeYears(int newGuaranteeYears);

    public void setPlace(String newPlace){
        place = newPlace;
    }
    public String getPlace(){
        return place;
    }
    public int getGuaranteeYears() {
        return guaranteeYears;
    }
    public String getType() {
        return type;
    }
    @Override
    public String toString() {
        return "This is an appliance";
    }
}
class Fridge extends Appliance {
    private static int number = 0; //count fridge nums
    private static int guaranteeMult = 2;
    private List<String> products = new ArrayList<String>(10);

    public Fridge(){
        number++;
        type = "Fridge";
        place = "kitchen";
    }

    public Fridge(int size){
        this();
        products = new ArrayList<String>(size);
    }
    public Fridge(int size, String place){
        this(size);
        this.place = place;
    }
    public Fridge(int size, String place, int guaranteeYears){
        this(size, place);
        this.guaranteeYears = guaranteeYears;
    }

    public static int getNumber(){
        return number;
    }
    public void addProduct(String prodName){
        products.add(prodName);
    }
    public String getProduct() {
        return products.removeLast();
    }

    @Override
    public void setGuaranteeYears(int newGuaranteeYears) {
        guaranteeYears = newGuaranteeYears * guaranteeMult;
    }

    @Override
    public void work() {
        System.out.println("Fridge is working.");
    }

    @Override
    public String toString() {
        return super.toString() + " of type: " + getType() + ", located in place: " + getPlace() + ", with products: " + products.toString() ;
    }
}
class Dishwasher extends Appliance {

    private int dishesNum;

    public Dishwasher() {
        type = "Dishwasher";
        dishesNum = 0;
        place = "kitchen";
        guaranteeYears = 1;
    }
    public Dishwasher(int dishes) {
        this();
        setDishesNum(dishes);
    }
    public Dishwasher(int dishes, String place) {
        this(dishes);
        this.place = place;
    }
    public Dishwasher(int dishes, String place, int guaranteeYears) {
        this(dishes, place);
        this.guaranteeYears = guaranteeYears;
    }

    private void setDishesNum(int dishes){
        dishesNum+=dishes;
    }
    public void addDishes(int dishes) {
        setDishesNum(dishes);
    }
    public int getDishes() {
        return dishesNum;
    }

    @Override
    public void setGuaranteeYears(int newGuaranteeYears) {
        guaranteeYears = newGuaranteeYears;
    }

    @Override
    public void work() {
        System.out.println("dishwasher is working");
    }

    @Override
    public String toString() {
        return super.toString() + " of type: "+ getType() + ", located in place: " + getPlace() + ", with " + dishesNum + " dishes";
    }
}
class Hover extends Appliance {

    private int bagsNum = 1;

    public Hover(){
        this.type = "Hover";
    }
    public Hover(int bagsNum){
        this();
        this.bagsNum = bagsNum;
    }
    public Hover(int bagsNum, String place) {
        this(bagsNum);
        this.place = place;
    }
    public Hover(int bagsNum, String place, int guaranteeYears){
        this(bagsNum, place);
        this.guaranteeYears = guaranteeYears;
    }

    public int getBags() {
        return bagsNum;
    }
    public void setBags(int newBags){
        bagsNum = newBags;
    }

    @Override
    public void setGuaranteeYears(int newGuaranteeYears) {
        guaranteeYears = newGuaranteeYears;
    }

    @Override
    public void work() {
        System.out.println("hover is working");
    }
    @Override
    public String toString() {
        return super.toString() + " of type: " + getType() + ", located in place: " + getPlace() + ", with " + bagsNum + " bags";
    }
}