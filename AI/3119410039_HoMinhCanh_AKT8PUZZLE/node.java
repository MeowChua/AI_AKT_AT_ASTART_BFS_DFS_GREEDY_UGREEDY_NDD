package AKT_8PUZZLE;
/*
#define REP(i , l , r) for(int i = l ; i <= r ; i++)
#define REPD(i , l , r) for(int i = l ; i >= r ; i--)
#define REPS(i , l , r) for(int i = l ; i < r ; i++)
 */
public class node {
    private int[][] arr;
    private int x,y,f,cost;
    private String way = "";
    private facing canFace;
    private static int checker;
    public node(){}
    public node(int [][]arr, facing canFace,int x,int y,int f,int checker,int cost){
        this.arr=new int[3][3];
        this.canFace=canFace;
        this.x=x;
        this.f=f;
        this.y=y;
        for(int i=0;i<3;i++){
            for(int j= 0; j <3; j++){
                this.arr[i][j] = arr[i][j];
            }
        }
        this.checker=checker;
        this.cost=cost;
    }
    public node(node myNode){
        this.arr=new int[3][3];
        this.canFace=myNode.getCanFace();
        this.x=myNode.getX();
        this.f=myNode.getF();
        this.y=myNode.getY();
        int[][] sparr = myNode.getArr();
        for(int i=0;i<3;i++){
            for(int j= 0; j <3; j++){
                this.arr[i][j] = sparr[i][j];
            }
        }
        this.checker=myNode.getChecker();
        this.cost=myNode.getCost();
        this.way = myNode.getWay();
    }
    boolean canMoveLeft(){
        return canFace != facing.LEFT && y > 0 && cost > herStic();
    }
    boolean canMoveRight(){
        return canFace != facing.RIGHT && y < 2 && cost > herStic();
    }
    boolean canMoveUp(){
        return canFace != facing.UP && x > 0 && cost > herStic();
    }
    boolean canMoveDown(){
        return canFace != facing.DOWN && x < 2 && cost > herStic();
    }
    int herStic(){
        int sum = 0;
        if(checker == 1){
            if(arr[0][0] != 1) sum++;
            if(arr[0][1] != 2) sum++;
            if(arr[0][2] != 3) sum++;
            if(arr[1][0] != 8) sum++;
            if(arr[1][2] != 4) sum++;
            if(arr[2][0] != 7) sum++;
            if(arr[2][1] != 6) sum++;
            if(arr[2][2] != 5) sum++;
        }else{
            if(arr[0][1] != 1) sum++;
            if(arr[0][2] != 2) sum++;
            if(arr[1][0] != 3) sum++;
            if(arr[1][1] != 4) sum++;
            if(arr[1][2] != 5) sum++;
            if(arr[2][0] != 6) sum++;
            if(arr[2][1] != 7) sum++;
            if(arr[2][2] != 8) sum++;
        }
        return sum + f;
    }
    void moveLeft(){
        swap(arr, x, y, x, y - 1);
        y--;
        canFace = facing.RIGHT;
        way += "l";
        f++;
    }

    private void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }

    void moveRight(){
        swap(arr, x, y, x, y + 1);
        y++;
        canFace =  facing.LEFT;
        way += "r";
        f++;
    }
    void moveUp(){
        swap(arr, x, y, x-1, y);
        x--;
        canFace =  facing.DOWN;
        way += "u";
        f++;
    }
    void moveDown(){
        swap(arr, x, y, x + 1, y);
        x++;
        canFace =  facing.UP;
        way += "d";
        f++;
    }

    boolean checkFinish(){
        if(checker == 1){
            for(int i=0;i <3;i++){
                if(arr[0][i] != i+1 || arr[2][i] != 7-i) return false;
            }
            return arr[1][0] != 8 || arr[1][2] != 4 ? false : true;
        }else{
            for(int i=0;i<3;i++){
                if(arr[0][i] != i || arr[1][i] != i+3 || arr[2][i] != i+6) return false;
            }
            return true;
        }

    }

    public facing getCanFace() {
        return canFace;
    }

    public int getChecker() {
        return checker;
    }

    public int getCost() {
        return cost;
    }

    public int getF() {
        return f;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getArr() {
        return arr;
    }

    public String getWay() {
        return way;
    }

    public void setArr(int[][] arr) {
        this.arr = arr;
    }

    public void setCanFace(facing canFace) {
        this.canFace = canFace;
    }

    public void setChecker(int checker) {
        this.checker = checker;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setF(int f) {
        this.f = f;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    void print(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print( arr[i][j] );
            }
            System.out.println();
        }
    }

}
