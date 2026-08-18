package stream;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public Person(Optional<Car> car) {
        super();
        this.car = car;
    }

}
