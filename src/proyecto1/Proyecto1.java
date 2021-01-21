/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author Norbe
 */
public class Proyecto1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException  {
        // TODO code application logic here
        
       
       
        Grafo EYR1 = new Grafo(30);
        Grafo EYR2 = new Grafo(100);
        Grafo EYR3 = new Grafo(500);
        
        Grafo Gilbert1 = new Grafo(30);
        Grafo Gilbert2 = new Grafo(100);
        Grafo Gilbert3 = new Grafo(500);
        
        Grafo Geo1 = new Grafo(30);
        Grafo Geo2 = new Grafo(100);
        Grafo Geo3 = new Grafo(500);
        
        Grafo BA1 = new Grafo(30);
        Grafo BA2 = new Grafo(100);
        Grafo BA3 = new Grafo(500);
        
//////////////////////////// 1er entrega
        
        EYR1.modeloErdosyRenyi(30);
        EYR1.escribirArchivo("ErdosYRenyi30");
        EYR2.modeloErdosyRenyi(100);
        EYR2.escribirArchivo("ErdosYRenyi100");
        EYR3.modeloErdosyRenyi(1000);
        EYR3.escribirArchivo("ErdosYRenyi500");

        Gilbert1.modeloGilbert(0.4);
        Gilbert1.escribirArchivo("Gilbert30");
        Gilbert2.modeloGilbert(0.6);
        Gilbert2.escribirArchivo("Gilbert100");
        Gilbert3.modeloGilbert(0.8);
        Gilbert3.escribirArchivo("Gilbert500");
        
        Geo1.modeloGeografico(3);
        Geo1.escribirArchivo("Geografico30");
        Geo2.modeloGeografico(2.5);
        Geo2.escribirArchivo("Geografico100");
        Geo3.modeloGeografico(5);
        Geo3.escribirArchivo("Geografico500"); 
        
        BA1.modeloBarabasiAlbert(10);
        BA1.escribirArchivo("BA30");
        BA2.modeloBarabasiAlbert(50);
        BA2.escribirArchivo("BA100");
        BA3.modeloBarabasiAlbert(100);
        BA3.escribirArchivo("BA500");
        
////////////////////////////////////        Algoritmo de DFS y BFS

        Grafo bfsEyR1 = EYR1.BFS(0);
        bfsEyR1.escribirArchivo("bfsEYR30");
        Grafo dfsREyR1 = EYR1.DFS_R(0);
        dfsREyR1.escribirArchivo("dfsREyR30");
        Grafo dfsIEYR1 = EYR1.DFS_I(0);
        dfsIEYR1.escribirArchivo("dfsIEYR30");
        
        Grafo bfsEyR2 = EYR2.BFS(0);
        bfsEyR2.escribirArchivo("bfsEYR100");
        Grafo dfsREyR2 = EYR2.DFS_R(0);
        dfsREyR2.escribirArchivo("dfsREyR100"); 
        Grafo dfsIEYR2 = EYR2.DFS_I(0);
        dfsIEYR2.escribirArchivo("dfsIEYR100");
        
        Grafo bfsEyR3 = EYR3.BFS(0);
        bfsEyR3.escribirArchivo("bfsEYR500");
        Grafo dfsREyR3 = EYR3.DFS_R(0);
        dfsREyR3.escribirArchivo("dfsREyR500"); 
        Grafo dfsIEYR3 = EYR3.DFS_I(0);
        dfsIEYR3.escribirArchivo("dfsIEYR500");
         
        Grafo bfsGilbert1 = Gilbert1.BFS(0);
        bfsGilbert1.escribirArchivo("bfsGilbert30");
        Grafo dfsRGilbert1 = Gilbert1.DFS_R(0);
        dfsRGilbert1.escribirArchivo("dfsRGilbert30"); 
        Grafo dfsIGilbert1 = Gilbert1.DFS_I(0);
        dfsIGilbert1.escribirArchivo("dfsIGilbert30");
        
        Grafo bfsGilbert2 = Gilbert2.BFS(0);
        bfsGilbert2.escribirArchivo("bfsGilbert100");
        Grafo dfsRGilbert2 = Gilbert2.DFS_R(0);
        dfsRGilbert2.escribirArchivo("dfsRGilbert100"); 
        Grafo dfsIGilbert2 = Gilbert2.DFS_I(0);
        dfsIGilbert2.escribirArchivo("dfsIGilbert100");

        Grafo bfsGilbert3 = Gilbert3.BFS(0);
        bfsGilbert3.escribirArchivo("bfsGilbert500");
        Grafo dfsRGilbert3 = Gilbert3.DFS_R(0);
        dfsRGilbert3.escribirArchivo("dfsRGilbert500"); 
        Grafo dfsIGilbert3 = Gilbert3.DFS_I(0);
        dfsIGilbert3.escribirArchivo("dfsIGilbert500");
        
        Grafo bfsGeo1 = Geo1.BFS(0);
        bfsGeo1.escribirArchivo("bfsGeo30");
        Grafo dfsRGeo1 = Geo1.DFS_R(0);
        dfsRGeo1.escribirArchivo("dfsRGeo30"); 
        Grafo dfsIGeo1 = Geo1.DFS_I(0);
        dfsIGeo1.escribirArchivo("dfsIGeo30");

        Grafo bfsGeo2 = Geo2.BFS(0);
        bfsGeo2.escribirArchivo("bfsGeo100");
        Grafo dfsRGeo2 = Geo2.DFS_R(0);
        dfsRGeo2.escribirArchivo("dfsRGeo100"); 
        Grafo dfsIGeo2 = Geo2.DFS_I(0);
        dfsIGeo2.escribirArchivo("dfsIGeo100");
            
        Grafo bfsGeo3 = Geo3.BFS(0);
        bfsGeo3.escribirArchivo("bfsGeo500");
        Grafo dfsRGeo3 = Geo3.DFS_R(0);
        dfsRGeo3.escribirArchivo("dfsRGeo500"); 
        Grafo dfsIGeo3 = Geo3.DFS_I(0);
        dfsIGeo3.escribirArchivo("dfsIGeo500");
        
        Grafo bfsBA1 = BA1.BFS(0);
        bfsBA1.escribirArchivo("bfsBA30");
        Grafo dfsRBA1 = BA1.DFS_R(0);
        dfsRBA1.escribirArchivo("dfsRBA30"); 
        Grafo dfsIBA1 = BA1.DFS_I(0);
        dfsIBA1.escribirArchivo("dfsIBA30");
        
        Grafo bfsBA2 = BA2.BFS(0);
        bfsBA2.escribirArchivo("bfsBA100");
        Grafo dfsRBA2 = BA2.DFS_R(0);
        dfsRBA2.escribirArchivo("dfsRBA100"); 
        Grafo dfsIBA2 = BA2.DFS_I(0);
        dfsIBA2.escribirArchivo("dfsIBA100");
        
        Grafo bfsBA3 = BA3.BFS(0);
        bfsBA3.escribirArchivo("bfsBA500");
        Grafo dfsRBA3 = BA3.DFS_R(0);
        dfsRBA3.escribirArchivo("dfsRBA500"); 
        Grafo dfsIBA3 = BA3.DFS_I(0);
        dfsIBA3.escribirArchivo("dfsIBA500");
        
        

            
      
     
       
        

    }
    
}
