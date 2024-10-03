package Programmers.Level2;

class 행렬테두리회전하기 {
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    public void print(int[][] tmp,int rows,int columns){
//        return;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(tmp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------");
    }
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] arr =new int[rows][columns];

        int count=1;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                arr[i][j]=count;
                count++;
            }
        }
        //print(arr,rows,columns);
        for(int i=0; i<queries.length; i++){
            for(int j=0; j<queries[i].length; j++){
                queries[i][j]-=1;
                //System.out.println(queries[i][j]+" ");
            }
            //System.out.println();
        }
        int[] answer = new int[queries.length];
        for(int T=0; T<queries.length; T++){
            int value = arr[queries[T][0]][queries[T][1]];

            int first_x = queries[T][0];
            int first_y = queries[T][1];
            int last_x =queries[T][2];
            int last_y =queries[T][3];

            int d=0;
            int x=first_x;
            int y=first_y;

            int max_value = value;

            while(true){

                if(x==first_x && y==first_y+1){
                    arr[x][y]=value;
                    break;
                }

                int tmpX = x+dx[d];
                int tmpY = y+dy[d];
                if(tmpX<first_x || tmpX>last_x || tmpY<first_y || tmpY>last_y){
                    d++;
                    d%=4;
                    continue;
                }
                arr[x][y]=arr[tmpX][tmpY];
                max_value=Math.min(max_value,arr[tmpX][tmpY]);
                x=tmpX;
                y=tmpY;

            }
            answer[T]=max_value;
            //dx[-1,0,1,0]
            //dy[0,-1,0,1]
        }
        return answer;
    }
}
