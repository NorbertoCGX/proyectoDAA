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
public class GeoSimple {
    
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
        GeoSimple g [] = new GeoSimple[numN];
        Random r = new Random();
        String ruta = "C:\\Users\\Norbe\\Documents\\NetBeansProjects\\Proyecto1\\GeoSimple"+numN+".gv";
        File archivo = new File(ruta);
        BufferedWriter bw;
        int r1;
        int r2;
        int distancia = 2;
        boolean temp = false;
        boolean temp2 = false;
        
        for(int i = 0; i<g.length; i++)
        {
           temp = false;
           temp2 = false;
           g[i] = new GeoSimple();      
           g[i].setId(i);
           r1 = r.nextInt(g.length);
           do{
              if(r1-i <= distancia){
                  g[i].setN1(r1);
                  temp = true;
              }
              else{
                  r1 = r.nextInt(g.length);
              }
                  
           }while(temp == false);
            
           r2 = r.nextInt(g.length);
           do{
              if(r2-i <= distancia){
                  g[i].setN2(r2);
                  temp = true;
              }
              else{
                  r2 = r.nextInt(g.length);
              }
                  
           }while(temp == false);
           
           System.out.println(g[i].getId()+"->"+g[i].getN1());
           System.out.println(g[i].getId()+"->"+g[i].getN2());
        }
        bw = new BufferedWriter(new FileWriter(archivo));
        bw.write("graph GeoSimple"+numN+" { \n");
        for(int j = 0; j<g.length; j++)
        {
            bw.write(g[j].getId() +"->" + g[j].getN1() +"\n");
            bw.write(g[j].getId() +"->" + g[j].getN2() +"\n");
            
            
        }
        bw.write("}"); 
        
        bw.close();
        
    }
}
