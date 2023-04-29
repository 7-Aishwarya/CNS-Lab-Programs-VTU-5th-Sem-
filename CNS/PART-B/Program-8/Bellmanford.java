import java.io.*;
import java.util.Scanner;
public class BellmanFord
{
    private int d[];
    private int num_vertex;
    public static final int max_value=999;
    public BellmanFord(int num_vertex)
    {
        this.num_vertex = num_vertex;
       d=new int[num_vertex+1];
    }
    public void BellmanFordEvaluation(int source,int a[][])
    {
        int node,sn,dn,vertex;
        for(node=1;node<=num_vertex;node++)
        {
            d[node]=max_value;
        }
        d[source]=0;
        for(node=1;node<=num_vertex-1;node++)
        {
            for(sn=1;sn<=num_vertex;sn++)
            {
                for(dn=1;dn<=num_vertex;dn++)
                {
                    if(a[sn][dn]!=max_value)
                    {
                        if(d[dn]>d[sn]+a[sn][dn])
                        d[dn]=d[sn]+a[sn][dn];
                    }
                }
            }
        }
        for(sn=1;sn<=num_vertex;sn++)
        {
            for(dn=1;dn<=num_vertex;dn++)
            {
                if(a[sn][dn]!=max_value)
                {
                      if(d[dn]>d[sn]+a[sn][dn])
                      System.out.println("Graph with negative edges");
                }
            }
        }
        for(vertex=1;vertex<=num_vertex;vertex++)
        {
            System.out.println("The distance from source " +source + " to " +vertex + " is "+d[vertex]);
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int num_vertex=0;
        int source;
        int sn,dn;
        System.out.println("Enter the number of vertex");
        num_vertex=sc.nextInt();
        int a[][]=new int[num_vertex+1][num_vertex+1];
        System.out.println("Enter adjacency matrix ");
        for(sn=1;sn<=num_vertex;sn++)
        {
            for(dn=1;dn<=num_vertex;dn++)
            {
                a[sn][dn]=sc.nextInt();
                if(sn==dn)
                {
                    a[sn][dn]=0;
                    continue;
                }
                if(a[sn][dn]==0)
                {
                    a[sn][dn]=max_value;
                }
            }
        }
        System.out.println("Enter source vertex ");
        source = sc.nextInt();
        BellmanFord b = new BellmanFord(num_vertex);
        b.BellmanFordEvaluation(source,a);
        sc.close();
    }
}