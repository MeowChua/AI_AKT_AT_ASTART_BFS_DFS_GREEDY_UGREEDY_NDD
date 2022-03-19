package ATSEARCH;
import java.util.ArrayList;

public class Main {
	
	static Matrix matrix;
	
	static ArrayList<Vertex> open = new ArrayList<>();
	
	static ArrayList<Vertex> close = new ArrayList<>();
	
	static ArrayList<Vertex> listVertex = new ArrayList<>();
	
	static int amountVertex = 23;
	
	// change vertex target at here
	static String target = "r";   
			
	public static void main(String []ar) {
		initialMatrix();
		initialVetex();
		initialAdjacent();
		open.add(listVertex.get(0));
		while(open.size() > 0) {
			close.add(open.get(0));
			int index = close.indexOf(open.remove(0));
			ArrayList<Vertex> openNew = new ArrayList<>();
			openNew.addAll(close.get(index).getAdjacent());
			for(int i = 0; i<openNew.size(); i++) {
				int row = getIndexVertex(close.get(index).getState().getNameVertex());
				int colum = getIndexVertex(openNew.get(i).getState().getNameVertex());
				int gn = close.get(index).getState().getGn();
				int gn_s = matrix.matrix[row][colum];
				openNew.get(i).getState().setGn( gn + gn_s);
				openNew.get(i).setPath(close.get(index));
			}
			
			open.addAll(openNew);
			sortOpen();
			
		}
		getMatch();
	}
	
	public static void getMatch() {
		
		ArrayList<String> path = new  ArrayList<>();
		
		int index = getIndexVertex(target);
		
		
		String end = "start";
		
		String namePrevious = listVertex.get(index).getPath().get(0).getState().getNameVertex();
		
		
		while(namePrevious.equals(end) == false) {
			path.add(namePrevious);
			index = getIndexVertex(namePrevious);
			namePrevious = listVertex.get(index).getPath().get(0).getState().getNameVertex();
			
		}
		
		System.out.print(end + "->");
		
		for(int i = path.size()-1; i>=0; i--) {
			System.out.print(path.get(i) + "->");
		}
		
		System.out.print(target);
		
	}
	
	public static void initialMatrix() {
		matrix = new Matrix();
		
		// dinh 0
		matrix.initialMatrix(0, 1, 100);
		matrix.initialMatrix(0, 2, 17);
		matrix.initialMatrix(0, 3, 1);
		matrix.initialMatrix(0, 4, 1);
		
		// dinh 1
		matrix.initialMatrix(1, 5, 1);
		
		// dinh 2
		matrix.initialMatrix(2, 6, 1);
		
		// dinh 3
		matrix.initialMatrix(3, 7, 10);
		matrix.initialMatrix(3, 8, 20);
		
		// dinh 4
		matrix.initialMatrix(4, 9, 12);
		matrix.initialMatrix(4, 10, 1);
		
		// dinh 5
		matrix.initialMatrix(5, 11, 1);
		
		// dinh 7
		matrix.initialMatrix(7, 12, 1);
		
		// dinh 8
		matrix.initialMatrix(8, 13, 1);
		
		
		// dinh 10
		matrix.initialMatrix(10, 14, 1);
		
		// dinh 11
		matrix.initialMatrix(11, 15, 1);
		
		// dinh 14
		matrix.initialMatrix(14, 16, 1);
		
		// dinh 15
		matrix.initialMatrix(15, 17, 1);
		
		// dinh 16
		matrix.initialMatrix(16, 18, 1);
		
		// dinh 17
		matrix.initialMatrix(17, 19, 1);
		matrix.initialMatrix(17, 20, 1);
		
		// dinh 20
		matrix.initialMatrix(20, 21, 1);
		
		// dinh 21
		matrix.initialMatrix(21, 22, 1);
		
	}
	
	public static void initialVetex() {
		for(int i = 0; i<amountVertex; i++) {
			String nameVertex = Vertex.getNameVertex(i);
			listVertex.add(new Vertex(new State(nameVertex, i)));
		}
	}
	
	public static int getIndexVertex(String name) {
		for(int i = 0; i<amountVertex; i++) {
			if(listVertex.get(i).getState().getNameVertex().equals(name)) {
				return i;
			}
		}
		return 0;
	}
	
	public static void printAdjacent() {
		for(int i = 0 ;i<listVertex.size(); i++) {
			System.out.print("dinh" + i + ":");
			listVertex.get(i).printAdjacent();
			System.out.println();
		}
	}
	
	public static void sortOpen() {
		if(open.size() <= 1) return;
		for(int i = 0; i<open.size()-1; i++) {
			for(int j = i+1 ; j<open.size(); j++) {
				int Gn1 = open.get(i).getState().getGn();
				int Gn2 = open.get(j).getState().getGn();
				Vertex temp1 = open.get(i);
				Vertex temp2 = open.get(j);
				if(Gn1 > Gn2) {
					open.remove(i);
					open.add(i, temp2);
					
					open.remove(j);
					open.add(j, temp1);
				}
			}
		}
		
	}
	
	public static void initialAdjacent() {

		
		// dinh 0
		listVertex.get(0).addAdjacent(listVertex.get(1));
		listVertex.get(0).addAdjacent(listVertex.get(2));
		listVertex.get(0).addAdjacent(listVertex.get(3));
		listVertex.get(0).addAdjacent(listVertex.get(4));
		
		// dinh 1
		listVertex.get(1).addAdjacent(listVertex.get(5));
		
		// dinh 2
		listVertex.get(2).addAdjacent(listVertex.get(6));
		
		// dinh 3
		listVertex.get(3).addAdjacent(listVertex.get(7));
		listVertex.get(3).addAdjacent(listVertex.get(8));
		
		// dinh 4
		listVertex.get(4).addAdjacent(listVertex.get(9));
		listVertex.get(4).addAdjacent(listVertex.get(10));
		
		// dinh 5
		listVertex.get(5).addAdjacent(listVertex.get(11));
		
		// dinh 7
		listVertex.get(7).addAdjacent(listVertex.get(12));
		
		// dinh 8
		listVertex.get(8).addAdjacent(listVertex.get(13));
		
		// dinh 10
		listVertex.get(10).addAdjacent(listVertex.get(14));
		
		// dinh 11
		listVertex.get(11).addAdjacent(listVertex.get(15));
		
		// dinh 14
		listVertex.get(14).addAdjacent(listVertex.get(16));
		
		// dinh 15
		listVertex.get(15).addAdjacent(listVertex.get(17));
		
		// dinh 16
		listVertex.get(16).addAdjacent(listVertex.get(18));
		
		// dinh 17
		listVertex.get(17).addAdjacent(listVertex.get(19));
		listVertex.get(17).addAdjacent(listVertex.get(20));
		
		// dinh 20
		listVertex.get(20).addAdjacent(listVertex.get(21));
		
		// dinh 21
		listVertex.get(21).addAdjacent(listVertex.get(22));
	}
}