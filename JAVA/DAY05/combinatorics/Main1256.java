package DAY05.combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1256{
	static int INF = 1000000001;

    static double[][] dp;
    static StringBuilder res = new StringBuilder();

    private static double getDP(int a,int z){
    	// 기저에 도착하면 1 리턴
        if(a == 0 || z == 0)
            return 1;
        
        // 한 번 돌아서 그 값을 안다면 값 리턴
        if(dp[a][z]!=0)
            return dp[a][z];
        
        // dp[x][y] = dp[x-1][y] + dp[x][y-1]
        return dp[a][z] = Double.min(getDP(a-1, z) + getDP(a, z-1), INF);
    }

    //정답이 될 단어 만들기
    // a 개수, z 개수, 이전 순번 
    private static void getResult(int a, int z, double order){
        if(a == 0){
            for(int i = 0; i < z; i++)
                res.append("z");
            return;
        }
        if(z == 0){
            for(int i = 0; i < a; i++)
                res.append("a");
            return;
        }
        // a가 맨 앞에 붙고 나머지 a-1, z로 만들 수 있는 경우의 수
        double getDP = getDP(a - 1, z);
        // 맨앞에 z를 붙이는 경우
        if(order > getDP){
            res.append("z");
            getResult(a, z - 1, order - getDP);
        }
        else{
            res.append("a");
            getResult(a - 1, z, order);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n, m;
        double k;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        dp = new double [n+1][m+1];
        getResult(n,m,k);

        if(getDP(n,m) < k)
            System.out.println(-1);
        else
            System.out.println(res.toString());

    }
}