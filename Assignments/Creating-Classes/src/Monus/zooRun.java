package Monus;

import java.security.cert.X509Certificate;

public class zooRun {
    public static void main(String[] args) {
        ZooAnimal giraffe = new ZooAnimal("Gerald", "Giraffe", 12, 1896, 2012);
        giraffe.printAllInfo();

        ZooAnimal antelope = new ZooAnimal("Johnathan", "Antelope", 14, 89, 2015);
        antelope.printAllInfo();

        ZooAnimal beaver = new ZooAnimal("Barry", "Beaver", 3, 25, 2019);
        beaver.printAllInfo();
    }
}
