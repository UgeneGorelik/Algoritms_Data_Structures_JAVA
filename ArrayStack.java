
public class ArrayStack {
	
	int ArraySize;
	int [] ArrStack;
	int topA;
	int topB;

	public ArrayStack(int Size) {
		ArraySize=Size;
		topA=0;
		topB=ArraySize;
		
	}
    public void PushA(int Item) {
    	if (topA<topB)
    	{
    		ArrStack[topA]=Item;
    	   		topA++;
    	}
    	
    	
    }
    
    public void PushB(int Item) {
    	if (topA<topB)
    	{
    		ArrStack[topA]=Item;
    	   		topB++;
    	}
    	
    	
    	
    	
    }


}
