package entity.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.exception.MediaNotAvailableException;
import entity.media.Media;

//class Cart: Communicational cohesion vì tất cả các method đều dùng dữ liệu từ CartItem
//Singleton cho cart vì chỉ có 1 cart được tạo ra và sử dụng
//Nếu không sử dụng Singleton, không thể kiểm soát khi sử dụng đến cart thì ta đang sử dụng cart nào.
public class Cart {
    private static Cart Instance = new Cart();
    private List<CartItem> lstCartItem;

    public static Cart getInstance() {
        if(Instance == null) {
            Instance = new Cart();
        }

        return Instance;
    }

    private Cart() {
        lstCartItem = new ArrayList<>();
    }

    public void addCartMedia(CartItem cm){
        lstCartItem.add(cm);
    }

    public void removeCartMedia(CartItem cm){
        lstCartItem.remove(cm);
    }

    public List getListMedia(){
        return lstCartItem;
    }

    public void emptyCart(){
        lstCartItem.clear();
    }

    public int getTotalMedia(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getQuantity();
        }
        return total;
    }

    public int calSubtotal(){
        int total = 0;
        for (Object obj : lstCartItem) {
            CartItem cm = (CartItem) obj;
            total += cm.getPrice()*cm.getQuantity();
        }
        return total;
    }

    public void checkAvailabilityOfProduct() throws SQLException{
        boolean allAvailable = true;
        for (Object object : lstCartItem) {
            CartItem cartItem = (CartItem) object;
            int requiredQuantity = cartItem.getQuantity();
            int availQuantity = cartItem.getMedia().getQuantity();
            if (requiredQuantity > availQuantity) allAvailable = false;
        }
        if (!allAvailable) throw new MediaNotAvailableException("Some media not available");
    }

    //Stamp coupling: chỉ sử dụng thuộc tính id trong biến media truyền vào
    public CartItem checkMediaInCart(Media media){
        for (CartItem cartItem : lstCartItem) {
            if (cartItem.getMedia().getId() == media.getId()) return cartItem;
        }
        return null;
    }

}
