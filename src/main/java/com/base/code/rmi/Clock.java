package com.base.code.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

/**
 * @author yhc
 * @create 2021-02-23 14:46
 */
public interface Clock extends Remote {

    LocalDate currentTime() throws RemoteException;

}
