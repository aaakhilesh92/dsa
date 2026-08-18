package stream;

import java.util.Optional;

public class Car {
    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public Car(Optional<Insurance> insurance) {
        super();
        this.insurance = insurance;
    }

}
