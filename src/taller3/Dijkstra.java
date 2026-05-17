package taller3;
public class Dijkstra {
    public Dijkstra(Grafo g, int origen, int destino){
        int[] distancias = new int[g.V];//distancias hacia un nodo 
        boolean[] visitados = new boolean[g.V];//nodos visitados
        int[] camino = new int[g.V];//camino desde el origen hasta el destino
        
        for(int i = 0; i < g.V; i++){//Se inicia distancias con infinitos
            distancias[i] = Integer.MAX_VALUE;
            camino[i] = -1;
        }
        distancias[origen]= 0;//La distancia del nodo hacia si mismo es 0
        for(int j = 0; j < g.V; j++){
            int u = Integer.MAX_VALUE;
            int Dminima = Integer.MAX_VALUE;
            for(int k = 0; k < g.V; k++){//Nodo no visitado con menor distancia
                if(!visitados[k] && distancias[k] < Dminima){
                    //si encuentra un nodo con menor distancia actualiza
                        Dminima = distancias[k];
                        u = k;
                }
            }
            visitados[u] = true;//El nodo se marca como visitado
            for (Arista a : g.adj[u]) {
                //Para cada nodo conectado se guarda su destino y peso
                int v = a.destino;
                int w = a.peso;
                //Si no se ha visitado el destino y la suma del peso del nodo
                //con el peso del nodo al destino es menor a la distancia guardada del destino
                if (!visitados[v] && distancias[u] + w < distancias[v]) {
                    distancias[v] = distancias[u] + w;//se guarda como nueva distancia
                    camino[v] = u;//Se guarda de cual nodo viene
                }
            }
        }
        String ruta = "";
        int d = destino;
        while(camino[d] != -1){
            ruta = camino[d] + "-" + ruta;
            d = camino[d];
        }
        System.out.println(ruta + destino);
        System.out.println("El peso de la ruta es: " + distancias[destino]);
    }
}