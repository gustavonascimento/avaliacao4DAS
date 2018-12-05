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
		
		// Referência que o Cliente tem do Servidor
		ServerInterface server = (ServerInterface) Naming.lookup(serverURL);
		
		// Permite que vários clientes se conectem ao servidor
		new Thread(new ChatClient(args[0], server)).start();
	}

}
