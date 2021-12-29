package leaddemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author machitao
 * @date 2021/12/24
 * @description
 */
public class ProxyTest {
    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("get")) {
                    System.out.println("gethahahaahaha");
                    method.invoke(new HelloInterfaceImpl(), args);
                }
                return null;
            }
        };
        HelloInterface helloInterface = (HelloInterface) Proxy.newProxyInstance(
                HelloInterface.class.getClassLoader(),
                new Class[]{HelloInterface.class},
                handler
        );
        helloInterface.get();
    }
}
