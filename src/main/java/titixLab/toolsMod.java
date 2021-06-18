package titixLab;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public interface toolsMod{
    static void sortByName(ArrayList<City> cityArrayList) {
        cityArrayList.sort(Comparator.comparing(City::getName, String::compareToIgnoreCase));
    }

    static void sortByDistrictPlusName(ArrayList<City> cityArrayList) {
        cityArrayList.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
    }

    static void printMaxInArray(ArrayList<City> cityArrayList) {
        City[] cities = cityArrayList.toArray(new City[0]);
        int max = Integer.MIN_VALUE;
        for (City city : cities) {
            if (max < city.getPopulation()) {
                max = city.getPopulation();
            }
        }
        for (int i = 0; i < cities.length; i++) {
            if (max == cities[i].getPopulation()) {
                System.out.println("[" + i + "]" + " = " + max);
            }
        }
    }

    static Map<String, Integer> searchCities(ArrayList<City> cityArrayList) {
        Map<String, Integer> citiesMap = new TreeMap();
        for (City city : cityArrayList) {
            citiesMap.put(city.getRegion(), 0);
        }
        for (Map.Entry<String, Integer> pair : citiesMap.entrySet()) {
            Integer integer = 0;
            for (City city : cityArrayList) {
                if (city.getRegion().equals(pair.getKey())) {
                    integer++;
                }
            }
            citiesMap.put(pair.getKey(), integer);
        }
        return citiesMap;
    }
}
