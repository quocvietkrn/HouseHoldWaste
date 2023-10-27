package model;

public class Truck {
    private int capacity; // Công suất tối đa của xe tải tính bằng gam
    private int currentLoad; // Tải trọng hiện tại của xe tải tính bằng gam
    private int timeToDump; // Thời gian (tính bằng phút) để đi đến bãi rác và quay lại

    public Truck(int capacity, int timeToDump) {
        this.capacity = capacity;
        this.timeToDump = timeToDump;
        this.currentLoad = 0;
    }

    public int getCurrentLoad() {
        return currentLoad;
    }

    public void loadGarbage(int amount) {
        if (currentLoad + amount <= capacity) {
            currentLoad += amount;
        } else {
            dumpGarbage();
            loadGarbage(amount);
        }
    }

    public void dumpGarbage() {
        currentLoad = 0;
    }

    public int getTimeToDump() {
        return timeToDump;
    }
}


