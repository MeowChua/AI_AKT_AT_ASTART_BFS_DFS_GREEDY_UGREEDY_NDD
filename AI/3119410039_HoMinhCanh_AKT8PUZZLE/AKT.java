package AKT_8PUZZLE;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.Scanner;

public class AKT {
    private int posX,posY;
    private int[][] puzzle;
    private int cost;
    public AKT(){
    }
    public AKT(int puzzle[][]){
        this.puzzle=puzzle;
    }
    private void swap(int[][] arr, int x1, int y1, int x2, int y2) {
        int tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
    void moveLeft(){
        swap(puzzle, posX, posY, posX, posY - 1);
        posY--;
    }
    void moveRight(){
        swap(puzzle, posX, posY, posX, posY + 1);
        posY++;
    }
    void moveUp(){
        swap(puzzle, posX, posY, posX - 1, posY);
        posX--;
    }
    void moveDown(){
        swap(puzzle, posX, posY, posX + 1, posY);
        posX++;
    }
    void initPuzzle(){
        int []ar = new int [3];
        Scanner sc = new Scanner(System.in);
        System.out.println( "Nhap cac gia tri cho puzzle : ");
        puzzle[0][0]=sc.nextInt(); puzzle[0][1]=sc.nextInt(); puzzle[0][2]=sc.nextInt();
        puzzle[1][0]=sc.nextInt(); puzzle[1][1]=sc.nextInt(); puzzle[1][2]=sc.nextInt();
        puzzle[2][0]=sc.nextInt(); puzzle[2][1]=sc.nextInt(); puzzle[2][2]=sc.nextInt();
        System.out.println( "Nhap chi phi toi da cua thuat toan = ");
        cost=sc.nextInt();
        ar[2]= cost;
        boolean checked = true;
        int sum = 0;
        for(int i= 0;i<3;i++){
            for(int j=0;j<3;j++){
                sum += puzzle[i][j];
                if(puzzle[i][j] > 8) {
                    checked = false;
                    break;
                }
            }
        }
        if(sum != 36 || checked == false){
            System.out.println( "Nhap sai du lieu vui long nhap lai");
            initPuzzle();
        }

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(puzzle[i][j] == 0){
                    posX = i;
                    posY = j;
                    return;
                }
            }
        }
    }
    void print(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print( puzzle[i][j] );
            }
            System.out.println();
        }
    }

    boolean checkFinish(){
        int counter1 = 0, counter2 = 0;
        for(int i=0;i<3;i++){
            if(puzzle[0][i] == i+1) counter1++;
        }

        for(int i=0;i<3;i++){
            if(puzzle[2][i] == 7-i) counter1++;
        }
        if(puzzle[1][0] == 8){
            counter1++;
        }
        if(puzzle[1][2] == 4) {
            counter1++;
        }
        if(counter1 == 8) return true;

        for(int i=0;i<3;i++){
            if(puzzle[0][i] == i) counter2++;
            if(puzzle[1][i] == i+3) counter2++;
            if(puzzle[2][i] == i+6) counter2++;
        }
        if(counter2 == 8) return true;
        return false;
    }

    int countStart(){
        int sum = 0;
        for(int q=0;q<9;q++){
            int row = (int)q/3;
            int col = (int)q%3;
            int counter = puzzle[row][col];
            for(int i =0;i<3;i++){
                for(int j=0;j<3;j++){
                    if( (row < i && puzzle[i][j] < counter && puzzle[i][j] != 0 )  ){
                        sum++;
                    }else if(row == i && col < j && puzzle[i][j] < counter && puzzle[i][j] != 0){
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public int getCost() {
        return cost;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public int[][] getPuzzle() {
        return puzzle;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }
}
