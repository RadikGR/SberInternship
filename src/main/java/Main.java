import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("Задача ВС Java Сбер.csv"));
//        Scanner scanner = new Scanner(System.in);
        List<City> citiesList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] cities = line.split(";", 6);

            String name = cities[1].length() > 0 ? cities[1] : null;
            String region = cities[2].length() > 0 ? cities[2] : null;
            String district = cities[3].length() > 0 ? cities[3] : null;
            Long population = cities[4].length() > 0 ? Long.parseLong(cities[4]) : null;
            String foundation = cities[5].length() > 0 ? cities[5] : null;

            citiesList.add(new City(name, region, district, population, foundation));
        }

        citiesList.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));

        citiesList.sort(Comparator.comparing(City::getDistrict)
                .thenComparing(City::getName));

        for (City city : citiesList) {
            System.out.println(city);
        }

        City[] cities = Arrays.copyOf(citiesList.toArray(), citiesList.toArray().length, City[].class);
        int maxIndex = 0;
        for (int i = 0; i < cities.length; i++) {
            if (cities[i].getPopulation() > cities[maxIndex].getPopulation()) {
                maxIndex = i;
            }
        }
        System.out.println("[" + maxIndex + "] = " + cities[maxIndex].getPopulation());
    }
}
