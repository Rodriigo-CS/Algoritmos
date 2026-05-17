package taller3;
public class FloydWarshall {
    public FloydWarshall(Grafo g){
        //Matriz de distancias mínimas
        int[][] distancias = new int[g.V][g.V];
        int INF = Integer.MAX_VALUE/2;
        // Inicializar matriz
        for(int i = 0; i < g.V; i++){
            for(int j = 0; j < g.V; j++){
                if(i == j){//Distancia de un nodo a si mismo
                    distancias[i][j] = 0;
                }
                else{//Inicil no hay camino
                    distancias[i][j] = INF;
                }
            }
        }
        //Copiar las aristas del grafo
        //hacia la matriz de distancias
        for(int u = 0; u < g.V; u++){
            for(Arista a : g.adj[u]){
                //Peso entre Nodo y destino
                distancias[u][a.destino] = a.peso;
            }
        }        
        //k = nodo pivote
        for(int k = 0; k < g.V; k++){
            for(int i = 0; i < g.V; i++){//i = origen
                for(int j = 0; j < g.V; j++){//j = destino
                    //Verificar si por k se mejora el camino, sin sumar infinitos
                    if(distancias[i][k] != INF && distancias[k][j] != INF && distancias[i][k] + distancias[k][j] < distancias[i][j]){
                        distancias[i][j] = distancias[i][k] + distancias[k][j];
                    }
                }
            }
        }
        System.out.println("Matriz de caminos minimos:");
        for(int i = 0; i < g.V; i++){
            for(int j = 0; j < g.V; j++){
                if(distancias[i][j] == INF){
                    System.out.print("INF ");
                }
                else{
                    System.out.print(" " + distancias[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}