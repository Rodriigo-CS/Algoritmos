package taller3;
public class Prim {
    private Grafo arm;
    private int pesoTotal;
    
    public Prim(Grafo g){
        arm = new Grafo(g.V);
        pesoTotal = 0;
        
        boolean[] visited = new boolean[g.V];//Lista de visitados      
        visited[0] = true;//Empezando arbitrariamente en el nodo 0
        while(arm.A < g.V - 1){//Un ARM tiene (nodos-1) aristas
            int menor = Integer.MAX_VALUE;
            int origen = -1;
            int destino = -1;
            
            //Busca la arista minima valida
            for(int i = 0; i < g.V; i++){
                //Solo desde nodos visitados
                if(visited[i]){
                    for(Arista a: g.adj[i]){
                        //Revisa los nodos conectados que no se han visitado
                        if(!visited[a.destino]){
                            if(a.peso < menor){
                                menor = a.peso;
                                origen = i;
                                destino = a.destino;
                                //guarda peso, origen, destino de la arista minima
                            }
                        }
                    }
                }
            }
            //Agrega la mejor arista encontrada
            arm.agregarArista(origen, destino, menor);
            pesoTotal += menor;
            visited[destino] = true;//se marca el nodo como visitado
        }
        arm.imprimirGrafo();
        System.out.println("Peso Total = " + pesoTotal);
    }
}
