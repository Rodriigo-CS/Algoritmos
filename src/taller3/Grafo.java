package taller3;

import java.util.LinkedList;
import java.util.Stack;

public class Grafo {
    LinkedList<Arista>[] adj;
    int V;
    int A;
    
    public Grafo(int nodos){
        this.V = nodos;
        this.A = 0;
        this.adj = new LinkedList[nodos];
        for (int v = 0; v < V; v++){
            adj[v] = new LinkedList<>();
        }
    }
    public void agregarArista(int u, int v, int p){
        adj[u].add(new Arista(u, v, p));
        adj[v].add(new Arista(v, u, p));
        A++;
    }
    public void imprimirGrafo(){
        for(int v = 0; v < V; v++){
            System.out.print("Nodo "+v+": ");
            for(int w = 0; w < adj[v].size();w++){
                Arista a = adj[v].get(w);
                System.out.print("("+ a.destino +", peso=" + a.peso + ") ");
            }
            System.out.println("");
        }
    }
    public void dfs(int s){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);
        
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u] = true;
                System.out.print(u + "");
                
                for(Arista a : adj[u]){
                    int v = a.destino;
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
    }   
}
