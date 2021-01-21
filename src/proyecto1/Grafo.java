/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import java.util.*;
import java.io.FileNotFoundException;

/**
 *
 * @author Norbe
 */
public class Grafo {
    
    private Vertice [] nodos;
    
    private HashMap<Vertice, HashSet<Vertice>> grafo;
    private HashMap<Vertice, HashSet<Arista>> incidencia; 
    private final int numeroVertices; 
    private int numeroAristas;  
    private static Formatter output; 
    private Boolean weighted;
    
    public void escribirArchivo(String nombre)
  {
    try{
      output = new Formatter(nombre+".gv");
    }
    catch (SecurityException securityException)
    {
      System.err.println("No hay permiso de escritura.");
      System.exit(1);
    }
    catch (FileNotFoundException fileNotFoundException) {
      System.err.println("Error al abrir el archivo.");
      System.exit(1);
    }
    try{
      output.format("%s",this);
    }
    catch (FormatterClosedException formatterClosedException) {
      System.err.println("Error al escribir al archivo");
    }
    if (output != null)
    output.close();
  }
    
    public Grafo(int numVertices, String modelo) 
  {
      this.grafo = new HashMap<Vertice, HashSet<Vertice>>();
      this.incidencia = new HashMap<Vertice, HashSet<Arista>>();
      this.numeroVertices = numVertices;
      this.nodos = new Vertice[numVertices];
      Random coorX = new Random();
      Random coorY = new Random();
      if (modelo == "geo-uniforme") {
        for (int i = 0; i < numVertices; i++) {
          Vertice n = new Vertice(i, coorX.nextDouble(), coorY.nextDouble());
          this.nodos[i] = n;
          this.grafo.put(n, new HashSet<Vertice>());
          this.incidencia.put(n, new HashSet<Arista>());
        }
      }
      this.weighted = false;
    }
    
    public Grafo(int numVertices) 
  {
    this.grafo = new HashMap<Vertice, HashSet<Vertice>>();
    this.incidencia = new HashMap<Vertice, HashSet<Arista>>();
    this.numeroVertices = numVertices;
    this.nodos = new Vertice[numVertices];
    for (int i = 0; i < numVertices; i++) {
      Vertice n = new Vertice(i);
      this.nodos[i] = n;
      this.grafo.put(n, new HashSet<Vertice>());
      this.incidencia.put(n, new HashSet<Arista>());
    }
    this.weighted = false;
  }
    
    public int gradoVertice(int i) 
  {
    Vertice n1 = this.getNodo(i);
    return this.grafo.get(n1).size();
  }
    
   public void conectarVertices(int i, int j) 
  {
    
     Vertice n1 = this.getNodo(i);
     Vertice n2 = this.getNodo(j);
     
     HashSet<Vertice> aristas1 = this.getEdges(i);
     HashSet<Vertice> aristas2 = this.getEdges(j);

     
     aristas1.add(n2);
     aristas2.add(n1);  
     this.numeroAristas +=1; 
  }
    
   private Boolean existeConexion(int i, int j) 
  {
    
     Vertice n1 = this.getNodo(i);
     Vertice n2 = this.getNodo(j);
    
    HashSet<Vertice> aristas1 = this.getEdges(i);
    HashSet<Vertice> aristas2 = this.getEdges(j);
    
     if (aristas1.contains(n2) || aristas2.contains(n1)) {
       return true;
     }
     else{
       return false;
     }
  }
  
   private double distanciaVertices(Vertice n1, Vertice n2) 
  {
    return Math.sqrt(Math.pow((n1.getX() - n2.getX()), 2)
    + Math.pow((n1.getY() - n2.getY()), 2));
  }
   
  public int getNumNodes()
  {
      return numeroVertices;
  }

  public int getNumEdges()
  {
      return numeroAristas;
  }

  public Vertice getNodo(int i)
  {
      return this.nodos[i];
  }

  public Boolean getWeightedFlag()
  {
      return this.weighted;
  }
  public HashSet<Vertice> getEdges(int i)
  {
    Vertice n = this.getNodo(i);
    return this.grafo.get(n);
  }
  public HashSet<Arista> getWeightedEdges(int i) 
  {
    Vertice n = this.getNodo(i);
    return this.incidencia.get(n);
  }
  
  public void setWeighted()
  {
      this.weighted = true;
  }
  
  public void setIncidencia(int i, HashSet<Arista> aristasPeso)
  {
    this.incidencia.put(this.getNodo(i), aristasPeso);
  }
  
  public void setAristaPeso(int i, int j, double peso) 
  {
    if (!this.existeConexion(i, j)) this.conectarVertices(i, j);
    Arista aristaNuevaij = new Arista(i, j, peso);
    Arista aristaNuevaji = new Arista(j, i, peso);
    HashSet<Arista> aristasNodoi = this.getWeightedEdges(i);
    HashSet<Arista> aristasNodoj = this.getWeightedEdges(j);
    aristasNodoi.add(aristaNuevaij);
    aristasNodoj.add(aristaNuevaji);
    this.setIncidencia(i, aristasNodoi);
    this.setIncidencia(j, aristasNodoj);
    if (!this.getWeightedFlag()) this.setWeighted();
  }
  
  public String toString() 
  {
    String salida;
    if (this.getWeightedFlag()) { 
      salida ="graph {\n";        
      for (int i = 0; i < this.getNumNodes(); i++) {
        salida += this.getNodo(i).getNombre() + " [label=\""
        + this.getNodo(i).getNombre() + " ("+ this.getNodo(i).getDistancia()
        + ")\"];\n";
      }
      for (int i = 0; i < this.getNumNodes(); i++) {
        HashSet<Arista> aristas = this.getWeightedEdges(i);
        for (Arista e : aristas) {
        salida += e.getNodo1() + " -- " + e.getNodo2()
        + " [weight=" + e.getPeso()+"" + " label="+e.getPeso()+""
        + "];\n";
        }
       }
      salida += "}\n";
    }
    else { 
      salida ="graph {\n";
      for (int i = 0; i < this.getNumNodes(); i++) {
        salida += this.getNodo(i).getNombre() + ";\n";
      }
      for (int i = 0; i < this.getNumNodes(); i++) {
        HashSet<Vertice> aristas = this.getEdges(i);
        for (Vertice n : aristas) {
        salida += this.getNodo(i).getNombre() + " -- " + n.getNombre() + ";\n";
        }
       }
      salida += "}\n";
    }
    return salida;
  }
  
  public void modeloErdosyRenyi(int numAristas) 
{
    Random randomNum1 = new Random();
    Random randomNum2 = new Random();
    
    while (this.getNumEdges() < numAristas) 
    {
      int num1 = randomNum1.nextInt(this.getNumNodes());
      int num2 = randomNum2.nextInt(this.getNumNodes());
      if (num1 != num2) {
        if (!existeConexion(num1, num2)) {
          conectarVertices(num1, num2);
        }
      }
    }
}

public void modeloGilbert(double probabilidad)
{
    Random randomNum = new Random();
    
    for(int i = 0; i < this.getNumNodes(); i++) {
      for(int j = 0; j <this.getNumNodes(); j++) {
        if ((i != j) && (randomNum.nextDouble() <= probabilidad)) {
          if (!existeConexion(i, j)) {
            conectarVertices(i, j);
          }
        }
      }
    }
}

  public void modeloGeografico(double r)
  {
    
    for(int i = 0; i < this.getNumNodes(); i++) {
      for(int j = i + 1; j < this.getNumNodes(); j++) {
        double distancia = distanciaVertices(this.getNodo(i), this.getNodo(j));
        if (distancia <= r) {
            conectarVertices(i, j);
        }
      }
    }
  }
  
  public void modeloBarabasiAlbert(int d) 
  {
    Random volado = new Random();
  
    for(int i = 0; i < d; i++){
      for(int j = 0; j < i; j++) {
        if (!existeConexion(i, j)) {
          conectarVertices(i, j);
        }
      }
    }
  
    for(int i = d; i < this.getNumNodes();) 
    {
      for(int j = 0; j < i; j++) {
        double probabilidad =
        (double)gradoVertice(j)/(double)this.getNumEdges();
        if (volado.nextDouble() <= probabilidad) {
          if (!existeConexion(i, j) && (gradoVertice(i) < d)) {
            conectarVertices(i, j);
          }
        }
      }
      if (gradoVertice(i) >= d) i++;
    }
  }
  
  public Grafo BFS(int s) 
  {
    Grafo arbol = new Grafo(this.getNumNodes());  
    Boolean[] discovered = new Boolean[this.getNumNodes()]; 
    PriorityQueue<Integer> L= new PriorityQueue<Integer>();
    discovered[s] = true; 
    for (int i = 0; i < this.getNumNodes(); i++)
    {
        if (i != s) {   
	    discovered[i] = false;
	}
    }
    
    L.add(s);  
    while (L.peek() != null)
    {  
	int u = L.poll();  
	HashSet<Vertice> aristas = this.getEdges(u);  
	for (Vertice n : aristas) {
	    if(!discovered[n.getIndice()])
            {      
	        arbol.conectarVertices(u, n.getIndice());
	        discovered[n.getIndice()] = true;
	        L.add(n.getIndice());
	    }
	}
    }
    return arbol;
  }
  
  public Grafo DFS_I(int s)
  {
    Grafo arbol = new Grafo(this.getNumNodes());  
    Boolean[] explored = new Boolean[this.getNumNodes()];  
    Stack<Integer> S = new Stack<Integer>(); 
    Integer[] parent = new Integer[this.getNumNodes()]; 
    for (int i = 0; i < this.getNumNodes(); i++)
    {
	explored[i] = false;  
    }
    S.push(s);  
    while(!S.isEmpty())
    {
	int u = S.pop();  
	if(!explored[u])
        {
	    explored[u] = true;  
	    if(u != s)
            {
	        arbol.conectarVertices(u, parent[u]); 
	    }
	    HashSet<Vertice> aristas = this.getEdges(u);  
	    for (Vertice n : aristas)
            {
	        S.push(n.getIndice());  
	        parent[n.getIndice()] = u;  
	    }
	}
    }
    return arbol;
  }
 
  public Grafo DFS_R(int s) 
  {
    Grafo arbol = new Grafo(this.getNumNodes()); 
    Boolean[] discovered = new Boolean[this.getNumNodes()]; 
    for (int i = 0; i < this.getNumNodes(); i++) 
    {
        discovered[i] = false;  
    }
    recursivoDFS(s, discovered, arbol);
    return arbol;
  }
  
  private void recursivoDFS(int u, Boolean[] discovered, Grafo arbol) 
  {
    discovered[u] = true; 
    HashSet<Vertice> aristas = this.getEdges(u);
    for (Vertice n : aristas)
    {
        if (!discovered[n.getIndice()])
        {     
            arbol.conectarVertices(u, n.getIndice());
	    recursivoDFS(n.getIndice(), discovered, arbol);
	}
    }
  }
  public Grafo Dijkstra(int s) 
  {
    Grafo arbol = new Grafo(this.getNumNodes()); 
    double inf = Double.POSITIVE_INFINITY;  
    Integer[] padres = new Integer[arbol.getNumNodes()];
		    
    for (int i = 0; i < arbol.getNumNodes(); i++) 
    {
        this.getNodo(i).setDistancia(inf);
        padres[i] = null;
    }
		  
    this.getNodo(s).setDistancia(0.0);
    padres[s] = s;
		   
    PriorityQueue<Vertice> distPQ = new PriorityQueue<>(vertexDistanceComp);
    for (int i = 0; i < this.getNumNodes(); i++)
    {
        distPQ.add(this.getNodo(i));
    }
		    
    while (distPQ.peek() != null) 
    {  
        Vertice u = distPQ.poll();  
        HashSet<Arista> aristas = this.getWeightedEdges(u.getIndice());
        for (Arista e : aristas) 
        {
		     
            if(this.getNodo(e.getIntN2()).getDistancia() > this.getNodo(u.getIndice()).getDistancia() + e.getPeso())
            {
                this.getNodo(e.getIntN2()).setDistancia(this.getNodo(u.getIndice()).getDistancia() + e.getPeso());
                padres[e.getIntN2()] = u.getIndice();
            }
        }
    }
		    
    for (int i = 0; i < arbol.getNumNodes(); i++) 
    {
        arbol.setAristaPeso(i, padres[i], 1);
        arbol.getNodo(i).setDistancia(this.getNodo(i).getDistancia());
    }
    return arbol;
  }
  
   Comparator<Vertice> vertexDistanceComp = new Comparator<Vertice>()
   {
       @Override
       public int compare(Vertice n1, Vertice n2)
       {
            return Double.compare(n1.getDistancia(), n2.getDistancia());
       }
    };
   
   public Grafo ValoresAristas(double min, double max)
   {
        Grafo grafoPesado = new Grafo(this.getNumNodes()); 
        Random rand = new Random();
        double peso;
        for (int i = 0; i < this.getNumNodes(); i++)
        {  
            for (int j = i; j < this.getNumNodes(); j++)
            { 
		if(this.existeConexion(i, j))
                { 
                    peso = rand.nextFloat()*(max - min) + min;
                    grafoPesado.setAristaPeso(i, j, peso);
		}
            }
        }
        return grafoPesado;
    }  
}
