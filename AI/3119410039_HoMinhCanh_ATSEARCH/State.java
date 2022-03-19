package ATSEARCH;
public class State{
	
	private String nameVertex;
	
	private int Gn;
	
	State(){
		nameVertex = "";
		Gn = 0;
	}
	
	State(String nameVertex, int Gn){
		this.nameVertex = nameVertex;
		this.Gn = Gn;
	}
	
	public String getNameVertex() {
		return this.nameVertex;
	}
	
	public int getGn() {
		return this.Gn;
	}
	
	public void setNameVertex(String nameVertex) {
		this.nameVertex = nameVertex;
	}
	
	public void setGn(int Gn) {
		this.Gn = Gn;
	}
}