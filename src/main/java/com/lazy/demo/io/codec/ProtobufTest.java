package com.lazy.demo.io.codec;

import com.lazy.demo.io.pojo.OrderMainProto;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/19.
 */
public class ProtobufTest {


    public static void main(String[] args) {


        OrderMainProto.OrderMain orderMain = OrderMainProto.OrderMain.newBuilder()

                .setCustomerName("zhangsan")
                .setCustomerNo("C100")
                .setId(1111)
                .setPayMoney(230.2)
                .setAddress(OrderMainProto.Address.newBuilder()
                        .setCity("011")
                        .setCityName("深圳")
                        .setProvince("01")
                        .setProvinceName("广东")
                        .setCounty("0111")
                        .setCountyName("南山")
                        .setStreet("01111")
                        .setStreetName("科技大道")

                        .build()
                )
                .addOrderDetail(
                        OrderMainProto.OrderDetail.newBuilder()
                                .setBuyNum(2)
                                .setSku("010111")
                                .setGoodsName("Lazy手机")
                                .setId(1)
                                .setUnitPrice(100.3)

                                .build()
                )
                .addOrderDetail(
                        OrderMainProto.OrderDetail.newBuilder()
                                .setBuyNum(3)
                                .setSku("010112")
                                .setGoodsName("Lazy手机2")
                                .setId(2)
                                .setUnitPrice(130.3)

                                .build()
                )

                .build();


        byte[] encode = orderMain.toByteArray();

        try {

            OrderMainProto.OrderMain decode = OrderMainProto.OrderMain.parseFrom(encode);

            System.out.println(decode.toString());
            System.out.println(decode.equals(orderMain));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
