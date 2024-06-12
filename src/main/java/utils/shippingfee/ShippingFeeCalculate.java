package utils.shippingfee;

import entity.order.Order;
import utils.distance.DistanceInterface;

public abstract class ShippingFeeCalculate {
    protected DistanceInterface distanceCalculator;

    public ShippingFeeCalculate(DistanceInterface distaneCalculator)
    {
        this.distanceCalculator = distaneCalculator;
    }

    public abstract int shippingFeeCalculate(Order order, String adddress, String province);
}
