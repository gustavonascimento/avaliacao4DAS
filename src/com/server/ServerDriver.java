package com.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ServerDriver {
	
	public static String serverName = "RMI_ChatServer";
	
	public static void main (String[] args) throws RemoteException, MalformedURLException {
		Naming.rebind(serverName, new ChatServer());
	}
}
