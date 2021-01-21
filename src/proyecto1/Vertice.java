/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Norbe
 */
public class Vertice {
    
    private String nombre;
    private Integer nAristas;
    private Integer indice;
    private double distancia;
    private double x;
    private double y;
    
    public Vertice(String nombre)
    {
        this.nombre = nombre;
        this.nAristas = 0;
    }
    
    public Vertice(int nombre)
    {
        this.indice = nombre;
        this.nombre = 'n' + String.valueOf(nombre);
        this.nAristas = 0;
    }
    
    public Vertice(int nombre, double x, double y)
    {
        this.indice = nombre;
        this.nombre = "n" + String.valueOf(nombre);
    }
    
    public String getNombre()
    {
        return nombre;
    }
    public Integer getnAristas()
    {
        return nAristas;
    }

    public Integer getIndice() 
    {
        return indice;
    }

    public double getDistancia() 
    {
        return distancia;
    }

    public void setDistancia(double d)
    {
        this.distancia = d; 
    }
    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }
    
}
