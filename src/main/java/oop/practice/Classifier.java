package oop.practice;

import java.util.List;

public class Classifier {
    public String classify(Person person) {
        Boolean isHumanoid = person.isHumanoid();  // This can be null now
        String planet = person.getPlanet();        // Planet can be null
        Integer age = person.getAge();             // Age can be null
        List<String> traits = person.getTraits();  // Traits can be null or empty

        // Star Wars Universe
        if ((isHumanoid == null || !isHumanoid)
                && ("Kashyyyk".equals(planet) || planet == null) && age != null && age <= 400
                && traits != null && traits.containsAll(List.of("HAIRY", "TALL"))) {
            return "Star Wars";
        } else if ((isHumanoid == null || !isHumanoid)
                && "Endor".equals(planet) && age != null && age <= 60
                && (traits == null || traits.isEmpty() || traits.contains("SHORT"))) {
            return "Star Wars";
        }

        // Marvel Universe
        if ((isHumanoid == null || isHumanoid)
                && ("Asgard".equals(planet) || planet == null)
                && (age == null || age <= 5000)
                && traits != null && traits.containsAll(List.of("BLONDE", "TALL"))) {
            return "Marvel";
        }

        // Hitchhiker's Universe
        if ((isHumanoid == null || isHumanoid)
                && ("Betelgeuse".equals(planet) || planet == null) && age != null && age <= 100
                && (traits != null || traits.containsAll(List.of("EXTRA_ARMS", "EXTRA_HEAD")) || traits.contains("EXTRA_ARMS"))) {
            return "Hitchhiker";
        } else if ((isHumanoid == null || !isHumanoid)
                && ("Vogsphere".equals(planet) || planet == null) && age != null && age <= 200
                && traits != null && (traits.containsAll(List.of("GREEN", "BULKY")) || traits.contains("BULKY")) || traits.contains("GREEN")) {
            return "Hitchhiker";
        }

        // Lord of the Rings Universe
        if ((isHumanoid == null || isHumanoid)
                && ("Earth".equals(planet) || planet == null)
                && (traits == null || traits.isEmpty() || traits.containsAll(List.of("BLONDE", "POINTY_EARS")))) {
            return "Lord of the Rings";
        }
        else if ((isHumanoid == null || isHumanoid)
                && ("Earth".equals(planet) || planet == null) && (age == null || age <= 200)
                && (traits == null || (traits.containsAll(List.of("SHORT", "BULKY")) || traits.contains("BULKY")))) {
            return "Lord of the Rings";
        }

        return "Unknown";
    }
}

