package com.xw.spring;

import com.xw.spring.factory.JsonRpcMultiServerFactory;
import com.yzmy.jsonrpc4j.JsonRpcMultiServer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by huangdongbin on 2018/4/10.
 */
public class JsonrpcDispatcher extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("=============JsonrpcDispatcher init()====================");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonRpcMultiServer jsonRpcMultiServer = getJsonRpcMultiServer();
        jsonRpcMultiServer.handle(req,resp);
        resp.getOutputStream().flush();
    }

    private JsonRpcMultiServer getJsonRpcMultiServer(){
        return JsonRpcMultiServerFactory.getInatance().getJsonRpcServer();
    }
}
