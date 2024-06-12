package utils.shippingfee;

import entity.order.Order;
import utils.distance.DistanceInterface;

public class NewFeeCalculate extends ShippingFeeCalculate {
    public NewFeeCalculate(DistanceInterface distanceCalculator) {
        super(distanceCalculator);
    }

    //cong thuc moi tinh bang khoi luong, do cong kenh va khoang cach
    private int newFomulaFee(Order order){
        return 1000;
    }
    @Override
    public int shippingFeeCalculate(Order order, String address, String province){
        int fee1 =  distanceCalculator.calculateDistance(address, province) ;
        int fee2 = newFomulaFee(order) * 10;
        return fee1 + fee2;
    }


}
