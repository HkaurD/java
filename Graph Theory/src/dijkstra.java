// Dijkstra's algorithm works on undirected, connected, weighted graphs. It finds the shortest path to the end node.
import java.util.*;
// https://dmoj.ca/problem/sssp

public class dijkstra {
    public static final int maxn = (int)1e5 + 5;
    static ArrayList<ArrayList<Node>> adj = new ArrayList<>(); // neighbouring nodes
    static int[] dist = new int[maxn]; // the distance to the nodes from the starting node

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int vertices = kb.nextInt(), edges = kb.nextInt();

        for(int i = 0; i < edges + 5; i++) {
            ArrayList<Node> lst = new ArrayList<Node>();
            adj.add(lst); // each index in the arraylist stores an arraylist of adjacent nodes
        }
        for(int i = 0; i < edges; i++) {
            int a = kb.nextInt(), b = kb.nextInt(), c = kb.nextInt();
            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }

        // PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
        PriorityQueue<Node> pqueue = new PriorityQueue<>(vertices, new Node()); // used to explore the least expensive node paths

        Arrays.fill(dist, Integer.MAX_VALUE); // the min distances are taken to find the shortest path
        dist[1] = 0; // the distance from node 1 to node 1 is 0
        pqueue.add(new Node(1, 0)); // the first node which has a cost of 0

        while(pqueue.size() != 0){ // while there are nodes to explore
            int weight = pqueue.peek().weight, node = pqueue.peek().node; // storing the weight and node
            pqueue.poll(); // removes the node from the priority queue
            if(dist[node] != weight){ // the weight of the node must equal the distance from the starting node
                continue;
            }
            for(Node temp : adj.get(node)){ // looping through the neighbour nodes
                int newcost = temp.weight + weight; // the cost to get to the neighbour node from the current node is just the weight between the edges connecting them
                if(newcost < dist[temp.node]){
                    dist[temp.node] = newcost;
                    pqueue.add(new Node(temp.node, dist[temp.node]));
                }
            }
        }
        for(int i = 1; i <= vertices; i++){
            System.out.println((dist[i] == dist[0] ? -1 : dist[i]));
        }
    }
}

class Node implements Comparator<Node>{
    public int node;
    public int weight;

    public Node(){
    }

    public Node(int node, int weight){
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compare(Node a, Node b){
        if(a.weight < b.weight){
            return -1;
        } else if (a.weight > b.weight)
            return 1;
        return 0; // equal weights
    }
}