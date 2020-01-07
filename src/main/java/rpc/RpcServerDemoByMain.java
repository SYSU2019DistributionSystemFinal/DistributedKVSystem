package rpc;


import Entity.Request;
import com.alipay.remoting.BizContext;
import com.alipay.remoting.rpc.RpcServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RpcServerDemoByMain {
    static Logger logger = LoggerFactory.getLogger(RpcServerDemoByMain.class);
    RpcServer server;
    public RpcServerDemoByMain(){
        server = new RpcServer(8999);
        server.registerUserProcessor(new UserProcessor<Request>() {
            public Object handleRequest(BizContext bizContext, Request request) throws Exception {
                return "收到";
            }
        });
        if (server.start()) {
            System.out.println("server start ok!");
        } else {
            System.out.println("server start failed!");
        }
    }
    public static void main(String[] args) {
        new RpcServerDemoByMain();
    }
}
