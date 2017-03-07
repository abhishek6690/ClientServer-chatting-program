import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
public static void main(String[] args) throws IOException {
BufferedReader in = null;
Socket clientSocket = null;
Scanner keyboard = new Scanner(System.in);
try {
clientSocket = new Socket("localhost", 4321);
Socket serverSocket = null;
serverSocket = clientSocket;
in = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
String s = "";
String r="";
do {
	r = in.readLine();
	System.out.println(r);
if(r.equalsIgnoreCase("bye")){break;}

	System.out.print("Enter a line for the server: ");
s = keyboard.nextLine();
out.println(s);
}while(!s.equalsIgnoreCase("bye"));

in.close();
clientSocket.close();
serverSocket.close();
}catch (IOException e) {
System.out.println("Error: " + e);
System.exit(0);
}
}
}
