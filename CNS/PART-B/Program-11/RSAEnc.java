import java.io.*;
import java.util.*;
import  java.math.BigInteger;
import java.lang.*;
class RSAEnc
{
	public static void main(String args[])
	{
		BigInteger publkey = new BigInteger(args[0]);
		BigInteger privkey = new BigInteger(args[1]);
		BigInteger n =new BigInteger(args[2]);
		int asciiVal =  Integer.parseInt(args[3]);
		BigInteger val = new BigInteger(""+asciiVal);
		BigInteger cipherval = val.modPow(publkey,n);
		System.out.println("Ciphertext "+cipherval);
		BigInteger plainval = cipherval.modPow(privkey,n);
		int plainVal = plainval.intValue();
		System.out.println("PlainText"+plainVal);
	}
}