package com.base.code.design;

/**
 * 代理模式
 *
 * @author yhc
 * @date 2019-07-02 9:02
 */
public class Proxy {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);
        proxyServer.browse();
    }
}

interface NetWork {
    void browse();
}

/**
 * 被代理类
 */
class Server implements NetWork {
    @Override
    public void browse() {
        System.out.println("真实的服务器访问网络！");
    }
}

class ProxyServer implements NetWork {

    private NetWork work;

    public ProxyServer(NetWork work) {
        this.work = work;
    }

    public void check() {
        System.out.println("联网之前的检查工作！");
    }

    @Override
    public void browse() {
        check();
        work.browse();
    }
}




