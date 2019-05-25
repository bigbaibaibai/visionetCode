package xyz.thishome.phone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import xyz.thishome.common.pojo.PhoneMsg;
import xyz.thishome.phone.pojo.TbItemCat;
import xyz.thishome.phone.service.ItemCartService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/cat")
public class ItemCartController {

    @Autowired
    private ItemCartService itemCartService;

    @Value("${CART_NO_PARENT}")
    private String CART_NO_PARENT;

    @Value("${CART_NO_CHILD}")
    private String CART_NO_CHILD;

    @Value("${CART_EXPIRE_TIEM}")
    private Long CART_EXPIRE_TIEM;

    @GetMapping("/getUp")
    public PhoneMsg getCartNoParent(@RequestParam("size") Integer size, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        List<TbItemCat> cartList = null;
        try {
            cartList = itemCartService.getCartListFromRedis(CART_NO_PARENT, CART_EXPIRE_TIEM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cartList != null) {
            return PhoneMsg.success(cartList);
        }

        cartList = itemCartService.getCartNoParent(size);

        try {
            itemCartService.addToRedis(CART_NO_PARENT, cartList, CART_EXPIRE_TIEM);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return PhoneMsg.success(cartList);
    }

    @GetMapping("/getLeft")
    public PhoneMsg getCartNoChild(@RequestParam("size") Integer size, HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");

        List<TbItemCat> cartList = null;
        try {
            cartList = itemCartService.getCartListFromRedis(CART_NO_CHILD, CART_EXPIRE_TIEM);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cartList != null) {
            return PhoneMsg.success(cartList);
        }

        cartList = itemCartService.getCartNoChild(size);

        try {
            itemCartService.addToRedis(CART_NO_CHILD, cartList, CART_EXPIRE_TIEM);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return PhoneMsg.success(cartList);

    }

}
