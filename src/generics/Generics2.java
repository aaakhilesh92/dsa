package generics;

import java.util.*;

public class Generics2 {
    public static void main(String[] args) {
        /*
         * Cat[] animals = { new Cat(), new Cat() }; for (Animal a : animals) {
         * checkup(a); } System.out.println("Done"); addAnimal(animals); for (Animal a :
         * animals) { checkup(a); } System.out.println("Done"); List<Cat> animals2 = new
         * ArrayList<Cat>(); animals2.add(new Cat()); // OK // animals2.add(new Dog());
         * // OK addAnimal(animals2); for (Animal a : animals2) { checkup(a); }
         */
        before();
        List<List<Integer>> table = new ArrayList<List<Integer>>();
        List<ArrayList<Integer>> table2 = new ArrayList<ArrayList<Integer>>();
    }

    public static void addAnimal(Animal[] animals) {
        // animals[0] = new Dog();
    }

    public static void addAnimal(List<?> animals) {
        // animals.add(new Dog());
    }

    public static void checkup(Animal a) {
        if (a != null)
            a.checkup();
    }

    public static void before() {
        TreeSet set = new TreeSet();
        set.add("2");
        set.add("1");
        Integer i = new Integer(2);
        set.add(3);
        Iterator it = set.iterator();
        while (it.hasNext())
            System.out.print(it.next() + " ");
    }
}

abstract class Animal {
    public abstract void checkup();
}

class Dog extends Animal {
    public void checkup() { // implement Dog-specific code
        System.out.println("Dog checkup");
    }
}

class Cat extends Animal {
    public void checkup() { // implement Cat-specific code
        System.out.println("Cat checkup");
    }
}

class Bird extends Animal {
    public void checkup() { // implement Bird-specific code
        System.out.println("Bird checkup");
    }
}