package taller3;

import java.util.ArrayList;
import java.util.Stack;

public class Kruskal {
    private Grafo arm;
    private int pesoTotal;
    
    public Kruskal(Grafo g){
        ArrayList<Arista> aux = new ArrayList<>();//Lista con todas las aristas
        for(int i = 0; i < g.V; i++){//Para cada nodo del grafo
            for(Arista a: g.adj[i]){//se guardan sus respectivas aristas
                if(i < a.destino){//Condicional que evita aristas duplicadas
                    aux.add(a);
                }
            }
        }
        burbuja(aux);//Ordenamiento de aristas en funcion de su peso
        arm = new Grafo(g.V);
        pesoTotal = 0;
        for(Arista a: aux){//Recorrer aristas ordenadas
            if(!hayCamino(arm, a.origen, a.destino)){
                //Si no hay camino, agregar
                arm.agregarArista(a.origen, a.destino, a.peso);
                pesoTotal += a.peso;
            }
        }
        arm.imprimirGrafo();
        System.out.println("Peso Total = " + pesoTotal);
    }
    public void burbuja(ArrayList<Arista> aristas){//Burbuja por peso
        Arista temp;
        
        for(int i = 0; i < aristas.size() - 1; i++){
            for(int j = i+1;j < aristas.size(); j++){
                if(aristas.get(j).peso < aristas.get(i).peso){
                    temp = aristas.get(i);
                    aristas.set(i, aristas.get(j));
                    aristas.set(j, temp);
                }
            }
        }
    }
    public boolean hayCamino(Grafo g, int origen, int destino){
        //Utilizando DFS para verificar si existe camino
        boolean[] visited = new boolean[g.V];
        Stack<Integer> stack = new Stack<>();
        stack.push(origen);
        
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(u == destino){
                return true;
            }
            if(!visited[u]){
                visited[u] = true;
                
                for(Arista a : g.adj[u]){
                    int v = a.destino;
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }
        }
        return false;
    }
}