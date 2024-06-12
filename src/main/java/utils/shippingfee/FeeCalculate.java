package utils.shippingfee;

import entity.order.Order;
import utils.distance.DistanceInterface;

public class FeeCalculate extends ShippingFeeCalculate {
    public FeeCalculate(DistanceInterface distanceCalculator){
        super(distanceCalculator);
    }
    @Override
    public int shippingFeeCalculate(Order order, String address, String province) {
        int distance = distanceCalculator.calculateDistance(address, province);
        return (int) (distance * 1.2);
    }
}
