package com.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

import com.client.ClientInterface;

public interface ServerInterface extends Remote {
	void registerClient(ClientInterface client) throws RemoteException;
	void broadcastMessage(String message) throws RemoteException;
}
