package ATSEARCH;
import java.util.ArrayList;
import java.util.List;

public class Path<T>{
	
	private List<T> vertexPrevious;
	
	Path(){
		vertexPrevious = new ArrayList<>();
	}
	
	public void addVertex(T vertex) {
		vertexPrevious.add(vertex);
	}
	
	public void setPath(T path) {
		vertexPrevious.add(path);
	}
	
	public List<T> getPath(){
		return this.vertexPrevious;
	}
	
	public void printPath(){
        for (int i = 0; i < vertexPrevious.size(); i++){
            System.out.print(vertexPrevious.get(i).toString() + " ");
        }
        
        System.out.println();
    }  
}