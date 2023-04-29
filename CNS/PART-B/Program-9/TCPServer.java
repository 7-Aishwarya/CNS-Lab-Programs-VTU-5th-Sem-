//Server.java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
class server
{
    public static void main(String args[])throws Exception
    {
//create server socket on port 5000
        ServerSocket ss=new ServerSocket(5000);
        System.out.println ("Waiting for request");
        Socket s=ss.accept();
        System.out.println ("Connected With "+s.getInetAddress().toString());
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());

//reading file name from client
        String filename="";
        filename=din.readUTF();

        System.out.println("Sending File: "+filename);
        File f=new File(filename);

        FileInputStream fin=new FileInputStream(f);

        long sz=(int) f.length();
        byte b[]=new byte [1024];

        int read;

        while((read = fin.read(b)) != -1) // 	read(byte[] b)Reads up to b.length bytes of data from this input stream into an array of bytes.
        {
            dout.write(b, 0, read);
            dout.flush();
        }
        fin.close();
        System.out.println("..ok");
        dout.flush();

        dout.writeUTF("stop");
        System.out.println("Send Complete");
        dout.flush();

        din.close();
        s.close();
        ss.close();
    }//end of main
}//end of class