package com.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.server.ServerDriver;
import com.server.ServerInterface;

public class ClientDriver {
	
	public static void main (String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		String serverURL = "rmi://localhost/" + ServerDriver.serverName;
		
		ServerInterface server = (ServerInterface) Naming.lookup(serverURL);
		
		new Thread(new ChatClient(args[0], server)).start();
	}

}
