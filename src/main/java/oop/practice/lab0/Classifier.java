package oop.practice.lab0;

import java.util.List;

public class Classifier {
    public String classify(Person person) {
        Boolean isHumanoid = person.isHumanoid();
        String planet = person.getPlanet();
        Integer age = person.getAge();
        List<String> traits = person.getTraits();

        // Star Wars Universe
        String StarWars = isStarWars(isHumanoid, planet, age, traits);
        if (StarWars != null) return StarWars;

        // Marvel Universe
        String Marvel = isMarvel(isHumanoid, planet, age, traits);
        if (Marvel != null) return Marvel;

        // Hitchhiker's Universe
        String Hitchhiker = isHitchHicker(isHumanoid, planet, age, traits);
        if (Hitchhiker != null) return Hitchhiker;

        // Lord of the Rings Universe
        String LordOfRings = isLordOfRings(isHumanoid, planet, traits, age);
        if (LordOfRings != null) return LordOfRings;

        return "Unknown";
    }

    private static String isStarWars(Boolean isHumanoid, String planet, Integer age, List<String> traits) {
        if ((isHumanoid == null || !isHumanoid)
                && ("Kashyyk".equals(planet) || planet == null) && age != null && age <= 400
                && traits != null && traits.containsAll(List.of("HAIRY", "TALL"))) {
            return "Star Wars";
        } else if ((isHumanoid == null || !isHumanoid)
                && "Endor".equals(planet) && age != null && age <= 60
                && (traits == null || traits.isEmpty() || traits.contains("SHORT"))) {
            return "Star Wars";
        }
        return null;
    }

    private static String isMarvel(Boolean isHumanoid, String planet, Integer age, List<String> traits) {
        if ((isHumanoid == null || isHumanoid)
                && ("Asgard".equals(planet) || planet == null)
                && (age == null || age <= 5000)
                && traits != null && traits.containsAll(List.of("BLONDE", "TALL"))) {
            return "Marvel";
        }
        return null;
    }

    private static String isLordOfRings(Boolean isHumanoid, String planet, List<String> traits, Integer age) {
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
        return null;
    }

    private static String isHitchHicker(Boolean isHumanoid, String planet, Integer age, List<String> traits) {
        if ((isHumanoid == null || isHumanoid)
                && ("Betelgeuse".equals(planet) || planet == null) && age != null && age <= 100
                && (traits != null || traits.containsAll(List.of("EXTRA_ARMS", "EXTRA_HEAD")) || traits.contains("EXTRA_ARMS"))) {
            return "Hitchhiker";
        } else if ((isHumanoid == null || !isHumanoid)
                && ("Vogsphere".equals(planet) || planet == null) && age != null && age <= 200
                && traits != null && (traits.containsAll(List.of("GREEN", "BULKY")) || traits.contains("BULKY")) || traits.contains("GREEN")) {
            return "Hitchhiker";
        }
        return null;
    }
}

