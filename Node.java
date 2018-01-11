
public class Node {
	public String Val;
	
	public Node next;
	
	public Node(String Val) {
		this.Val=Val;
	}
    
	public void display() {
		System.out.println("VAL= "+this.Val);
	}
	
}
