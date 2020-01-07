import raft.Node;
import raft.NodeConfig;
import raft.NodeImpl;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws Throwable {
        System.out.println(System.getProperty("serverPort"));
        String[] peerAddr = {"localhost:8801","localhost:8802","localhost:8803","localhost:8804","localhost:8805"};
        NodeConfig config = new NodeConfig();
        // 自身节点
        config.setSelfPort(Integer.valueOf(System.getProperty("serverPort")));
        // 其他节点地址
        config.setPeerAddrs(Arrays.asList(peerAddr));
        Node node = new NodeImpl();
        node.setConfig(config);
        node.init();
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                node.destroy();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }));
    }
}
