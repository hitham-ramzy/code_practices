package designPatterns.creational;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PrototypePattern {

    private static Map<Long, ShapeClass> shapeMap;

    static void loadCahche() {
        if (shapeMap == null) {
            shapeMap = new HashMap<>();
        }

        ShapeClass circle1 = new Circle(1L, "CIRCLE 1");
        shapeMap.put(circle1.getId(), circle1);

        ShapeClass circle2 = new Circle(2L, "CIRCLE 2");
        shapeMap.put(circle2.getId(), circle2);

        ShapeClass square1 = new Square(3L, "SQUARE 1");
        shapeMap.put(square1.getId(), square1);
        ShapeClass square2 = new Square(3L, "SQUARE 2");
        shapeMap.put(square2.getId(), square2);
    }

    static ShapeClass getInstance(Long id) throws CloneNotSupportedException {
        ShapeClass shape = shapeMap.get(id);
        return Optional.ofNullable(shape).map(shapeClass -> shape.clone()).orElseThrow(CloneNotSupportedException::new);
    }

    static class ShapeClass implements Cloneable {
        Long id;
        String name;

        ShapeClass(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        protected ShapeClass clone() {
            ShapeClass shape = null;
            try {
                shape = (ShapeClass) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return shape;
        }
    }

    static class Circle extends ShapeClass {

        Circle(Long id, String name) {
            super(id, name);
        }
    }

    static class Square extends ShapeClass {

        Square(Long id, String name) {
            super(id, name);
        }
    }
}
