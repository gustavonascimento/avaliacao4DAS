# RMI - Chat App

The code was developed by students originally in this repository:
https://github.com/freemanpivo/rmi_chat

## 1. Dependencies

*   Java
*   RMI

## 2. Setup RMI files

Clone the repository:

```
$ git clone https://github.com/freemanpivo/rmi_chat.git
```

Enter bin/ folder:

```
$ cd rmi_chat/bin/
```

Compile RMI ChatClient

```
$ rmic com.client.ChatClient
```

Compile RMI ChatServer

```
$ rmic com.server.ChatServer
```

Open RMI registry

```
$ rmiregistry
```

## 3. Start Server

Open another tab in your terminal and certifies that you are into bin/ folder.

```
$ cd rmi_chat/bin/
```

Start the server.

```
$ java com.server.ServerDriver
```

## 4. Start a Client

Open another tab in your terminal and certifies that you are into bin/ folder.

```
$ cd rmi_chat/bin/
```

Start a Client with your name.

```
$ java com.client.ClientDriver YOUR_NAME_HERE
```

Now you can write things into the terminal!
So, if you want to talk to someone else, you need to open a new tab and redo the steps described in this section.
