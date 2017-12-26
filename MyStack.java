
/*
 * Implementation of Stack Data structure
 *
 */


public class MyStack {
	public int size;
	public int[] StackArray;
	public int[] MinStack;
	public int[] BigStack;
	public int MinSize=0;
	public int BigTop=-1;
	public int Top = -1; 
	
	
	public MyStack(){
	
		size=0;
		StackArray = new int[20];
		MinStack = new int[20];
		BigStack = new int[20];
	}
	
	
   public void push(int Item) {
	   Top++;
	   StackArray[size]=Item;
	   size++;
	   if (MinSize==0) {
		   MinStack[0]=Item;
		   MinSize++;
		   
	   }
	   else {
		   int pos=0;
		  
		   while(MinStack[pos]<Item && pos<MinSize)
		   {
			   pos++;
		   }
		 
			
			for (int i=pos;i<MinSize;i++) {
				MinStack[i+1]=MinStack[i];
		  	   }
			
			 MinStack[pos]=Item;
			 MinSize++;
	   }
	   
  
       if (BigTop==-1) {  
    	   BigStack[0]=Item;
    	   BigTop++;
       }
       else {
    	   if (BigStack[BigTop]<Item) {
    		   BigTop++;
    	       BigStack[BigTop]=Item;
    	   }
    	   else {
    		   BigTop++;
    	       BigStack[BigTop]=BigStack[BigTop-1];
    	   }
       }
      
      
   
   
   
   
   }
	public int pop() {
		int toput=StackArray[Top];
		StackArray[Top]=-1;
		size--;
		Top--;
		return toput;
	}
	
	
	public int peek(){
		int i=StackArray[Top];
		return i;
	}
	
	public Boolean isempty(){
		if (Top==-1) {
			return false;
		}
		
		return true;
		
	}

    public void Display() {
    	
    	for (int i=0;i<size;i++) {
    	
    		System.out.println(StackArray[i]);
    	}
    	
    	
    	for (int i=0;i<size;i++) {
    	//	System.out.println(BigStack[i]);
    	}
    	
    	
    }
	
}
