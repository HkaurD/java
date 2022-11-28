// depth-first search traverses one node path until it reaches a dead end, then it goes to the next adjacent node
import java.util.*;
// https://dmoj.ca/problem/wc18c4s1

public class dfs1 {
    static int[] colour = new int[10000]; // colour[i] stores the colour of node i --> if the nodes are the same colour, they are connected
    static LinkedList<Integer>[] adj = new LinkedList[10000];
    static int col = 0; // current colour

    static void dfs(int u){
        colour[u] = col; // all the adjacent connected nodes are the same colour
        for(int v : adj[u]){
            // for every v this is a neighbour
            if(colour[v] == 0){
                dfs(v); // all the neighbours have the same colour since they're connected
            }
        }
    }

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int numPlanets = kb.nextInt(); int planetEdges = kb.nextInt(); int numFriends = kb.nextInt();
        String r = kb.next();
        kb.nextLine();
        for(int i = 0; i <= numPlanets; i++){
            adj[i] = new LinkedList<>();
        }
        for(int i = 0; i < planetEdges; i++){
            int a = kb.nextInt(), b = kb.nextInt();
            if(("" + r.charAt(a - 1)).equals("" + r.charAt(b - 1))){ // if the planets are the same race
                adj[a].add(b);
                adj[b].add(a); // this is an undirected graph
            }
        }
        for(int i = 1; i <= numPlanets; i++){
            if(colour[i] == 0){
                col++;
                dfs(i);
            }
        }
        int ans = 0;
        for(int i = 0; i < numFriends; i++){
            int x = kb.nextInt(), y = kb.nextInt();
            ans += (colour[x] == colour[y]) ? 1 : 0; // if the nodes have the same colour, they are connected
        }
        System.out.println(ans);
    }
}

//6 7 3
//PZZPPP
//1 2
//6 4
//3 4
//2 5
//5 6
//1 4
//4 2
//6 4
//2 3
//1 5