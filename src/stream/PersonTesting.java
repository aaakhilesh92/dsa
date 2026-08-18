package stream;

import java.util.Optional;

public class PersonTesting {

    public static void main(String[] args) {
        Insurance insurance = new Insurance("ABC", 2020);
        Optional<Insurance> optIn = Optional.of(insurance);
        Car car = new Car(optIn);
        Person person = new Person(Optional.of(car));
        Optional<Person> optP = Optional.of(person);
        Insurance i2 = optIn.get();
        System.out.println(i2);
        Optional<String> name = optIn.map(Insurance::getInsuranceName);
        System.out.println(name);
        Optional<Car> c1 = optP.get().getCar();
        Optional<String> c2 = optP.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getInsuranceName);
        System.out.println(c2);
    }

}
