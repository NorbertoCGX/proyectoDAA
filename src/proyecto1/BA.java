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
public class BA {
    int id;
    int n1;
    int n2;
    int p = 1;
    
    
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
    public void setP(int p)
    {
        this.p = p;
    }
    public int getP()
    {
        return this.p;
    }
    
    public void iniciar(int numN) throws IOException{
    
        BA g [] = new BA[numN];
        Random r = new Random();
        String ruta = "C:\\Users\\Norbe\\Documents\\NetBeansProjects\\Proyecto1\\BA"+numN+".gv";
        File archivo = new File(ruta);
        BufferedWriter bw;
        
        for(int i = 0; i<g.length; i++)
        {
           g[i] = new BA();
           g[i].setId(i);
           
           g[i].setN1(r.nextInt(g.length));
           g[i].setN2(r.nextInt(g.length));
           
           System.out.println(g[i].getId()+"->"+g[i].getN1());
           System.out.println(g[i].getId()+"->"+g[i].getN2());
           
        }
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("graph BA"+numN+" { \n");
        for(int j = 0; j<g.length; j++)
        {
            bw.write(g[j].getId() +"->" + g[j].getN1() +"\n");
            bw.write(g[j].getId() +"->" + g[j].getN2() +"\n");
            
            
        }
        bw.write("}"); 
        
        bw.close();
        
        
    }
}
