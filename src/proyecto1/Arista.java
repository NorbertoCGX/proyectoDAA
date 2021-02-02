/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;

/**
 *
 * @author Norber
 */
public class Arista implements Comparable <Arista>{
    
    private int A1, A2;
    private int ID;
    private double wi;
    private boolean fal;
    
//MÉTODOS
    
    public Arista (){
    }
    
    public Arista (int An1, int An2){
        this.A1=An1;
        this.A2=An2;
        this.wi=0;
        this.fal=false;
    }
    
    public Arista (int An1, int An2, double pb){
        this.A1=An1;
        this.A2=An2;
        this.wi=pb;
        this.fal=false;
    }
    
    public Arista (Arista ax){
        this.A1=ax.getAn1();
        this.A2=ax.getAn2();
        this.wi=ax.getP();
        this.fal=ax.getfal();
    }
    
    public int getAn1 (){
        return this.A1;
    }
    public int getAn2 (){
        return this.A2;
    }
    public int getID(){
        return this.ID;
    }
    public boolean getfal(){
        return this.fal;
    }
    public void setAn1 (int idNodo){
        this.A1 = idNodo;
    }
    public void setAn2 (int idNodo){
        this.A2 = idNodo;
    }
    public void setID (int a){
        this.ID = a;
    }
    public void setfal (boolean a){
        this.fal = a;
    }
    public void setP (double p){
        this.wi=p;
    }
    public double getP (){
        return this.wi;
    }
    
    public void Cop (Arista ay){
        this.A1=ay.getAn1();
        this.A2=ay.getAn2();
        this.wi=ay.getP();
    }
    
@Override
public int compareTo(Arista A1){
    if (this.wi > A1.getP()) return 1;
    else if (this.wi < A1.getP()) return -1;
    else return 0;
}
}
