package designPatterns.creational;

/**
 * The type Builder pattern.
 *
 * Aims to separate the Entity creation from the entity itself, by creating a new class responsible fore creating the entity
 *
 *
 */
public class BuilderPattern {

    public static ICarBuilder getCarBuilder(){
        return new CarBuilder();
    }

}

class Car {
    public Long id;
    public String model;
    public Integer year;
    public String color;
}

interface ICarBuilder {
    ICarBuilder setId(Long id);

    ICarBuilder setModel(String model);

    ICarBuilder setYear(Integer year);

    ICarBuilder setColor(String color);

    Car build();
}

class CarBuilder implements ICarBuilder {

    Car car;

    CarBuilder() {
        car = new Car();
    }

    @Override
    public ICarBuilder setId(Long id) {
        car.id = id;
        return this;
    }

    @Override
    public ICarBuilder setModel(String model) {
        if (car.id == null) {
            throw new RuntimeException();
        }
        car.model = model;
        return this;
    }

    @Override
    public ICarBuilder setYear(Integer year) {
        if (car.id == null) {
            throw new RuntimeException();
        }
        car.year = year;
        return this;
    }

    @Override
    public ICarBuilder setColor(String color) {
        if (car.id == null) {
            throw new RuntimeException();
        }
        car.color = color;
        return this;
    }

    @Override
    public Car build() {
        return car;
    }
}
