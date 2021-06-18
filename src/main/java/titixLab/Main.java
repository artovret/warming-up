package titixLab;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main implements toolsMod{

    public static void main(String[] args) {
        // BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/Users/u19224031/IdeaProjects/rank/src/com/company/newFile1.txt")));
        String fileName = "/Users/u19224031/IdeaProjects/citiesProject/src/com/company/Cities.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = null;
        ArrayList<City> cityArrayList = null;
        try {
            scanner = new Scanner(path);
            //построчно считываем файл
            scanner.useDelimiter(System.getProperty("line.separator"));
            String[] str;
            cityArrayList = new ArrayList<>();
            while (scanner.hasNext()) {
                str = scanner.next().split(";");
                cityArrayList.add(new City(str[1], str[2], str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5])));
            }
        } catch (IOException e) {
            System.out.println("Не находим файл");
            e.printStackTrace();
        } finally {
            assert scanner != null;
            scanner.close();
        }
        System.out.println("Mod1");
        for (City city : cityArrayList) {
            System.out.println(city);
        }
        System.out.println("Mod2");
        toolsMod.sortByName(cityArrayList);
        for (City city : cityArrayList) {
            System.out.println(city);
        }
        toolsMod.sortByDistrictPlusName(cityArrayList);
        System.out.println("======");
        for (City city : cityArrayList) {
            System.out.println(city);
        }
        System.out.println("Mod3");
        toolsMod.printMaxInArray(cityArrayList);
        System.out.println("Mod4");
        toolsMod.searchCities(cityArrayList).forEach((k, v) -> System.out.println(k + " " + v));
    }
}
