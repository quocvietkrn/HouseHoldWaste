package controller;

import model.GarbageStation;
import model.Truck;

public class GarbageCollector {
    private Truck truck;
    private int laborAndTransportationCostPerHour;
    private int stationGarbageCost;

    public GarbageCollector(int truckCapacity, int timeToDump, int costPerHour, int stationCost) {
        truck = new Truck(truckCapacity, timeToDump);
        laborAndTransportationCostPerHour = costPerHour;
        stationGarbageCost = stationCost;
    }

    public int estimateCost(GarbageStation[] stations) {
        int totalTime = 0;
        int totalCost = 0;

        for (GarbageStation station : stations) {
            truck.loadGarbage(station.getGarbageAmount());
            totalTime += 8; // Time to collect garbage at the station

            if (truck.getCurrentLoad() == 0) {
                totalTime += truck.getTimeToDump();
                totalCost += stationGarbageCost;
            }
        }

        totalTime += truck.getTimeToDump();

        int timeInHours = totalTime / 60;
        totalCost += timeInHours * laborAndTransportationCostPerHour;

        return totalCost;
    }
}


