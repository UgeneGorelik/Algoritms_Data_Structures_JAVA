
public class PriorityQueue {
	
	public int [] Qstack;
	int size;
	int top;
	
	public PriorityQueue(int size)
	{
		Qstack=new int[size];
		top = 0;
		
	}
	
    public void push(int item) {
    	
    	Qstack[top]=item;
    	int itemPos=top;
    	int ParentPos=(itemPos+1)/2-1;
    	
    	while(itemPos>0)
    	{
    		
    		 ParentPos=(itemPos+1)/2-1;
    		
    		
    		
    		if (Qstack[ParentPos]<Qstack[itemPos]) {
    		    swap(ParentPos,itemPos);
    		    itemPos=ParentPos;
    		}
    		else
    		   	break;
    		
    			
    		    
    	}
    	
    	top++;
    }
	
    public void swap(int pos,int itemPos) {
    	int tmp=Qstack[pos];
    	Qstack[pos]=Qstack[itemPos];
    	Qstack[itemPos]=tmp;
    	
    	
    }
    
    public int pop()
    {
    	int toreturn = Qstack[0];
    	Qstack[0]=Qstack[top];
    	int itemPos=0;
    	
    	
    	
    	while (itemPos<size/2) {
            int rightChild=itemPos*2-1;
            int leftChild=rightChild+1;
            
            if(rightChild<size && Qstack[leftChild]<Qstack[rightChild] ){
            	if (Qstack[itemPos]>=Qstack[rightChild])break;
            	swap(rightChild,itemPos);
                itemPos=rightChild;
            }else {
            	if (Qstack[itemPos]>=Qstack[leftChild])break;
            	swap(leftChild,itemPos);
                itemPos=leftChild;
            	
            }
            
           
            
    		
    		
    	}
    	
    	
    	 size--;
    	
    	
    	return toreturn;
    }
    
	public void Display() {
		for(int i=0;i<top;i++) {
			System.out.println(Qstack[i]);
		}
	}
    
}
