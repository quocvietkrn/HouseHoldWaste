import java.util.Scanner;

import controller.GarbageCollector;
import view.GarbageCollectionMenu;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the truck capacity (in grams): ");
        int truckCapacity = scanner.nextInt();
        System.out.println("Enter the time to dump (in minutes): ");
        int timeToDump = scanner.nextInt();
        System.out.println("Enter the labor and transportation cost per hour (in VND): ");
        int costPerHour = scanner.nextInt();
        System.out.println("Enter the station garbage cost (in VND): ");
        int stationCost = scanner.nextInt();

        GarbageCollector collector = new GarbageCollector(truckCapacity, timeToDump, costPerHour, stationCost);
        Menu menu = new GarbageCollectionMenu(collector);

        menu.processUserInput(scanner);
    }
}

