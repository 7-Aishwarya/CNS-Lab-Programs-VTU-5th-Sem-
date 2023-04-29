import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
public class CRC
{
    public static void main(String args[])throws IOException
    {
        Scanner sc =new Scanner(System.in);
        int div[],divisor[],rem[],crc[];
        int data_bits,divisor_bits,tot_length;
        int i,j;
        System.out.println("Enter the number of data bits ");
        data_bits =sc.nextInt();
        int data[]=new int[data_bits];
        System.out.println("Enter the data bits ");
        for(i=0;i<data_bits;i++)
        data[i]=sc.nextInt();
        System.out.println("Enter the number of divisor bits ");
        divisor_bits=sc.nextInt();
        divisor=new int[divisor_bits];
        System.out.println("Enter the divisor bits ");
        for(i=0;i<divisor_bits;i++)
        divisor[i]=sc.nextInt();
        System.out.println("The data bits are ");
        for(i=0;i<data_bits;i++)
        System.out.print(data[i]);
        System.out.println();
        System.out.println("The divisor bits are ");
        for(i=0;i<divisor_bits;i++)
        System.out.print(divisor[i]);
        System.out.println();
        tot_length=data_bits+divisor_bits-1;
        div=new int[tot_length];
        rem=new int [tot_length];
        crc=new int[tot_length];
        for(i=0;i<data.length;i++)
        div[i]=data[i];
        System.out.println("Dividend after appending zeros");
        for(i=0;i<div.length;i++)
        System.out.print(div[i]);
        System.out.println();
        for(j=0;j<div.length;j++)
        {
            rem[j]=div[j];
        }
        rem=divide(div,divisor,rem);
        for(i=0;i<div.length;i++)
        {
            crc[i]=(div[i]^rem[i]);
        }
        System.out.println("The code word ");
        for(i=0;i<crc.length;i++)
        System.out.print(crc[i]);
        System.out.println();
        System.out.println("Enter the code word ");
        for(i=0;i<crc.length;i++)
        crc[i]=sc.nextInt();
        for(j=0;j<crc.length;j++)
        {
            rem[j]=crc[j];
        }
        rem=divide(crc,divisor,rem);
        for(i=0;i<rem.length;i++)
        {
            if(rem[i]!=0)
            {
                System.out.println("Error");
                break;
            }
            if(i==rem.length-1)
            
                System.out.println("No error");
            
        }
    }
    static int[] divide(int []div,int []divisor, int []rem)
    {
        int cur=0;
        while(true)
        {
            for(int i=0;i<divisor.length;i++ )
                rem[cur+i]=(rem[cur+i]^divisor[i]);
            while(rem[cur]==0 && cur!=rem.length-1)
                cur++;
            if((rem.length-cur)<divisor.length)
                break;
        }
        return rem;
    }

}