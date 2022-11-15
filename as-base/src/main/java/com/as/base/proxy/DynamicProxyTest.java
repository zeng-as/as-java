package com.as.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author as
 * @date 2022/8/30
 * @desc
 */
public class DynamicProxyTest {
    public interface ISay {
        void say(String what);
    }

    public static class FrogSay implements ISay {

        @Override
        public void say(String what) {
            System.out.println("gua gua gua !!" + what);
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    public static class ISayInvocationHandler<T extends ISay> implements InvocationHandler {

        private T t;

        public ISayInvocationHandler(T t) {
            this.t = t;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("before say!");
            System.out.println(method.getName());
            method.invoke(t, args);
            System.out.println("end say!");
            return null;
        }
    }

    public static void main(String[] args) {
        ISay say = new FrogSay();
//        say.say("null");

        ISay say2 = (ISay) Proxy.newProxyInstance(ISay.class.getClassLoader(), new Class[]{ISay.class}, new ISayInvocationHandler(say));
        say2.say("mou");
    }
}
