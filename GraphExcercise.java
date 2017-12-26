import java.util.LinkedList;

public class GraphExcercise {
	int size=0;
	LinkedList<Integer>  adjListArray[]; 
	
	
	public GraphExcercise(int V) {
		
		this.size=V;
		for(int i=0;i<size;i++) {
			adjListArray[i] = new LinkedList<>();
		}
	}

	public void add(int source,int dest) {
		adjListArray[source].add(dest);
		}



}
