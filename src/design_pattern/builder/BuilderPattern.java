package design_pattern.builder;

public class BuilderPattern {
    public static void main(String[] args) {
        // Using constructor to forcefully set mandatory arguments:
        IceCream.IceCreamBuilder builder = new IceCream.IceCreamBuilder("Chocolate", 5);

        // Build ice cream with peanuts:
        IceCream ic1 = builder.setToppings("Peanuts").build();

        // Call build() again without any changes
        // to build the same ice cream:
        IceCream ic2 = builder.build();

        // Change the attributes of the same builder (in any order)
        // to build a different ice cream:
        IceCream ic3 = builder.setToppings("Pistachio").setFlavor("Vanilla").setSize(2).build();

        // Show all ice creams:
        ic1.showInfo();
        ic2.showInfo();
        ic3.showInfo();
    }
}

class IceCream {
    // Mandatory attributes:
    private String flavor;
    private int size;

    // Optional attribute:
    private String toppings;

    private IceCream(IceCreamBuilder icb) {
        flavor = icb.flavor;
        toppings = icb.toppings;
        size = icb.size;
    }

    public void showInfo() {
        System.out.println("Flavor: " + flavor + "\n" + "Toppings: " + toppings + "\n" + "Size: " + size + '\n');
    }

    // Static inner Builder class:
    public static class IceCreamBuilder {
        private String flavor;
        private int size;
        private String toppings;

        // Overloaded constructor to set mandatory attributes:
        public IceCreamBuilder(String flavor, int size) {
            this.flavor = flavor;
            this.size = size;
        }

        // Setters with return type IceCreamBuilder
        // to allow method chaining:

        public IceCreamBuilder setFlavor(String f) {
            flavor = f;
            return this;
        }

        public IceCreamBuilder setSize(int s) {
            size = s;
            return this;
        }

        public IceCreamBuilder setToppings(String t) {
            toppings = t;
            return this;
        }

        // Create and return an IceCream:
        public IceCream build() {
            return new IceCream(this);
        }
    }
}

class Person {

    // Mandatory Parameters
    private String name;
    private int age;

    // Optional Parameters
    private int salary;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.salary = builder.salary;
    }

    public static class PersonBuilder {
        private String name;
        private int age;

        // Optional Parameters
        private int salary;

        public PersonBuilder(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public PersonBuilder salary(int salary) {
            this.salary = salary;
            return this;
        }

        public Person builder() {
            Person person = new Person(this);
            validate(person);
            return person;
        }

        private void validate(Person person) {
            if (person.age < 0) {
                throw new RuntimeException("Age cant be negative");
            }
            if (person.salary < 0) {
                throw new RuntimeException("Salary cant be negative");
            }
        }
    }
}