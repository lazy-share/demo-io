package com.lazy.demo.io.codec;

import org.msgpack.MessagePack;
import org.msgpack.template.Templates;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author laizhiyuan
 * @since 2020/2/18.
 */
public class MessagePackTest {

    public static void main(String[] args) throws IOException {

        List<String> src = new ArrayList<>();
        src.add("zhangsan");
        src.add("lisi");
        src.add("wangwu");

        MessagePack messagePack = new MessagePack();

        byte[] raw = messagePack.write(src);

        List<String> dst = messagePack.read(raw, Templates.tList(Templates.TString));

        System.out.println(dst.get(0));
    }
}
