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
import static proyecto1.Grafo.BFS;
import static proyecto1.Grafo.Barabasi;
import static proyecto1.Grafo.DFS_I;
import static proyecto1.Grafo.DFS_R;
import static proyecto1.Grafo.ErdosRenyi;
import static proyecto1.Grafo.Geografico;
import static proyecto1.Grafo.Gilbert;
import static proyecto1.Grafo.construir;

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
        
       
//        Primer entrega

        Grafo GER = new Grafo();
        GER = ErdosRenyi(30,100);
        construir("Entrega1\\Erdos y Renyi-30", GER);
        GER = ErdosRenyi(100,500);
        construir("Entrega1\\Erdos y Renyi-100", GER);
        GER = ErdosRenyi(500,1000);
        construir("Entrega1\\Erdos y Renyi-500", GER);
        
        Grafo GGIL = new Grafo();
        GGIL = Gilbert(30,.2);
        construir("Entrega1\\GIlbert-30", GGIL);
        GGIL = Gilbert(100,.2);
        construir("Entrega1\\GIlbert-100", GGIL);
        GGIL = Gilbert(500,.2);
        construir("Entrega1\\GIlbert-500", GGIL);
        
        Grafo GEO = new Grafo();
        GEO = Geografico(30, .6);
        construir("Entrega1\\Geografico-30", GEO);
        GEO = Geografico(100, .6);
        construir("Entrega1\\Geografico-100", GEO);
        GEO = Geografico(500, .6);
        construir("Entrega1\\Geografico-500", GEO);
        
        Grafo GB = new Grafo();
        GB = Barabasi(30, 100);
        construir("Entrega1\\Barabasi-30", GB);
        GB = Barabasi(100, 500);
        construir("Entrega1\\Barabasi-100", GB);
        GB = Barabasi(500, 1000);
        construir("Entrega1\\Barabasi-500", GB);
        
        
//        segunda entrega

        Grafo grafo = new Grafo();
        grafo = ErdosRenyi(30,100);
        Grafo ERBFS30 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiBFS-30", ERBFS30);
        Grafo ERDFS_I30 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiDFS_I-30", ERDFS_I30);
        Grafo ERDFS_R30 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiDFS_R-30", ERDFS_R30); 
        grafo = ErdosRenyi(100,500);
        Grafo ERBFS100 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiBFS-100", ERBFS100);
        Grafo ERDFS_I100 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiDFS_I-100", ERDFS_I100);
        Grafo ERDFS_R100 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiDFS_R-100", ERDFS_R100); 
        grafo = ErdosRenyi(500,1000);
        Grafo ERBFS500 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiBFS-500", ERBFS500);
        Grafo ERDFS_I500 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiDFS_I-500", ERDFS_I500);
        Grafo ERDFS_R500 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\Erdos y RenyiDFS_R-500", ERDFS_R500);
        
        
        
        
        
        grafo = Gilbert(30,.2);
        Grafo GBFS30 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertBFS-30", GBFS30);
        Grafo GDFS_I30 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertDFS_I-30", GDFS_I30);
        Grafo GDFS_R30 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertDFS_R-30", GDFS_R30); 
        grafo = Gilbert(100,.2);
        Grafo GBFS100 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertBFS-100", GBFS100);
        Grafo GDFS_I100 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertDFS_I-100", GDFS_I100);
        Grafo GDFS_R100 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertDFS_R-100", GDFS_R100);
        grafo = Gilbert(500,.2);
        Grafo GBFS500 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertBFS-500", GBFS500);
        Grafo GDFS_I500 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertDFS_I-500", GDFS_I500);
        Grafo GDFS_R500 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GilbertDFS_R-500", GDFS_R500);
        
        
        
        
        grafo = Geografico(30,.6);
        Grafo GEOBFS30 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoBFS-30", GEOBFS30);
        Grafo GEODFS_I30 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoDFS_I-30", GEODFS_I30);
        Grafo GEODFS_R30 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoDFS_R-30", GEODFS_R30);  
        grafo = Geografico(100,.6);
        Grafo GEOBFS100 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoBFS-100", GEOBFS100);
        Grafo GEODFS_I100 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoDFS_I-100", GEODFS_I100);
        Grafo GEODFS_R100 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoDFS_R-100", GEODFS_R100);  
        grafo = Geografico(500,.6);
        Grafo GEOBFS500 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoBFS-500", GEOBFS500);
        Grafo GEODFS_I500 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoDFS_I-500", GEODFS_I500);
        Grafo GEODFS_R500 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\GeograficoDFS_R-500", GEODFS_R500);
        
        
        
        grafo = Barabasi(30,100);
        Grafo BBFS30 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiBFS-30", BBFS30);
        Grafo BDFS_I30 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiDFS_I-30", BDFS_I30);
        Grafo BDFS_R30 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiDFS_R-30", BDFS_R30);  
        grafo = Barabasi(100,500);
        Grafo BBFS100 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiBFS-100", BBFS100);
        Grafo BDFS_I100 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiDFS_I-100", BDFS_I100);
        Grafo BDFS_R100 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiDFS_R-100", BDFS_R100);  
        grafo = Barabasi(500,100);
        Grafo BBFS500 = new Grafo(BFS(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiBFS-500", BBFS500);
        Grafo BDFS_I500 = new Grafo(DFS_I(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiDFS_I-500", BDFS_I500);
        Grafo BDFS_R500 = new Grafo(DFS_R(grafo,grafo.getNodos().get(0)));
        construir("Entrega2\\BarabasiDFS_R-500", BDFS_R500);
        
//        tercer entrega
        

        Grafo grafo1 = new Grafo();
        grafo1 = ErdosRenyi(30,100);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraErdosRenyiPocos",grafo1);
        grafo1 = ErdosRenyi(200,500);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraErdosRenyiMuchos",grafo1);
        
        
        grafo1 = Gilbert(30,.2);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraGilbertPocos",grafo1);
        grafo1 = Gilbert(200,.2);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraGilbertMuchos",grafo1);
        
        grafo1 = Geografico(30,.6);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraGeograficoPocos",grafo1);
        grafo1 = Geografico(200,.6);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraGeograficoMuchos",grafo1);
        
        grafo1 = Barabasi(30,100);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraBarabasiPocos",grafo1);
        grafo1 = Barabasi(200,500);
        grafo1.EdgeValues(8, 150);
        grafo1 = grafo1.Dijkstra(grafo1.getNodos().get(0));
        construir("Entrega3\\DijkstraBarabasiMuchos",grafo1);

    ////////////////////////////////// Cuarta entrega

        Grafo grafo2 = new Grafo();
        Grafo gPrim = new Grafo();
        Grafo gkruskalD = new Grafo();
        Grafo gkruskalI = new Grafo();
        /////////Erdos y Renyi///////////
        
        grafo2 = ErdosRenyi(30,100);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\ErdosRenyiPrimPocos",gPrim);
        grafo2 = ErdosRenyi(200, 500);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\ErdosRenyiPrimMuchos",gPrim);
        
        grafo2 = ErdosRenyi(30,100);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\ErdosRenyiKruskalDPocos",gkruskalD);
        grafo2 = ErdosRenyi(200, 500);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\ErdosRenyiKruskalDMuchos",gkruskalD);
        
        grafo2 = ErdosRenyi(30,100);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\ErdosRenyiKruskalIPocos",gkruskalI);
        grafo2 = ErdosRenyi(200, 500);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\ErdosRenyiKruskalIMuchos",gkruskalI);
//        
        
        /////////// Gilbert

        grafo2 = Gilbert(30,.2);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\GilbertPrimPocos",gPrim);
        grafo2 = Gilbert(200, .2);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\GilbertPrimMuchos",gPrim);
//
        grafo2 = Gilbert(30,.2);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\GilbertKruskalDPocos",gkruskalD);
        grafo2 = Gilbert(200, .2);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\GilbertKruskalDMuchos",gkruskalD);
        
        grafo2 = Gilbert(30,.2);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\GilbertKruskalIPocos",gkruskalI);
        grafo2 = Gilbert(200, .2);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\GilbertKruskalIMuchos",gkruskalI);
//
//
//    ////////Geografico
//
        grafo2 = Geografico(30,.6);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\GeograficoPrimPocos",gPrim);
        grafo2 = Geografico(200, .6);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\GeograficoPrimMuchos",gPrim);
////
        grafo2 = Geografico(30,.6);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\GeograficoKruskalDPocos",gkruskalD);
        grafo2 = Geografico(200, .6);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\GeograficoKruskalDMuchos",gkruskalD);
        
        grafo2 = Geografico(30,.6);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\GeograficoKruskalIPocos",gkruskalI);
        grafo2 = Geografico(200, .6);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\GeograficoKruskalIMuchos",gkruskalI);
     
      ///////Barabasi
      
        grafo2 = Barabasi(30,100);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\BarabasiPrimPocos",gPrim);
        grafo2 = Barabasi(200, 500);
        grafo2.EdgeValues(1, 1000);
        gPrim = grafo2.Prim();
        construir("Entrega4\\BarabasiPrimMuchos",gPrim);
        
        grafo2 = Barabasi(30,100);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\BarabasiKruskalDPocos",gkruskalD);
        grafo2 = Barabasi(200, 500);
        grafo2.EdgeValues(1, 1000);
        gkruskalD = grafo2.Kruskal_D();
        construir("Entrega4\\BarabasiKruskalDMuchos",gkruskalD);
        
        grafo2 = Barabasi(30,100);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\BarabasiKruskalIPocos",gkruskalI);
        grafo2 = Barabasi(200, 500);
        grafo2.EdgeValues(1, 1000);
        gkruskalI = grafo2.Kruskal_I();
        construir("Entrega4\\BarabasiKruskalIMuchos",gkruskalI);
     
       

    }
    
}
