package com.base.code.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDate;

/**
 * @author yhc
 * @create 2021-02-23 14:54
 */
public class ClockClient {

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry();
        Clock clock = (Clock) registry.lookup("Clock");
        LocalDate localDate = clock.currentTime();
        System.out.println("RMI result:" + localDate);
    }

}
