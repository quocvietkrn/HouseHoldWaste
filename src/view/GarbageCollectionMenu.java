package view;

import java.util.Scanner;

import controller.GarbageCollector;
import model.GarbageStation;

public class GarbageCollectionMenu extends Menu {
    private GarbageCollector collector;

    public GarbageCollectionMenu(GarbageCollector collector) {
        this.collector = collector;
    }

    @Override
    public void displayMenu() {
        System.out.println("Garbage Collection Menu:");
        System.out.println("1. Estimate Cost");
        System.out.println("2. Exit");
    }

    @Override
    public void processUserInput(Scanner scanner) {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    estimateCost(scanner);
                    break;
                case 2:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        } while (choice != 2);
    }

    private void estimateCost(Scanner scanner) {
        System.out.println("Enter the amount of garbage at each station (in kilograms) as follows:");
        String input = scanner.next();
        String[] stationGarbageData = input.split(" ");
        GarbageStation[] stations = new GarbageStation[stationGarbageData.length];

        for (int i = 0; i < stationGarbageData.length; i++) {
            int garbageAmount = Integer.parseInt(stationGarbageData[i]) * 1000; // Convert to grams
            stations[i] = new GarbageStation(garbageAmount);
        }

        int estimatedCost = collector.estimateCost(stations);
        System.out.println("The total cost is " + estimatedCost + " VND");
    }
}

