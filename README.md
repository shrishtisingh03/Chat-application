# Client side Explanation........
This Java code defines a simple network client that can connect to a remote server over a network and engage in a chat with it.

Let's go over the code step-by-step:

The import statement imports the required Java libraries for working with network sockets and I/O streams.

The Client class is defined with three instance variables: a Socket object to establish a connection with the server, a BufferedReader object to read incoming messages from the server, and a PrintWriter object to send outgoing messages to the server.

The Client class constructor is defined. It creates a new Socket object, sets up the input and output streams for communication with the server, and starts two new threads, one for reading incoming messages from the server and another for writing outgoing messages to the server.

The startReading() method is defined. It creates a new thread that continuously reads incoming messages from the server and prints them to the console. If the server sends the message "exit", the method breaks out of the loop and terminates the chat.

The startWriting() method is defined. It creates a new thread that continuously reads user input from the console and sends it to the server via the PrintWriter object.

The main() method is defined. It simply creates a new Client object and starts the chat.

When the Client object is created and the main() method is invoked, the program connects to the server at the IP address "117.221.204.206" and port number 63381. The user can then enter messages in the console, which are sent to the server, and receive messages from the server, which are printed to the console.

Overall, this code demonstrates the basics of network programming with Java and how to use sockets, input streams, and output streams to establish a connection with a remote server and exchange data with it.
