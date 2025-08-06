package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        this.year = year;
        this.color = color;
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(new Wheel(wheel.getRadius()));
        }
        this.wheels = copy;
        this.engine = engine == null ? null : new Engine(engine.getHorsePower(),
                engine.getManufacturer());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return year == car.year && Objects.equals(color, car.color)
                && Objects.equals(wheels, car.wheels) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, color, wheels, engine);
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel wheel : wheels) {
            copy.add(new Wheel(wheel.getRadius()));
        }
        return copy;
    }

    public Engine getEngine() {
        if (engine != null) {
            return new Engine(engine.getHorsePower(), engine.getManufacturer());
        }
        return null;
    }

    public Car changeEngine(Engine engine) {
        if (engine != null) {
            return new Car(this.year,this.color,this.wheels,engine);
        }
        return null;
    }

    public Car changeColor(String color) {
        return new Car(this.year,color,this.wheels,this.engine);
    }

    public Car addWheel(Wheel wheel) {
        List<Wheel> copy = new ArrayList<>();
        for (Wheel oldWheel : wheels) {
            copy.add(new Wheel(oldWheel.getRadius()));
        }
        copy.add(wheel);
        return new Car(this.year,this.color,copy,this.engine);
    }

    //implement this class

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }
}
