import java.util.*;
// https://dmoj.ca/problem/ccc06j4

public class topologicalsort {
    static LinkedList<Integer> adj[] = new LinkedList[20]; // neighbouring nodes
    static int[] vis = new int[20]; // used to check if the node has been visited before
    static Stack<Integer> s = new Stack<Integer>();
    static int col = 0;

    static boolean dfs(int u){
        // returns true if it finds a cycle
        vis[u] = col;
        for(int neigh : adj[u]){
            if(vis[u] == vis[neigh]){ // same colour, same iteration
                // in the same iteration that we visited neighbour : there's a cycle
                return true; // it's a cycle
            }
            if(vis[neigh] == 0){ // not coloured
                if(dfs(neigh)){
                    return true;
                }
            }
        }
        // after reaching all the nodes it can reach, add it to the stack
        s.add(u); // LIFO
        return false; // there is not a cycle
    }

    public static void main(String[] args){
        boolean flag = true;
        Scanner kb = new Scanner(System.in);

        for(int i = 0; i <= 11; i++){
            adj[i] = new LinkedList<>();
        }

        while(true){
            int a = kb.nextInt(), b = kb.nextInt();
            if(a == 0){
                break;
            }
            adj[a].add(b); // directed graph
        }

        // the default to-do list restrictions
        //1,7
        //1,4
        //2,1
        //3,4
        //3,5

        adj[1].add(7);
        adj[1].add(4);
        adj[2].add(1);
        adj[3].add(4);
        adj[3].add(5);

        for(int i = 7; i >= 1; i--){ // seven diff tasks - we want 1 to be popped out first so it must be added last (LIFO)
            if(vis[i] == 0){
                col++;
                if(dfs(i)){
                    // cycle is found
                    System.out.println("Cannot complete these tasks. Going to bed.");
                    flag = false;
                    break;
                }
            }
        }

        if(flag) {
            while (!s.empty()) {
                System.out.print(s.pop() + " ");
            }
        }
    }
}

//6
//2
//5
//4
//0
//0
// 3 5 6 2 1 4 7