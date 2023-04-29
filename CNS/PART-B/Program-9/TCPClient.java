import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

class client
{
    public static void main(String args[])throws Exception
    {
        String address = "";
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Server Address: ");
        address=sc.nextLine();

        Socket s=new Socket(address,5000);
        DataInputStream din=new DataInputStream(s.getInputStream());
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String filename="";

//read the file name
        System.out.println("Enter File Name: ");
        filename=sc.nextLine();
        sc.close();
        dout.writeUTF(filename);

        System.out.println("Receving file: "+filename);
        filename="client"+filename;
        System.out.println("Saving as file: "+filename);
        byte b[]=new byte [1024];
        System.out.println("Receving file..");
        FileOutputStream fos=new FileOutputStream(new File(filename),true);
        long bytesRead;
        do
        {
            bytesRead = din.read(b, 0, b.length);
            fos.write(b,0,b.length);
        }while(!(bytesRead<1024));
        System.out.println("Completed");
        fos.close();
        dout.close();
        s.close();
    } //end of main
}//end of class