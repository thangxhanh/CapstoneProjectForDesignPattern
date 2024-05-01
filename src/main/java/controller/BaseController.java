package controller;

import java.util.List;

import entity.cart.Cart;
import entity.cart.CartItem;
import entity.media.Media;

/**
 * This class is the base controller for our AIMS project
 * @author nguyenlm
 */
public class BaseController {
    //Common Coupling: Trong cả hai phương thức checkMediaInCart(Media media) và getListCartMedia(), đều sử dụng SessionInformation.cartInstance.
    /**
     * The method checks whether the Media in Cart, if it were in, we will return the CartMedia else return null
     * @param media
     * @return CartMedia or null
     */
    //Stamp Coupling: truyền toàn bộ của đối tượng Media.
    public CartItem checkMediaInCart(Media media){
        return Cart.getInstance().checkMediaInCart(media);
    }

    /**
     * This method gets the list of items in cart
     * @return List[CartMedia]
     */
    public List getListCartMedia(){
        return Cart.getInstance().getListMedia();
    }
}
