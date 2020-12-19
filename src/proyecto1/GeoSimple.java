/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedWriter;
import java.io.File;
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
    
    public void iniciar(int numN)
    {
        GeoSimple g [] = new GeoSimple[numN];
        Random r = new Random();
        String ruta = "C:\\Users\\Norbe\\Documents\\NetBeansProjects\\Proyecto1\\GeoSimple"+numN+".gv";
        File archivo = new File(ruta);
        BufferedWriter bw;
        int r1;
        int r2;
        
        g[0] = new GeoSimple();
        g[0].setId(r.nextInt(g.length));
        
        for(int i = 1; i<g.length; i++)
        {
           g[i] = new GeoSimple();
           
           g[i].setId(r.nextInt(g.length));
            System.out.println(g[i].getId());
           
        }
        
    }
}
