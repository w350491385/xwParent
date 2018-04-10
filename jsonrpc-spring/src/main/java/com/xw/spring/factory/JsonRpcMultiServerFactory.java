package com.xw.spring.factory;

import com.xw.spring.exception.ModelExceptionResolver;
import com.yzmy.jsonrpc4j.*;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huangdongbin on 2018/4/10.
 */
public class JsonRpcMultiServerFactory {

    private JsonRpcMultiServer jsonRpcMultiServer = null;
    private ReentrantLock lock = new ReentrantLock();

    private JsonRpcMultiServerFactory() {
    }

    public static JsonRpcMultiServerFactory getInatance() {
        return InnerClass.Instance;
    }

    public JsonRpcMultiServer getJsonRpcServer() {
        try {
            lock.lock();
            if (jsonRpcMultiServer != null) {
                jsonRpcMultiServer = new JsonRpcMultiServer();
                ErrorResolver xwErrorResolver = new MultipleErrorResolver(
                        ModelExceptionResolver.INSTANCE,
                        AnnotationsErrorResolver.INSTANCE,
                        DefaultErrorResolver.INSTANCE
                );
                jsonRpcMultiServer.setErrorResolver(xwErrorResolver);
                jsonRpcMultiServer.setSeparator('_');
            }
        } finally {
            lock.unlock();
        }
        return jsonRpcMultiServer;
    }

    private static class InnerClass {
        private final static JsonRpcMultiServerFactory Instance = new JsonRpcMultiServerFactory();
    }
}
