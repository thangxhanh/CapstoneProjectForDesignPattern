package utils.distance;

import org.example.AlternativeDistanceCalculator;

public class NewDistanceCalculate implements DistanceInterface{
    //su dung api moi
    private AlternativeDistanceCalculator alternativeDistanceCalculator;

    public NewDistanceCalculate() {
        this.alternativeDistanceCalculator = new AlternativeDistanceCalculator();
    }

    @Override
    public int calculateDistance(String address, String province) {
        String fullAddress = address + province;
        return alternativeDistanceCalculator.calculateDistance(fullAddress);

    }
}
