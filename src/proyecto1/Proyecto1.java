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
        
       

        ErdosYRenyi ER1 = new ErdosYRenyi();
        ER1.iniciar(30);
        ErdosYRenyi ER2 = new ErdosYRenyi();
        ER2.iniciar(100);
        ErdosYRenyi ER3 = new ErdosYRenyi();
        ER3.iniciar(500);
        
        Gilbert g1 = new Gilbert();
        g1.iniciar(30);
        Gilbert g2 = new Gilbert();
        g2.iniciar(100);
        Gilbert g3 = new Gilbert();
        g3.iniciar(500);

          GeoSimple gs1 = new GeoSimple();
          gs1.iniciar(30);
          GeoSimple gs2 = new GeoSimple();
          gs2.iniciar(100);
          GeoSimple gs3 = new GeoSimple();
          gs3.iniciar(500);

          BA b1 = new BA();
          b1.iniciar(30);
          BA b2 = new BA();
          b2.iniciar(100);
          BA b3 = new BA();
          b3.iniciar(500);
    }
    
}
