/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto1;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Norber
 */
public class Grafo {
    
    private HashMap<Integer, Nodos> Nodos;
    private HashMap<Integer, Arista> Aristas;

    public Grafo(HashMap<Integer, Nodos> N, HashMap<Integer, Arista> A) {
        this.Aristas = new HashMap();
        for (int i = 0; i < A.size(); i++) {
            this.Aristas.put(i, new Arista(A.get(i)));
        }
        this.Nodos = new HashMap();
        for (int i = 0; i < N.size(); i++) {
            this.Nodos.put(i, new Nodos(N.get(i)));
        }
    }

    public Grafo() {
        this.Aristas = new HashMap();
        this.Nodos = new HashMap();
    }

    public Grafo(Grafo k) {
        this.Aristas = new HashMap();
        for (int i = 0; i < k.getAristas().size(); i++) {
            this.Aristas.put(i, new Arista(k.getAristas().get(i)));
        }
        this.Nodos = new HashMap();
        for (int i = 0; i < k.getNodos().size(); i++) {
            this.Nodos.put(i, new Nodos(k.getNodos().get(i)));
        }
    }

    public void setNodos(HashMap<Integer, Nodos> w) {
        this.Nodos = w;
    }

    public void setAristas(HashMap<Integer, Arista> w) {
        this.Aristas = w;
    }

    public HashMap<Integer, Arista> getAristas() {
        return this.Aristas;
    }

    public HashMap<Integer, Nodos> getNodos() {
        return this.Nodos;
    }

    public void setG(HashMap<Integer, Nodos> a, HashMap<Integer, Arista> b) {
        this.Nodos = (HashMap) a;
        this.Aristas = (HashMap) b;
    }
    
    public static Grafo ErdosRenyi(int NumNodos, int NumAristas) {
        HashMap<Integer, Nodos> NodoS = new HashMap();
        HashMap<Integer, Arista> AristaS = new HashMap();

        int AristasHechas;

        for (int i = 0; i < NumNodos; i++) {
            NodoS.put(i, new Nodos(i));
        }

        int x1 = (int) (Math.random() * NumNodos), x2 = (int) (Math.random() * NumNodos);
        AristaS.put(0, new Arista(NodoS.get(x1).get(), NodoS.get(x2).get(), Math.random()));

        while (x1 == x2 ) {
            x1 = (int) (Math.random() * NumNodos);
            x2 = (int) (Math.random() * NumNodos);
            AristaS.put(0, new Arista(NodoS.get(x1).get(), NodoS.get(x2).get(), Math.random()));
        }

        NodoS.get(x1).conectar();
        NodoS.get(x2).conectar();
        if (x1 != x2) {
            NodoS.get(x1).IncGrado(1);
        }
        NodoS.get(x2).IncGrado(1);

        AristasHechas = 1;
        while (AristasHechas < NumAristas) {
            x1 = (int) (Math.random() * NumNodos);
            x2 = (int) (Math.random() * NumNodos);

            if (x1 != x2 ) {
                int c1 = 1, cont = 0;
                while (c1 == 1 && cont < AristasHechas) {
                    int a = AristaS.get(cont).getAn1(), b = AristaS.get(cont).getAn2();
                    if ((x1 == a && x2 == b) || (x1 == b && x2 == a)) {
                        c1 = 0;
                    }
                    cont++;
                }
                if (c1 == 1) {
                    AristaS.put(AristasHechas, new Arista(NodoS.get(x1).get(), NodoS.get(x2).get(), Math.random()));
                    NodoS.get(x1).conectar();
                    NodoS.get(x2).conectar();
                    if (x1 != x2) {
                        NodoS.get(x1).IncGrado(1);
                    }
                    NodoS.get(x2).IncGrado(1);
                    AristasHechas++;
                }
            }
        }

       
        Grafo G = new Grafo(NodoS, AristaS);
        return G;

    }
    
    public static Grafo Geografico(int NumNodos, double distancia) {
        HashMap<Integer, Nodos> NodoS = new HashMap();
        HashMap<Integer, Arista> AristaS = new HashMap();
        int NumAristas = 0;

        for (int i = 0; i < NumNodos; i++) {
            NodoS.put(i, new Nodos(i, Math.random(), Math.random()));
        }

        for (int i = 0; i < NumNodos; i++) {
            for (int j = i; j < NumNodos; j++) {
                if (j != i) {
                    double dis = Math.sqrt(Math.pow(NodoS.get(j).getX() - NodoS.get(i).getX(), 2)
                            + Math.pow(NodoS.get(j).getY() - NodoS.get(i).getY(), 2));
                    if (dis <= distancia) {
                        AristaS.put(NumAristas, new Arista(NodoS.get(i).get(), NodoS.get(j).get()));
                        NodoS.get(i).IncGrado(1);
                        NodoS.get(i).conectar();
                        if (j != i) {
                            NodoS.get(j).IncGrado(1);
                            NodoS.get(j).conectar();
                        }
                        NumAristas++;
                    }
                }
            }
        }
        Grafo G = new Grafo(NodoS, AristaS);
        return G;
    }

    public static Grafo Gilbert(int NumNodos, double probabilidad) {
        HashMap<Integer, Nodos> NodoS = new HashMap();
        HashMap<Integer, Arista> AristaS = new HashMap();

        int NumAristas = 0;

        for (int i = 0; i < NumNodos; i++) {
            NodoS.put(i, new Nodos(i));
        }

        for (int i = 0; i < NumNodos; i++) {
            for (int j = i; j < NumNodos; j++) {
                if (j != i ) {
                    if (Math.random() <= probabilidad) {
                        AristaS.put(NumAristas, new Arista(NodoS.get(i).get(), NodoS.get(j).get()));
                        NodoS.get(i).conectar();
                        NodoS.get(j).conectar();
                        if (i != j) {
                            NodoS.get(i).IncGrado(1);
                        }
                        NodoS.get(j).IncGrado(1);
                        NumAristas++;
                    }
                }
            }
        }
        Grafo G = new Grafo(NodoS, AristaS);
        return G;
    }

    public static Grafo Barabasi(int NumNodos, double d) {
        HashMap<Integer, Nodos> NodoS = new HashMap();
        HashMap<Integer, Arista> AristaS = new HashMap();

        int NumAristas = 0;

        for (int i = 0; i < NumNodos; i++) {
            NodoS.put(i, new Nodos(i));
        }

        for (int i = 0; i < NumNodos; i++) {
            int j = 0;
            while (j <= i && NodoS.get(i).getGrado() <= d) {
                if (j != i ) {
                    if (Math.random() <= 1 - NodoS.get(j).getGrado() / d) {
                        AristaS.put(NumAristas, new Arista(NodoS.get(i).get(), NodoS.get(j).get()));
                        NodoS.get(i).IncGrado(1);
                        NodoS.get(i).conectar();
                        if (j != i) {
                            NodoS.get(j).IncGrado(1);
                            NodoS.get(j).conectar();
                        }
                        NumAristas++;
                    }
                }
                j++;
            }
        }
        Grafo G = new Grafo(NodoS, AristaS);
        return G;
    }
    public static void construir(String nombre, Grafo g) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(nombre + ".gv");
            pw = new PrintWriter(fichero);
            pw.println("graph {"); 
            for (int i = 0; i < g.getNodos().size(); i++) {
                pw.println(g.getNodos().get(i).get() + "  " + "[Label = \"" + g.getNodos().get(i).get() + " (" + String.format("%.2f", g.getNodos().get(i).getwin()) + ")\"]");
            }
            pw.println();
            for (int i = 0; i < g.getAristas().size(); i++) {
                pw.println(g.getAristas().get(i).getAn1() + "--" + g.getAristas().get(i).getAn2() + "  " + "[Label = \"" + String.format("%.2f", g.getAristas().get(i).getP()) + "\"]");
            }
            pw.println("}");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public static Grafo BFS(Grafo GN, Nodos node) {
        Grafo Gr = new Grafo(GN.getNodos(), GN.getAristas());
        HashMap<Integer, HashMap> Col = new HashMap(); 
        HashMap<Integer, Nodos> Col_1 = new HashMap();   
        HashMap<Integer, Nodos> Col_2 = new HashMap();   
        HashMap<Integer, Nodos> Col_3 = new HashMap();       
        HashMap<Integer, Arista> Col_A = new HashMap();
        int nCol = 0, nC = 0,q = 0;
        Gr.getNodos().get(node.get()).setfal(true);
        Col_1.put(0, Gr.getNodos().get(node.get()));
        Col.put(nCol, (HashMap) Col_1.clone());
        Col_3.put(q, Gr.getNodos().get(node.get()));
        while (Col_1.isEmpty() == false) {
            Col_2.clear();
            nC = 0;
            for (int i = 0; i < Col_1.size(); i++) {
                for (int j = 0; j < Gr.getAristas().size(); j++) {
                    if (Col_1.get(i).get() == Gr.getAristas().get(j).getAn1() && Gr.getNodos().get(Gr.getAristas().get(j).getAn2()).getfal() == false) {
                        Gr.getNodos().get(Gr.getAristas().get(j).getAn2()).setfal(true);
                        Col_2.put(nC, Gr.getNodos().get(Gr.getAristas().get(j).getAn2()));
                        nC++;
                        Col_A.put(q, Gr.getAristas().get(j));
                        q++;
                        Col_3.put(q, Gr.getNodos().get(Gr.getAristas().get(j).getAn2()));
                    }
                    if (Col_1.get(i).get() == Gr.getAristas().get(j).getAn2() && Gr.getNodos().get(Gr.getAristas().get(j).getAn1()).getfal() == false) {
                        Gr.getNodos().get(Gr.getAristas().get(j).getAn1()).setfal(true);
                        Col_2.put(nC, Gr.getNodos().get(Gr.getAristas().get(j).getAn1()));
                        nC++;
                        Col_A.put(q, Gr.getAristas().get(j));
                        q++;
                        Col_3.put(q, Gr.getNodos().get(Gr.getAristas().get(j).getAn1()));
                    }
                }
            }
            nCol++;
            Col_1 = (HashMap) Col_2.clone();
            Col.put(nCol, (HashMap) Col_2.clone());
        }
        Grafo ArBFS = new Grafo();
        ArBFS.setG(Col_3, Col_A);
        return ArBFS;
    }
    
    public static Grafo DFS_R(Grafo GN, Nodos node) {
        Grafo ArDFS_R = new Grafo();
        Grafo ArDFSR_2;
        boolean Ar[][] = new boolean[GN.getNodos().size()][GN.getNodos().size()];
        for (int i = 0; i < GN.getAristas().size(); i++) {
            Ar[GN.getAristas().get(i).getAn1()][GN.getAristas().get(i).getAn2()] = true;
            Ar[GN.getAristas().get(i).getAn2()][GN.getAristas().get(i).getAn1()] = true;
        }
        GN.getNodos().get(node.get()).setfal(true);
        ArDFS_R.getNodos().put(0, new Nodos(GN.getNodos().get(node.get())));
        for (int i = 0; i < GN.getNodos().size(); i++) {
            if (Ar[node.get()][i] == true && GN.getNodos().get(i).getfal() == false) {
                ArDFSR_2 = DFS_R(GN, GN.getNodos().get(i));
                int n4 = ArDFS_R.getNodos().size();
                for (int j = 0; j < ArDFSR_2.getNodos().size(); j++) {
                    ArDFS_R.getNodos().put(n4 + j, ArDFSR_2.getNodos().get(j));
                }
                ArDFS_R.getAristas().put(ArDFS_R.getAristas().size(), new Arista(node.get(), i));
                n4 = ArDFS_R.getAristas().size();
                if (ArDFSR_2.getAristas().isEmpty() != true) {
                    for (int j = 0; j < ArDFSR_2.getAristas().size(); j++) {
                        ArDFS_R.getAristas().put(n4 + j, ArDFSR_2.getAristas().get(j));
                    }
                }
            }
        }
        return ArDFS_R;
    }
    
    public static Grafo DFS_I(Grafo GN, Nodos node) {
        Grafo Gr2 = new Grafo(GN.getNodos(), GN.getAristas());
        Grafo ArDFS_I = new Grafo();
        int p=0, n2 = 0;
        boolean n3;
        boolean Ar[][] = new boolean[Gr2.getNodos().size()][Gr2.getNodos().size()];
        for (int i = 0; i < Gr2.getAristas().size(); i++) {
            if (Gr2.getAristas().get(i).getfal() == false) {
                Ar[Gr2.getAristas().get(i).getAn1()][Gr2.getAristas().get(i).getAn2()]=true;
                Ar[Gr2.getAristas().get(i).getAn2()][Gr2.getAristas().get(i).getAn1()]=true;
            }
        }
        Stack<Integer> heap = new Stack<>();
        heap.push(Gr2.getNodos().get(node.get()).get());
        Gr2.getNodos().get(node.get()).setfal(true);
        ArDFS_I.getNodos().put(n2, new Nodos(Gr2.getNodos().get(node.get())));
        while (heap.isEmpty() == false) {
            p = heap.peek();
            n3 = false;
            for (int j = 0; j < Gr2.getNodos().size(); j++) {
                if (Ar[p][j] == true && Gr2.getNodos().get(j).getfal() == false) {
                    Gr2.getNodos().get(j).setfal(true);
                    ArDFS_I.getAristas().put(n2, new Arista(p, j));
                    n2++;
                    ArDFS_I.getNodos().put(n2, new Nodos(Gr2.getNodos().get(j)));
                    heap.push(j);
                    n3 = true;
                    j = Gr2.getNodos().size();
                }
                if (j == Gr2.getNodos().size() - 1 && n3 == false) {
                    heap.pop();
                }
            }
        }
        return ArDFS_I;
    }
     public Grafo EdgeValues(double minimo, double maximo) {
        int AristasN = this.Aristas.size();
        for (int i = 0; i < AristasN; i++) {
            this.Aristas.get(i).setP(Math.random() * (maximo - minimo) + minimo);
        }
        Grafo G = new Grafo(this.Nodos, this.Aristas);
        return G;
    }
    
    public Grafo Dijkstra(Nodos raiz) {
        for (int k = 0; k < this.Nodos.size(); k++) {
            this.Nodos.get(k).setwi(Double.POSITIVE_INFINITY); 
        }
        double MatrixA[][] = new double[this.Nodos.size()][this.Nodos.size()];

        //Llenar la matriz de adyacencia con infinitos:
        for (int i = 0; i < this.Nodos.size(); i++) {
            for (int j = 0; j < this.Nodos.size(); j++) {
               MatrixA[i][j] = Double.POSITIVE_INFINITY;
            }
        }
        for (int k = 0; k < this.Aristas.size(); k++) {
            MatrixA[this.Aristas.get(k).getAn1()][this.Aristas.get(k).getAn2()] = this.Aristas.get(k).getP();
            MatrixA[this.Aristas.get(k).getAn2()][this.Aristas.get(k).getAn1()] = this.Aristas.get(k).getP();
        }
        ArrayList<Integer> NodosVisitados = new ArrayList<Integer>();
        HashMap<Integer, Arista> AZ = new HashMap(); 
        int numA = 0;
        NodosVisitados.add(this.Nodos.get(raiz.get()).get());
        this.Nodos.get(raiz.get()).setfal(true);
        this.Nodos.get(raiz.get()).setwi(0); 
        double aux = 0; 
        int a = 0, b = 0;
        boolean parar = true;

        while (aux != Double.POSITIVE_INFINITY) {
            aux = Double.POSITIVE_INFINITY;
            for (int i = 0; i < NodosVisitados.size(); i++) {
                for (int j = 0; j < this.Nodos.size(); j++) {
                    if (this.Nodos.get(j).getfal() != true && MatrixA[NodosVisitados.get(i)][j] != Double.POSITIVE_INFINITY) {
                        if ((this.Nodos.get(NodosVisitados.get(i)).getwin() + MatrixA[NodosVisitados.get(i)][j]) < aux) {
                            this.Nodos.get(j).setwi(this.Nodos.get(NodosVisitados.get(i)).getwin() + MatrixA[NodosVisitados.get(i)][j]);
                            aux = this.Nodos.get(j).getwin();
                            a = NodosVisitados.get(i);
                            b = j;
                        }
                    }
                }
            }
            if (aux != Double.POSITIVE_INFINITY) {
                this.Nodos.get(b).setfal(true);
                NodosVisitados.add(b);
                System.out.println("          " + aux + "   " + a +"-->"+ b);
                AZ.put(numA, new Arista(a, b, MatrixA[a][b]));
                numA++;
                }

        }

        HashMap<Integer, Nodos> NZ = new HashMap();
        for (int i = 0; i < NodosVisitados.size(); i++) {
            NZ.put(i, new Nodos(this.Nodos.get(NodosVisitados.get(i))));
        }
        Grafo G1 = new Grafo(NZ, AZ);
        return G1;
        

    }
    
    public Grafo Prim() {
        Grafo G = new Grafo(this.Nodos, this.Aristas);
        Arista MatrixA[][] = new Arista[G.getNodos().size()][G.getNodos().size()]; 
        for (int i = 0; i < G.getAristas().size(); i++) {
            MatrixA[G.getAristas().get(i).getAn1()][G.getAristas().get(i).getAn2()] = G.getAristas().get(i);
            MatrixA[G.getAristas().get(i).getAn2()][G.getAristas().get(i).getAn1()] = G.getAristas().get(i);
        }
        ArrayList<Integer> NodosVisitados = new ArrayList<Integer>();  
        HashMap<Integer, Arista> P_aristas = new HashMap(); 
        int nodo_n = 0; 
        NodosVisitados.add(G.getNodos().get(0).get());
        G.getNodos().get(0).setfal(true);
        PriorityQueue<Arista> c_priori = new PriorityQueue<>();
        double d = 0;
        for (int m = 0; m < G.getAristas().size(); m++) {
            for (int k = 0; k < NodosVisitados.size(); k++) {
                for (int j = 0; j < G.getNodos().size(); j++) {
                    if (MatrixA[NodosVisitados.get(k)][j] != null && G.getNodos().get(j).getfal() == false) {
                        c_priori.add(MatrixA[NodosVisitados.get(k)][j]);
                    }
                }
            }
            if (c_priori.isEmpty() == false) {
                if (NodosVisitados.contains(c_priori.peek().getAn1())) {
                    G.getNodos().get(c_priori.peek().getAn2()).setfal(true);
                    NodosVisitados.add(c_priori.peek().getAn2());
                    P_aristas.put(nodo_n, MatrixA[c_priori.peek().getAn1()][c_priori.peek().getAn2()]);
                    nodo_n++;
                    d = d + c_priori.peek().getP();
                    c_priori.clear();
                } else {
                    G.getNodos().get(c_priori.peek().getAn1()).setfal(true);
                    NodosVisitados.add(c_priori.peek().getAn1());
                    P_aristas.put(nodo_n, MatrixA[c_priori.peek().getAn1()][c_priori.peek().getAn2()]);
                    nodo_n++;
                    d = d + c_priori.peek().getP();
                    c_priori.clear();
                }
            }
            if (P_aristas.size() == G.getNodos().size() - 1) {
                break;
            }
        }
        System.out.println("Valor total del peso del árbol MST, aplicando Prim =  "+d);
        Grafo P = new Grafo(G.getNodos(), P_aristas);
        return P;
    }
    
    public Grafo Kruskal_D() {
        Grafo G = new Grafo(this.Nodos, this.Aristas);
        PriorityQueue<Arista> c_priori = new PriorityQueue<>();
        for (int i = 0; i < G.getAristas().size(); i++) {
            c_priori.add(G.getAristas().get(i));
        }
        HashMap<Integer, Arista> MST = new HashMap(); 
        HashMap<Integer, Nodos> KG = new HashMap();
        ArrayList<Integer> NodosVisitados = new ArrayList<Integer>(); 
        int nA = 0;
        int nNodo = 0;
        double d = 0;
        for (int i = 0; i < G.getAristas().size(); i++) {
            if (NodosVisitados.contains(c_priori.peek().getAn1()) && NodosVisitados.contains(c_priori.peek().getAn2())) {
                Grafo aux_1 = new Grafo(G.getNodos(), MST); 
                Grafo aux_2 = new Grafo();
                aux_2 = DFS_I(aux_1, aux_1.getNodos().get(c_priori.peek().getAn1()));
                int bandera = 0;
                for (int k = 0; k < aux_2.getNodos().size(); k++) {
                    if (aux_2.getNodos().get(k).get() == c_priori.peek().getAn2()) {
                        bandera = 1;
                    }
                }
                if (bandera == 0) {
                    d = d + c_priori.peek().getP();
                    MST.put(nA, c_priori.poll());
                    nA++;
                } else {
                    c_priori.poll();
                }
            } else {
                if (NodosVisitados.contains(c_priori.peek().getAn1()) == false) {
                    NodosVisitados.add(c_priori.peek().getAn1());
                }
                if (NodosVisitados.contains(c_priori.peek().getAn2()) == false) {
                    NodosVisitados.add(c_priori.peek().getAn2());
                }
                d = d + c_priori.peek().getP();
                MST.put(nA, c_priori.poll());
                nA++;
            }
            if (MST.size() == G.getNodos().size() - 1) {
                i = G.getAristas().size();
            }
        }
        for (int l = 0; l < NodosVisitados.size(); l++) {
            KG.put(l, G.getNodos().get(NodosVisitados.get(l)));
        }
        System.out.println("Valor total del peso del árbol MST, aplicando Kruskal_D =  "+d);
        Grafo K_D = new Grafo(KG, MST);
        return K_D;
    }
    
    public Grafo Kruskal_I() {
        Grafo G = new Grafo(this.Nodos, this.Aristas);
        for (int i = 0; i < G.getAristas().size(); i++) 
            G.getAristas().get(i).setID(i);
        PriorityQueue<Arista> c_priori = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < G.getAristas().size(); i++) 
            c_priori.add(G.getAristas().get(i));
        int nA = 0; 
        HashMap<Integer, Arista> MST = new HashMap();
        Grafo aux = new Grafo();
        Arista borrar = new Arista();
        double min_exp = 0;
        for (int j = 0; j < G.getAristas().size(); j++) {
            borrar = c_priori.poll();
            G.getAristas().get(borrar.getID()).setfal(true);
            aux = DFS_I(G, G.getNodos().get(borrar.getAn1()));
            if (aux.getNodos().size()<G.getNodos().size()){
                MST.put(nA, new Arista(borrar.getAn1(), borrar.getAn2(), borrar.getP()));
                nA++;
                G.getAristas().get(borrar.getID()).setfal(false);
                min_exp = min_exp + borrar.getP();
            } 
        }
        System.out.println("Valor total del peso del árbol MST, aplicando Kruskal_I =  "+min_exp);
        
        Grafo KI = new Grafo(G.getNodos(), MST);
        return KI;
    }
    
    
    
  }
    
   
