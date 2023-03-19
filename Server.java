/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*/
import java.net.*;
import java.io.*;

class Server{
     

        ServerSocket server;
        Socket socket;
        BufferReader br;
        PrintWriter out;
        public Server(){
          try {
              server=new Serversocket(63381);
              System.out.println("Server is ready to accept connection");
              System.out.println("waiting"); 
              server.accept();
              br=new BufferReader(new InputStreamReader(socket.getInputStream()));
              out=new PrintWriter(socket.getOutputStream());
              
              startReading();
              startWriting();
              
          } catch(Exception e) {
              e.printStackTrace(); 
          }
        }
        
        
        
    public void startReading(){
        Runnable r1=()->{
        System.out.println("Reader Started....");
        while(true){
            try{
                
            
            
            String msg=br.readLine();
            if(msg.equals("exit")){
                System.out.println("client terminated the chat");
                break;
            }
            System.out.println("client:"+ msg);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        }
    };
        new Thread(r1).start();
     public void startWriting() 
     {
        System.out.println("writer started");
        Runnable r2=()->{
            while(true){
                try{
                    BufferedInputStream br1=new BufferReader(new InputStreamReader(System.in));
                String content=br1.readline();
                out.println(content);
                out.flush();
                    
                }
                catch( Exception e){
                    e.printStackTrace();
                    
                }
                }
            };
        }
        new Thread(r2).start();
    }
    
    public static void main(String[] args){
        System.out,.println("this this server ..going to start server");
        new Server();
        
        
    }
    }
}