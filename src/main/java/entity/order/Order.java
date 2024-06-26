package entity.order;

import controller.SessionInformation;
import entity.cart.Cart;
import entity.cart.CartItem;
import entity.shipping.DeliveryInfo;
import utils.shippingfee.ShippingFeeCalculate;
import views.screen.ViewsConfig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {

    private int shippingFees;
    private int subtotal;
    private int tax;
    private List orderMediaList;
    protected DeliveryInfo deliveryInfo;

    private ShippingFeeCalculate shippingFeeCalculate;

    public Order() {
        this.shippingFees = 0;
        this.subtotal = 0;
        this.tax = 0;
    }

    public Order(Cart cart, ShippingFeeCalculate shippingFeeCalculate) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Object object : SessionInformation.cartInstance.getListMedia()) {
            CartItem cartItem = (CartItem) object;
            OrderItem orderItem = new OrderItem(cartItem.getMedia(),
                    cartItem.getQuantity(),
                    cartItem.getPrice());
            orderItems.add(orderItem);
        }
        this.orderMediaList = Collections.unmodifiableList(orderItems);
        this.subtotal = cart.calSubtotal();
        this.tax = (int) (ViewsConfig.PERCENT_VAT/100) * subtotal;
        this.shippingFeeCalculate = shippingFeeCalculate;
    }

    public List getListOrderMedia() {
        return this.orderMediaList;
    }

    public int getShippingFees() {
      /*  if (deliveryInfo == null) return 0;
        return this.shippingFees;*/
        String address = this.deliveryInfo.getAddress();
        String province = this.deliveryInfo.getProvince();
        return shippingFeeCalculate.shippingFeeCalculate(this, address, province);
    }

    public DeliveryInfo getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(DeliveryInfo deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
        //this.shippingFees = deliveryInfo.calculateShippingFee(this);
        this.shippingFees = this.getShippingFees();
    }

    public List getOrderMediaList() {
        return orderMediaList;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public int getTax() {
        return tax;
    }

    public int getTotal() {
        return this.subtotal + this.tax + this.shippingFees;
    }
}
