package com.xw.spring.tag;

import com.xw.spring.factory.JsonRpcMultiServerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by huangdongbin on 2018/4/10.
 */
public class JsonrpcTag<T> implements InitializingBean {
    private String interfaceClazz;
    private T ref;//对象引用
    private String serviceName;//服务名称

    public String getInterfaceClazz() {
        return interfaceClazz;
    }

    public void setInterfaceClazz(String interfaceClazz) {
        this.interfaceClazz = interfaceClazz;
    }

    public T getRef() {
        return ref;
    }

    public void setRef(T ref) {
        this.ref = ref;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Class<?> clazz =  Class.forName(interfaceClazz);
        if (!clazz.isInterface())
            throw new RuntimeException(interfaceClazz +" is not interface");
        if (!ref.getClass().isAssignableFrom(clazz))
            throw new RuntimeException(ref.getClass().getName() +" is not implement " + interfaceClazz);
        JsonRpcMultiServerFactory.getInatance().getJsonRpcServer().addService(serviceName,ref,clazz);
        System.out.println("-------JsonrpcTag --- afterPropertiesSet-------");
    }
}
