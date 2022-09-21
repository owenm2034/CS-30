package Monus;

public class vehicleRun {

    public static void main(String[] args) {
        Vehicle tesla = new Vehicle("Tesla", "S Plaid", "Black", 2020, 1215);
        System.out.println("The car is a " + tesla.getAllInfo());

        Vehicle tacoma = new Vehicle("Toyota", "Tacoma", "Red", 2016, 253451);
        System.out.println("The truck is a " + tacoma.getAllInfo());

        Vehicle rs6 = new Vehicle("Audi", "RS6", "Black", 2021, 4568);
        System.out.println("The wagon is an " + rs6.getAllInfo());
    }

}
