package ATSEARCH;

import java.util.ArrayList;
import java.util.List;

public class Vertex{
	
	private State state;

	private Path<Vertex> path;
	
	private List<Vertex> adjacent; 
	
	Vertex(){
		state = new State();
		path = new Path<>();
		adjacent = new ArrayList<>();
	}
	
	Vertex(State state){
		this.state = state;
		path = new Path<>();
		adjacent = new ArrayList<>();
	}
	
	public void addAdjacent(Vertex vertex) {
		adjacent.add(vertex);
	}
	
	public List<Vertex> getAdjacent(){
		return this.adjacent;
	}
	
	public void setPath(Vertex path) {
		this.path.setPath(path);
	}
	
	public List<Vertex> getPath() {
		return this.path.getPath();
	}
	
	public State getState() {
		return this.state;
	}
	
	public void addToPath() {
		this.path.addVertex(this);
	}
	
	 public void printPath(){
	   path.printPath();
	 }
	 
	 public void printAdjacent() {
		 
		 for(int j = 0; j<adjacent.size(); j++) {
			System.out.print(adjacent.get(j).state.getNameVertex());
		 }
			 
		 
	 }
	
	@Override
	public String toString() {
		return path.toString();
	}
	
	public static String getNameVertex(int value) {
		String nameVertex = "";
		switch(value) {
			case 0: nameVertex = "start";
					break;
			
			case 1: nameVertex = "a";
					break;
					
			case 2: nameVertex = "b";
					break;
			
			case 3: nameVertex = "c";
					break;
			
			case 4: nameVertex = "d";
					break;
			
			case 5: nameVertex = "e";
					break;
			
			case 6: nameVertex = "f";
					break;
			
			case 7: nameVertex = "g";
					break;
			
			case 8: nameVertex = "h";
					break;
			
			case 9: nameVertex = "i";
					break;
			
			case 10: nameVertex = "j";
					break;
			
			case 11: nameVertex = "k";
					break;
			
			case 12: nameVertex = "l";
					break;
			
			case 13: nameVertex = "m";
					break;
			
			case 14: nameVertex = "n";
					break;
			
			case 15: nameVertex = "o";
					break;
			
			case 16: nameVertex = "p";
					break;
			
			case 17: nameVertex = "q";
					break;
			
			
			case 18: nameVertex = "r";
					break;
			
			case 19: nameVertex = "s";
					break;
			
			case 20: nameVertex = "t";
					break;
			
			case 21: nameVertex = "u";
					break;
			
			case 22: nameVertex = "v";
					break;
					
			
		}
		
		return nameVertex;
	}
	
	
	
}