import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyGraph {
	int size;
    LinkedList<Integer> adjListArray[];
     
    // constructor 
    MyGraph(int V)
    {
        this.size = V;
         
        // define the size of array as 
        // number of vertices
        adjListArray = new LinkedList[V];
         
        // Create a new list for each vertex
        // such that adjacent nodes can be stored
        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }
         

public void addEdge(int source,int dest) {
		
	adjListArray[source].add(dest);
	//adjListArray[dest].add(source);
	
  }

public  void Display()
{       
    for(int v = 0; v < size; v++)
    {
        System.out.println("Adjacency list of vertex "+ v);
        
        for(Integer pCrawl: adjListArray[v]){
            System.out.print(" -> "+pCrawl);
        }
        System.out.println("\n");
    }
}


public void BFS(int s) {
	boolean visited []=new boolean [size];
	visited[s]=true;
	
	
	//LinkedList<Integer> q = new LinkedList<Integer>();
	Queue<Integer> q=new LinkedList<Integer>();
	q.add(s);
	
	while (q.size()!=0)
	{
		
		
		Integer popedVertice=q.poll();
		
		System.out.println("Popped " +popedVertice);
		
		
		   LinkedList<Integer> popedVerticed =adjListArray[popedVertice];
		  
		   for(Integer i:popedVerticed ) {
			   if (visited[i]!=true) {
				   q.add(i);
				   visited[i]=true;
			   }
		
		}
			
		
	}
	
}

public void DFS(int var) {
  Stack<Integer> s=new Stack();
  s.push(var);
  boolean [] visited=new boolean[size];
  visited[var]=true;
  DFShelper(s,visited);	
}


public void DFShelper(Stack<Integer> s,boolean [] visited) {
   	int popedVertice=s.pop();
   	visited[popedVertice]=true;
   	System.out.println("Popped " +popedVertice);
   	
   	LinkedList<Integer> adjVertices=adjListArray[popedVertice];
	
	for (Integer i:adjVertices) {
		if (!visited[i]) {
			s.add(i);
			DFShelper(s, visited);
		}
		
	}
	

}

public void TopologicalSort(int start) {
	
	Stack<Integer> s= new Stack();
    boolean [] visited=new boolean[size];
    for(int i=0;i<size;i++) 
    	visited[i]=false;
    	
    
	for(int i=0;i<size;i++) {
		if (visited[i]!=true)
		TopologicalSortHelper(visited,i,s);
	}
	while (s.size()!=0) {
		System.out.println(s.pop());
	}
	
}


private void TopologicalSortHelper(boolean[] visited,int vertice, Stack<Integer> s) {
	visited[vertice]=true;
	LinkedList<Integer> adjVertices=adjListArray[vertice];
	for(Integer i : adjVertices) {
		if (!visited[i]) 
			TopologicalSortHelper(visited,i,s);
	}
	s.push(vertice);
	
}






}
