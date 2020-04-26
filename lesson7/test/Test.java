package lesson7.test;
import lesson7.animals.*;
import lesson7.plate.*;
import java.util.ArrayList;

public class Test {

    public static ArrayList<Cat> cats;

    public static void main(String[] args) {

//        Dog dog1 = new Dog("Шарик");
//        Dog dog2 = new Dog("Бобик");
//        dog1.run(500);
//        dog2.run(1200);
//        dog1.jump(0.2);
//        dog2.jump(0.6);
//        dog1.swim(100);
//        dog2.swim(300);

        ArrayList<Cat> cats = new ArrayList<>();

        Cat cat1 = new Cat("Барсик", 10);
        cats.add(cat1);
        Cat cat2 = new Cat("Мурзик", 15);
        cats.add(cat2);
        Cat cat3 = new Cat("Гарфилд", 20);
        cats.add(cat3);

        Plate plate = new Plate(40);
//        cat1.run(60);
//        cat2.run(200);
//        cat1.jump(3);
//        cat2.jump(0.5);
//        cat1.swim(10);
//        cat1.swim(0);

        plate.info();
        cat1.eat(plate);
        cat2.eat(plate);
        cat3.eat(plate);

        for (Cat cat: cats
             ) {
                cat.getBellyful();
        }

        System.out.println();
        plate.addFood(30);

        cat3.eat(plate);
        cat3.getBellyful();

        System.out.println();
        plate.info();

    }
}
