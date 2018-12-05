package com.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

import com.server.ServerInterface;

// Classe referente ao Stub do projeto, sendo assim a camada mais próxima com o cliente.
public class ChatClient extends UnicastRemoteObject implements ClientInterface, Runnable {
	private static final long serialVersionUID = 1L;
	
	private ServerInterface server;
	private String name = "";

	private Scanner keyboard_input;
	
	// Registro do cliente no servidor, para que o mesmo seja capaz de estabelecer uma conexão
	// remota com o servidor.
	protected ChatClient(String name, ServerInterface server) throws RemoteException {
		 this.name = name;
		 this.server = server;
		 server.registerClient(this);
	}
	
	// Serialização para receber a mensagem (unnmarshalling)
	@Override
	public void retrieveMessage(String message) throws RemoteException {
		System.out.println(message);
	}
	
	// Serialização para enviar os dados, no caso a mensagem (marshalling)
	@Override
	public void run() {
		keyboard_input = new Scanner(System.in);
		String message;
		while (true) {
			System.out.print("> ");
			message = keyboard_input.nextLine();
			try {
				server.broadcastMessage(name + " says: " + message);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}	
	}
}
