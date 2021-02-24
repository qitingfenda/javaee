package com.base.code.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * @author yhc
 * @create 2021-02-23 14:48
 */
public class ClockServer {

    public static void main(String[] args) throws Exception {
        ClockImpl impl = new ClockImpl();
        Clock stub = (Clock) UnicastRemoteObject.exportObject(impl, 1099);
        LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("Clock", stub);
        System.out.println("Clock server reade.");
    }

}
