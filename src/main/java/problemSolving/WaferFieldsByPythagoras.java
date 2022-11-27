package problemSolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WaferFieldsByPythagoras {

    private static final Integer CIRCLE_RADIUS = 150;

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            System.out.println(findMaximumMeasurementValue(parseLineToWafer(line)));
        }
    }

    private static float findMaximumMeasurementValue(Wafer wafer) {
        // TODO: Implement logic to find maximum measurement value of fully exposed field.
        List<Field> fullyExposedFields = findAllFullyExposedFields(wafer.fieldLayout);


        return findMaxValue(fullyExposedFields, wafer.measurements);

        // List<Measurement> measurementsInFullyExposedFields = filterMeasurementInFullyExposedFields(fullyExposedFields, wafer.measurements);

        // return findMaxValue(measurementsInFullyExposedFields);
    }

    private static List<Field> findAllFullyExposedFields(List<Field> fields) {
        return fields.stream().filter(WaferFieldsByPythagoras::isFieldInWafer).collect(Collectors.toList());
    }

    private static Boolean isFieldInWafer(Field field) {
        return
                isPointInWafer(field.centerX + (field.width / 2), field.centerY + (field.height / 2)) &&
                        isPointInWafer(field.centerX + (field.width / 2), field.centerY - (field.height / 2)) &&
                        isPointInWafer(field.centerX - (field.width / 2), field.centerY - (field.height / 2)) &&
                        isPointInWafer(field.centerX - (field.width / 2), field.centerY + (field.height / 2));
    }

    private static Boolean isPointInWafer(double x, double y) {
        double hypotenuse = Math.sqrt((Math.pow(x, 2) + Math.pow(y, 2)));
        return hypotenuse <= CIRCLE_RADIUS;
    }

    private static List<Measurement> filterMeasurementInFullyExposedFields(List<Field> fullyExposedFields, List<Measurement> measurements) {
        return measurements.stream().filter(measurement -> isMeasurementInFields(measurement, fullyExposedFields)).collect(Collectors.toList());
    }

    private static Boolean isMeasurementInFields(Measurement measurement, List<Field> fullyExposedFields) {
        for (Field field : fullyExposedFields) {
            if (isMeasurementInFiled(measurement, field)) {
                return true;
            }
        }
        return false;
    }


    private static Boolean isMeasurementInFiled(Measurement measurement, Field field) {
        return
                measurement.x <= (field.centerX + field.width / 2) &&
                        measurement.x >= (field.centerX - field.width / 2) &&
                        measurement.y <= (field.centerY + field.height / 2) &&
                        measurement.y >= (field.centerY - field.height / 2);
    }

    private static float findMaxValue(List<Measurement> measurements) {
        return (float) measurements.stream().mapToDouble(measurement -> measurement.value).max().orElse(0.0);
    }


    // Enhanded way by reducing number of iterations O(N * M) instead of O(2 * N * M)
    private static float findMaxValue(List<Field> fullyExposedFields, List<Measurement> measurements) {
        float maxValue = -1f;
        for (Field field : fullyExposedFields) {
            for (Measurement measurement : measurements) {
                if (isMeasurementInFiled(measurement, field)) {
                    maxValue = Float.max(maxValue, measurement.value);
                }
            }
        }
        return maxValue;
    }



    private static Wafer parseLineToWafer(String line) {
        String[] splittedString = line.split("\\|");

        List<Field> fieldLayout = Arrays.stream(splittedString[0].trim().split(";"))
                .map(f -> {
                    List<String> props = Arrays.stream(f.split(",")).filter(prop -> !prop.isEmpty()).collect(Collectors.toList());
                    if (props.size() == 2) {
                        return new Field(Double.parseDouble(props.get(0)), Double.parseDouble(props.get(1)), 26, 32);
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        List<Measurement> measurements = Arrays.stream(splittedString[1].trim().split(";"))
                .map(f -> {
                    List<String> props = Arrays.stream(f.split(",")).filter(prop -> !prop.isEmpty()).collect(Collectors.toList());
                    if (props.size() == 3) {
                        return new Measurement(Double.parseDouble(props.get(0)), Double.parseDouble(props.get(1)), Float.parseFloat(props.get(2)));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return new Wafer(300, fieldLayout, measurements);
    }

    private static class Wafer {
        double diameter;
        List<Field> fieldLayout;
        List<Measurement> measurements;

        public Wafer(double diameter, List<Field> fieldLayout, List<Measurement> measurements) {
            this.diameter = diameter;
            this.fieldLayout = fieldLayout;
            this.measurements = measurements;
        }
    }

    private static class Field {
        double centerX;
        double centerY;
        double width;
        double height;

        public Field(double centerX, double centerY, double width, double height) {
            this.centerX = centerX;
            this.centerY = centerY;
            this.width = width;
            this.height = height;
        }
    }

    private static class Measurement {
        double x;
        double y;
        float value;

        public Measurement(double x, double y, float value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}