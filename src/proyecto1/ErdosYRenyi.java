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
 * @author Norber
 */
public class ErdosYRenyi {
    
    int id;
    int n1;
    int n2;
    
    
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
    
    public void iniciar(int numN) throws IOException
    {
        ErdosYRenyi g [] = new ErdosYRenyi[numN];
        Random r = new Random();
        String ruta = "C:\\Users\\Norbe\\Documents\\NetBeansProjects\\Proyecto1\\ErdosYReny"+numN+".gv";
        File archivo = new File(ruta);
        BufferedWriter bw;
        int r1;
        int r2;
        
        for(int i = 0; i<g.length; i++)
        {
           g[i] = new ErdosYRenyi();
           g[i].setId(i);
           r1 = r.nextInt(g.length);
           r2 = r.nextInt(g.length);
           g[i].setN1(r1);
           g[i].setN2(r2); 
          
        }
        
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("graph ErdosYReny"+numN+" { \n");
                for(int i = 0; i<g.length; i++)
                {
                    bw.write(g[i].getId() +"->" + g[i].getN1() +"\n");
                    bw.write(g[i].getId() +"->" + g[i].getN2() +"\n");
                }
        bw.write("}");
                    
        bw.close();
   
    }
}
