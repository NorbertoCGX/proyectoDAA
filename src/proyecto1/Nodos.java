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
public class Nodos {
    
  private int Grado;
    private double s,t;
    private int ID;
    private int conectado;
    private boolean fal;
    private double wi;
  
//MÉTODOS  
    
    public Nodos (){
        this.Grado = 0;
        this.s = 0;
        this.t = 0;
        this.conectado = 0;
        this.fal = false;
        this.wi = 0;
    }
    
    public Nodos (Nodos nx){
        this.Grado = nx.getGrado();
        this.ID = nx.get();
        this.s = nx.getX();
        this.t = nx.getY();
        this.conectado = nx.getConectado();
        this.fal = nx.getfal();
        this.wi = nx.getwin();
    }   
    
    public Nodos (int id){    
        this.ID = id;
        this.Grado = 0;
        this.s = 0;
        this.t = 0;
        this.conectado = 0;
        this.fal = false;
        this.wi = 0;
    } 
    
    public Nodos (int id, int cnd, int grad, double x1, double y1, boolean g, double p){    
        this.ID = id;
        this.conectado = cnd;
        this.Grado = grad;
        this.s = x1;
        this.t = y1;
        this.fal = g;
        this.wi = p;
    }
    
    public Nodos (int id, double x1, double y1){    
        this.ID = id;
        this.Grado = 0;
        this.s = x1;
        this.t = y1;
        this.fal = false;
        this.conectado = 0;
        this.wi = 0;
    }
    
    public void Cop (Nodos ny){
        this.Grado = ny.getGrado();
        this.ID = ny.get();
        this.s = ny.getX();
        this.t = ny.getY();
        this.conectado = ny.getConectado();
        this.fal = ny.getfal();
        this.wi = ny.getwin();
    }
    
    public void set (int id){
        this.ID = id;
    }
    public int get (){
        return this.ID;
    }    
    public void setGrado (int i){
        this.Grado = i;
    }    
    public int getGrado (){
        return this.Grado;
    }    
    public void IncGrado (int i){
        this.Grado=this.Grado+i;
    } 
    public void DecGrado (int i){
        this.Grado=this.Grado-i;
    }
    public void setX (double x1){
        this.s=x1;
    }
    public void setY (double x1){
        this.t=x1;
    }
    public double getX (){
        return this.s;
    }
    public double getY (){
        return this.t;
    }
    
    public void conectar(){
        this.conectado=1;
    }
    public int getConectado(){
        return this.conectado;
    }
    
    public void setfal (boolean a){
        this.fal = a;
    }
    public boolean getfal (){
        return this.fal;
    }
    
    public void setwi (double p){
        this.wi = p;
    }
    public double getwin (){
        return this.wi; 
    }
    
}
