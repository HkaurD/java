import java.io.*;
import java.util.Arrays;

class Template {
    /**
     * Output the minimum total wait time on the first line.
     * Output the optimal new permutation on the second line.
     *
     * N: the number of students in line
     * C: the list of the bottle capacities, in liters, for each student
     */
    static void solve (int N, int[] C) {
        // YOUR CODE HERE
        int waittime = 0;
        int[] psa = new int[N + 1]; psa[0] = 0;

        String copy = "";
        for(int i = 0; i < C.length; i++){
            copy += String.valueOf(C[i]);
        }
        Arrays.sort(C);
        for(int i = 0; i < C.length; i++){
            psa[i + 1] = psa[i] + C[i];
            waittime += psa[i + 1];
        }
        System.out.println(waittime);
        for(int i = 0; i < N; i++){
            System.out.print(copy.indexOf(String.valueOf(C[i])) + 1);
            System.out.print(" ");
        }
    }

    static BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in)
    );
    static PrintWriter out = new PrintWriter(System.out);

    public static void main (String[] args) throws IOException {
        int T = Integer.parseInt(in.readLine());
        for (int i = 0; i < T; ++i) {
            int N = Integer.parseInt(in.readLine());
            String[] Cs = in.readLine().split(" ");
            int[] C = new int[N];
            for (int j = 0; j < N; ++j) C[j] = Integer.parseInt(Cs[j]);
            solve(N, C);
        }
        out.flush();
    }
}