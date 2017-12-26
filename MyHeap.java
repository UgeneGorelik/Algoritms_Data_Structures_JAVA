
/*
 * Implementation of heap Data structure

 */

public class MyHeap {
	int [] harr;
	int size=0;
	int maxize;
	
	public MyHeap(int maxsize) {
		this.maxize=maxsize;
		harr=new int[maxsize];
		
	}
    public int ParentIndex(int n) {
    	
    	return ((n-1)/2);
    }
    
    public int LeftChildIndex(int n) {
    	
    	return ((n*2)+1);
    }
    public int RightChildIndex(int n) {
    	
    	return ((n*2)+2);
    }
    public void swap(int a,int b) {
    	int tmp=harr[a];
    	harr[a]=harr[b];
    	harr[b]=tmp;
    			
    }
    public void insert(int item) {
    	
    	int itempos=size-1+1;
    	harr[itempos]=item;
    	size++;
    	while(harr[ParentIndex(itempos)]>harr[itempos]) {
    		swap(itempos,ParentIndex(itempos));
    		itempos=ParentIndex(itempos);
    	}
    	
    	
    }

    public void display() {
    	for (int i=0;i<size;i++)
    		System.out.println(harr[i]);
    }

}
