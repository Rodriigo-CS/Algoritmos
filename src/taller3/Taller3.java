package taller3;
public class Taller3 {
    public static void main(String[] args) {
        Grafo g = new Grafo(6);

        g.agregarArista(0 ,1 ,3);
        g.agregarArista(0 ,2 ,4);
        g.agregarArista(0 ,4 ,8);
        g.agregarArista(2 ,4 ,3);
        g.agregarArista(1, 4, 5);
        g.agregarArista(4, 3, 7);
        g.agregarArista(4, 5, 3);
        g.agregarArista(5, 3, 2);

        System.out.println("Grafo original:");
        g.imprimirGrafo();

        System.out.println("\nKruskal:");
        Kruskal k = new Kruskal(g);
        
        System.out.println("Prim");
        Prim p = new Prim(g);
        
        System.out.println("Dijkstra");
        Dijkstra d = new Dijkstra(g,0,5);
        
        System.out.println("FloydWarshall");
        FloydWarshall f = new FloydWarshall(g);
    }
}
