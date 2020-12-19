/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Norbe
 */
public class Gilbert {
    
    int id;
    int n1;
    int n2;
    double p = 1;
    
    
    
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }
    public void setN1(int n1)
    {
        this.n1 = n1;
    }
    public int getN1()
    {
        return this.n1;
    }
    public void setN2(int n2)
    {
        this.n2 = n2;
    }
    public int getN2()
    {
        return this.n2;
    }
    public void setP(double p)
    {
        this.p = this.p-p;
    }
    public double getP()
    {
        return this.p;
    }
    
    public void iniciar(int numN) throws IOException
    {
        Gilbert g [] = new Gilbert[numN];
        Random r = new Random();
        String ruta = "C:\\Users\\Norbe\\Documents\\NetBeansProjects\\Proyecto1\\Gilbert"+numN+".gv";
        File archivo = new File(ruta);
        BufferedWriter bw;
        int r1;
        int r2;
        
        for(int i = 0; i<g.length; i++)
        {
           g[i] = new Gilbert();
           g[i].setId(i);
           r1 = r.nextInt(g.length);
           r2 = r.nextInt(g.length);
           
           if(r.nextFloat()<= g[i].getP())
           {
              g[i].setN1(r1);
              g[i].setN2(r2);  
              g[i].setP(0.10);
           }  
        }
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("graph Gilbert"+numN+" { \n");
        for(int j = 0; j<g.length; j++)
        {
            bw.write(g[j].getId() +"->" + g[j].getN1() +"\n");
            bw.write(g[j].getId() +"->" + g[j].getN2() +"\n");
            
            
        }
        bw.write("}"); 
        
        bw.close();
    }
}
