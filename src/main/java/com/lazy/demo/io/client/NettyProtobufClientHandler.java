package com.lazy.demo.io.client;

import com.alibaba.fastjson.JSON;
import com.lazy.demo.io.pojo.OrderMainProto;
import com.lazy.demo.io.pojo.RpcReqProto;
import com.lazy.demo.io.pojo.RpcRespProto;
import com.lazy.demo.io.pojo.UserInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/18.
 */
public class NettyProtobufClientHandler extends ChannelInboundHandlerAdapter {

    private RpcReqProto.RpcReq getReq(long i) {
        OrderMainProto.OrderMain orderMain = OrderMainProto.OrderMain.newBuilder()

                .setCustomerName("zhangsan")
                .setCustomerNo("C100")
                .setId(i)
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
                                .setId(i)
                                .setUnitPrice(100.3)

                                .build()
                )
                .addOrderDetail(
                        OrderMainProto.OrderDetail.newBuilder()
                                .setBuyNum(3)
                                .setSku("010112")
                                .setGoodsName("Lazy手机2")
                                .setId(i)
                                .setUnitPrice(130.3)

                                .build()
                )

                .build();

        RpcReqProto.RpcReq req = RpcReqProto.RpcReq.newBuilder()

                .setBody(orderMain)
                .setClientId("1")
                .build();

        return req;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        for (int i = 0; i < 100; i++) {

            ctx.write(getReq(i));
        }
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        RpcRespProto.RpcResp resp = (RpcRespProto.RpcResp) msg;
        System.out.println("The protobuf client receive msg: " + resp.toString());

        Thread.sleep(5000);

        ctx.writeAndFlush(getReq(System.currentTimeMillis()));
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

}
