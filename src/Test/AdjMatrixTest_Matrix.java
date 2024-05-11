package Test;

public class AdjMatrixTest_Matrix {
    static int[][] adjMatrix;
    static int V;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();
        adjMatrix=new int[V][V]; //모두 0으로초기화된 상태


        int from,to;
        for (int i = 0; i < E; ++i) {
            from = sc.nextInt();
            to = sc.nextInt();

            //무향 그래프
            adjMatrix[to][from]=adjMatrix[from][to]=1;
        }
//		for (int i = 0; i < adjMatrix.length; i++) {
//			for (int j = 0; j < adjMatrix[i].length; j++) {
//				System.out.print(adjMatrix[i][j]+" ");
//			}
//			System.out.println();
//		}
        //print();
        DFS(0,new boolean[V]);
        //BFS(0);
    }
    private static void DFS(int current, boolean[] visited) { //current : 탐색 정점
        visited[current]=true;
        System.out.println((char)(current+65));
        //자신의 인접행렬 확인
        for (int i = 0; i < V; i++) {
            if(adjMatrix[current][i]!= 0 && !visited[i]) {
                DFS(i,visited);
            }
        }


    }
    static void print() {
        for(int[] am : adjMatrix) {
            System.out.println(Arrays.toString(am));
        }
    }

    private static void BFS(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[V];
        queue.offer(start);
        visited[start]=true;

        int current=0;
        while(queue.size()!=0) {
            current = queue.poll();
            System.out.println((char)(current+65));//탐색할때 해야할일
            for (int i = 0; i < V; i++) {
                if(adjMatrix[current][i]!=0 && !visited[i]) {
                    queue.offer(i);
                    visited[i]=true;
                }
            }
        }

    }
}
