// breadth-first search finds the shortest path to a node by traversing each level
import java.util.*;

class Graph{
    private int nodes; // num of nodes in the graph
    // an adjacency list which stores the adjacent nodes to each of the nodes
    private final LinkedList<Integer> adj[];
    private int dist[]; // dist[i] stores the distance from node 1 to node i

    public Graph(int nodes){
        this.nodes = nodes;
        adj = new LinkedList[nodes + 1];
        dist = new int[nodes + 1];
        for(int i = 0; i <= nodes; i++){
            adj[i] = new LinkedList<>();
        }
        Arrays.fill(dist, 1000000000); // filling the array with a large integer
        dist[1] = 0; // the dist from node 1 to node 1 is 0
    }

    public void addEdge(int n, int e){ // adding an edge from node n to e
        adj[n].add(e); // only line needed for a directed graph
        // in an undirected graph, you also need the reverse
        // adj[e].add(n); ---> NEED BOTH
    }

    public void bfs(){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1); // push node 1 into the queue
        while(queue.size() != 0){
            int curNode = queue.poll(); // retrieves and removes the head of the linked list queue
            for(int neigh : adj[curNode]){
                // for every neighbour v
                int newcost = dist[curNode] + 1;
                if(newcost < dist[neigh]){
                    // the distance is better than the current distance to v
                    dist[neigh] = newcost; // update dist[v]
                    queue.add(neigh); // pushing the neighbour into the queue
                }
            }
        }
        for(int i = 1; i <= nodes; i++){
            System.out.println(dist[i]);
        }
    }
}

public class bfs1 {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // num of nodes
        int m = kb.nextInt(); // num of edges
        Graph g = new Graph(n);

        for(int i = 0; i < m; i++){
            int a = kb.nextInt(), b = kb.nextInt(); // node connections; directed graph
            g.addEdge(a, b); // b is a neighbour of a
        }
        g.bfs();
    }
}

//8 8
//1 3
//2 5
//2 6
//3 4
//3 5
//5 6
//8 6
//4 7