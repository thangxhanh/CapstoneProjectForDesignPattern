package utils.distance;

import org.example.DistanceCalculator;

public class DistanceCalculate implements DistanceInterface {
    //su dung api cu

    private DistanceCalculator distanceCalculator;

    public DistanceCalculate() {
        this.distanceCalculator = new DistanceCalculator();
    }

    @Override
    public int calculateDistance(String address, String province) {
        return distanceCalculator.calculateDistance(address, province);
    }
}
