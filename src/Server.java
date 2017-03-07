
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
public static void main(String[] args) {
Scanner keyboard = new Scanner(System.in);
ServerSocket serverSocket;
BufferedReader in;
try {
serverSocket = new ServerSocket(4321);
Socket clientSocket;
clientSocket = serverSocket.accept();
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),true);
out.println("Hello..!");
in = new BufferedReader(new
InputStreamReader(clientSocket.getInputStream()));
String r,s="";

do {
	r = in.readLine();
	System.out.println(r);
if(r.equalsIgnoreCase("bye")){break;}

	System.out.print("Enter a line for the server: ");
s = keyboard.nextLine();
out.println(s);
}while(!s.equalsIgnoreCase("bye"));
out.close();
serverSocket.close();
}catch (Exception e) {
System.out.println("Error: " + e);
System.exit(0);
}
}
}
