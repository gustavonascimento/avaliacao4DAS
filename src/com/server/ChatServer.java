package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import com.client.ClientInterface;

// Classe referente ao Skeleton do projeto, recebendo as chamadas do cliente 
// e enviando ao objeto remoto.
public class ChatServer extends UnicastRemoteObject implements ServerInterface {

	private static final long serialVersionUID = 1L;
	private ArrayList<ClientInterface> clients;

	protected ChatServer() throws RemoteException {
		clients = new ArrayList<ClientInterface>();
	}
	
	// Método para registrar o cliente no servidor
	@Override
	public synchronized void registerClient(ClientInterface client) throws RemoteException {
		this.clients.add(client);
	}
	
	// Serialização dos dados, no caso a mensagem
	@Override
	public synchronized void broadcastMessage(String message) throws RemoteException {
		int i=0;
		while (i < clients.size())
			this.clients.get(i++).retrieveMessage(message);
	}
	
}
