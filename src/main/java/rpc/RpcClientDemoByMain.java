package rpc;

import Entity.Request;
import com.alipay.remoting.exception.RemotingException;
import com.alipay.remoting.rpc.RpcClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RpcClientDemoByMain {
    static Logger logger = LoggerFactory.getLogger(RpcServerDemoByMain.class);
    private static RpcClient client;
    public RpcClientDemoByMain(){
        client = new RpcClient();
        client.init();
    }

    public static void main(String[] args) {
        new RpcClientDemoByMain();
        Request req = new Request();
        try {
            String res = (String) client.invokeSync("127.0.0.1:8999",req,3000);
            System.out.println("invoke sync result = [" + res + "]");
        }catch (RemotingException e){
            String errMsg = "RemotingException caught in oneway!";
            logger.error(errMsg, e);

        }catch (InterruptedException e) {
            logger.error("interrupted!");
        }
        client.shutdown();
    }
}
