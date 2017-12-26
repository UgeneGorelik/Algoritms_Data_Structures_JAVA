import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*
* Implementation of Binary tree
* and Several algorithms Using this data structure
 */


public class BinaryTree {

    public  TreeNode Head;
    public int size=1;

    public BinaryTree(int Val) {
        Head =new TreeNode(Val);
    }

    //add function

    public void add(int Item) {

        TreeNode  ParseNode=Head;

        while(true)
        {
            if (Item>ParseNode.Val) {
                if (ParseNode.right==null) {
                    ParseNode.right=new TreeNode(Item);
                    size++;
                    return;

                }
                ParseNode=ParseNode.right;

            }


            if (Item<ParseNode.Val) {
                if (ParseNode.left==null) {
                    ParseNode.left=new TreeNode(Item);
                    size++;
                    return;

                }
                ParseNode=ParseNode.right;
            }

        }


    }
// recursive inorder traversal
    public void InOrder() {

        InOrderHelper(Head);
    }

    public void InOrderHelper(TreeNode ParseNode) {
        if (ParseNode==null) {
            return;
        }
        InOrderHelper(ParseNode.left);
        System.out.println(ParseNode.Val+", ");
        InOrderHelper(ParseNode.right);

    }
//delete node
    public void Delete(int Value) {
        TreeNode ParseNode=find(Value);



        if (ParseNode.Val==Value ) {

            ///have no children
            if (ParseNode.left==null && ParseNode.right==null ) {
                ParseNode=null;
            }
            //only left child
            if (ParseNode.left==null) {
                ParseNode=ParseNode.right;

            }
            //only right child
            if (ParseNode.right==null) {
                ParseNode=ParseNode.left;

            }

            //have 2 children
            if (ParseNode.left!=null && ParseNode.right!=null ) {
                TreeNode TempNode = ParseNode;
                while (TempNode.left!=null) {
                    TempNode=TempNode.left;
                }
                swap(ParseNode,TempNode);
                TempNode=null;

            }

        }



    }
//find node with minimum value
    public TreeNode MinVal(TreeNode N){
        TreeNode StartNode =N;
        while (StartNode.left!=null) {
            StartNode=StartNode.left;
        }
        return StartNode;

    }
//swap values of 2 nodes
    public void swap(TreeNode a,TreeNode b) {
        TreeNode tmp=a;
        a=b;
        b=tmp;

    }
    //swap values of 2 nodes
    public void swapVal(TreeNode a,TreeNode b) {
        int tmp=a.Val;
        a.Val=b.Val;
        b.Val=tmp;

    }
    //find node
    public TreeNode find(int Item)

    {
        TreeNode ParseNode=Head;
        while(true) {
            if(ParseNode.Val==Item)
                return ParseNode;
            if(Item>ParseNode.Val)
                ParseNode=ParseNode.right;
            if(Item<ParseNode.Val)
                ParseNode=ParseNode.left;

        }

    }
    public boolean IsBalancedRecursive(TreeNode ParseNode)
    {
        if (ParseNode==null) return true;
        int Diff=Math.abs(GetHeight(ParseNode.left)-GetHeight( ParseNode.right));
        if (Diff>1) return false;
        else {
            return (IsBalancedRecursive(ParseNode.left)&&IsBalancedRecursive(ParseNode.right));
        }


    }

    //create linked list of nodes of the tree

    public LinkedList<TreeNode> LevelLinkedNodesHelper(int Level,TreeNode ParseNode,LinkedList<TreeNode> Llist) {
        if (1==Level) Llist.add(ParseNode) ;

        Level--;
        if(ParseNode.left!=null) {
            //System.out.println("Level = "+Level+" Value = "+ParseNode.Val );
            LevelLinkedNodesHelper(Level,ParseNode.left, Llist);
        }
        if(ParseNode.right!=null) {
            // System.out.println("Level = "+Level+" Value = "+ParseNode.Val );
            LevelLinkedNodesHelper(Level,ParseNode.right, Llist);
        }

        return Llist;

    }

    public LinkedList<TreeNode> LevelLinkedNodes(int Level){

        LinkedList<TreeNode> Llist =new LinkedList();
        return LevelLinkedNodesHelper(Level,Head, Llist);


    }
    // recursive check if tree is true binary
    public int [] CheckTreeBinaryHelper(TreeNode ParseNode,int [] arr,int counter) {

        if(ParseNode==null) return arr;
        counter++;
        CheckTreeBinaryHelper(ParseNode.left,arr,counter);
        arr[counter]=ParseNode.Val;
        CheckTreeBinaryHelper(ParseNode.right,arr,counter);

        return arr;

    }

    public boolean CheckTreeBinary() {
        int [] arr=new int [size];
        CheckTreeBinaryHelper(Head,arr,0);
        for (int i=0;i<arr.length-1;i++) {
            System.out.println(arr[i]);

            if (arr[i]>arr[i+1]) return false;
        }
        return true;

    }

//find in order previous node of nnode having the value passed
    public TreeNode InorderPreproc(int Val) {
        TreeNode ParseNode=find(Val);
        if(ParseNode.right!=null) {
            TreeNode NewParseNode=ParseNode.right;
            while(NewParseNode.left!=null) NewParseNode=NewParseNode.left;
            return NewParseNode;
        }
        else {
            TreeNode Target=ParseNode;
            ParseNode=Head;
            TreeNode Leftmost=new TreeNode(0);
            //return InorderPreprocLeft(ParseNode,Head, ParseNode );
            while(ParseNode!=Target) {
                if(ParseNode.left!=null) {
                    Leftmost=ParseNode;
                    ParseNode=ParseNode.left;
                }
                else {
                    ParseNode=ParseNode.right;
                }

            }
            return Leftmost;
        }

    }
   
   /*public TreeNode InorderPreprocLeft(TreeNode TargetNode,TreeNode ParseNode,TreeNode Leftmost)
   {
	   
	   if (TargetNode==ParseNode) return Leftmost;
	    
	   if(ParseNode.left!=null) {
		   Leftmost=ParseNode.left;
		   InorderPreprocLeft(TargetNode,ParseNode.left,Leftmost);
	   }
	   InorderPreprocLeft(TargetNode,ParseNode.right,Leftmost);
	   
	   return Leftmost;
	   
   }*/

//get height of tree

    public int GetHeight(TreeNode ParseNode) {
        if (ParseNode==null) return 0;
        int x= (Math.max(GetHeight(ParseNode.left),GetHeight( ParseNode.right))+1);
        return x;

    }

   //check if tree is binary 
    public boolean IsBinaryUsingMinMAx() {

        return(IsBinaryUsingMinMAxHelper(Head,Integer.MIN_VALUE,Integer.MAX_VALUE));
    }

    private boolean IsBinaryUsingMinMAxHelper(TreeNode NodeToParse, int min, int max) {
        if(NodeToParse==null)return true;

        if(NodeToParse.Val<min || NodeToParse.Val>max) return false;

        if(!(IsBinaryUsingMinMAxHelper(NodeToParse.left,min,NodeToParse.Val) ||
                IsBinaryUsingMinMAxHelper(NodeToParse.right,NodeToParse.Val,max))
                )return false;

        return true;

    }

    
    public TreeNode CommonAncestor(int Val,int Val1) {

        TreeNode l=find(Val);
        TreeNode r=find(Val1);

        return CommonAncestorHelper(Head,l,r);

    }

    public TreeNode CommonAncestorHelper(TreeNode PArseNode, TreeNode l, TreeNode r) {
        // TODO Auto-generated method stub
        return null;
    }

    //check if nodes in same path as descending from root
    
    public void CheckNodesSamePath(int n,int n2,int start) {
        Stack<Integer>s =new Stack();
        boolean [] visited=new boolean[size+100];
        for(int i=0;i<size+100;i++) visited[i]=false;
        s.push(start);
        Integer [] intime=new Integer [size+100];
        Integer [] outime=new Integer [size+100];
        int counter=-1;
        TreeNode ParseNode=Head;
        cnsDfsHelper(s,intime,outime,visited,counter,ParseNode);
        if ((intime[n]<intime[n2] && outime[n]>outime[n2] )||( intime[n2]<intime[n] && outime[n2]>outime[n])){
            System.out.println("Same path");
        }

    }

//DFS algorithm
    public void cnsDfsHelper(Stack<Integer> s, Integer[] intime, Integer[] outime, boolean[] visited,int counter,TreeNode ParseNode) {

        while(s.size()!=0) {

            counter++;
            Integer vertice=s.peek();
            ParseNode=find(vertice);
            if(intime[vertice]==null) intime[vertice]=counter;
            visited[vertice]=true;


            if(ParseNode.left!=null && visited[ParseNode.left.Val]==false ) {
                s.push(ParseNode.left.Val);
                cnsDfsHelper(s,intime,outime,visited,counter,ParseNode.left);
            }

            if(ParseNode.right!=null &&visited[ParseNode.right.Val]==false ) {
                s.push(ParseNode.right.Val);
                cnsDfsHelper(s,intime,outime,visited,counter,ParseNode.right);
            }
            if(s.size()==0)return;

            Integer outvertice=s.pop();
            if(outime[vertice]==null) outime[outvertice]=counter;

        }


    }
    
    //recursive DFS algorithm

    public void DFS() {
        boolean [] visited =new boolean[1000];
        Stack<Integer> s=new Stack();
        s.push(Head.Val);
        DFShelper(Head,visited,s);


    }

    private void DFShelper(TreeNode ParseNode, boolean[] visited, Stack<Integer> s) {
        while(s.size()!=0) {
            int vertice=s.peek();
            visited[vertice]=true;
            if(ParseNode.left!=null && visited[ParseNode.left.Val]!=true) {
                s.push(ParseNode.left.Val);
                DFShelper(ParseNode.left,visited,s);
            }

            if(ParseNode.right!=null && visited[ParseNode.right.Val]!=true) {
                s.push(ParseNode.right.Val);
                DFShelper(ParseNode.right,visited,s);
            }
            if(s.size()!=0)
                System.out.println("Popped:"+s.pop());

        }

    }
//sum of nodes on same level
    public void LevelSum()
    {
        int sumOfLevel=Head.Val;

        Queue<Integer> q=new LinkedList();
        int [] sums=new int[100];
        for(int i=0;i<100;i++) sums[i]=0;

        int counter=0;
        MinLevelHelper(Head,counter,sums);
        for(int i=0;i<size;i++)
            System.out.println("Level :"+i+" sum:" +sums[i]);

    }

    private void MinLevelHelper(TreeNode ParseNode, int counter, int[] sums) {
        if(ParseNode==null) return;

        {
            sums[counter]+=ParseNode.Val;
            counter++;
            if(ParseNode.left!=null) {
                MinLevelHelper(ParseNode.left,counter,sums);

            }
            if(ParseNode.right!=null) {
                MinLevelHelper(ParseNode.right,counter,sums);
            }


        }


    }

//BFS algorithm
    public void BFS() {
        Queue<Integer> q=new LinkedList();
        boolean [] visited=new boolean[100];
        TreeNode ParseNode=Head;
        q.add(Head.Val);
        BFSHelper(ParseNode,visited,q);



    }

    private void BFSHelper(TreeNode ParseNode, boolean[] visited, Queue<Integer> q) {
        if (q.size()==0) return;

        visited[ParseNode.Val]=true;

        if(ParseNode.left!=null && visited[ParseNode.left.Val]!=true) {
            q.add(ParseNode.left.Val);
        }
        if(ParseNode.right!=null && visited[ParseNode.right.Val]!=true) {
            q.add(ParseNode.right.Val);
        }

        if(ParseNode.left!=null && visited[ParseNode.left.Val]!=true)
            BFSHelper(ParseNode.left,visited,q);
        if(ParseNode.right!=null && visited[ParseNode.right.Val]!=true)
            BFSHelper(ParseNode.right,visited,q);


        System.out.println("popped: "+q.poll());

    }

    public void BFSMaxLevel() {


        TreeNode ParseNode=Head;
        int MaxSum=0;
        int localSum=0;
        Queue<TreeNode> q=new LinkedList();
        q.add(ParseNode);
        q.add(null);
        while(q.size()!=0) {
            if(q.peek()==null)break;

            while(true) {

                TreeNode AddedNode = q.poll();
                if (AddedNode==null)break;
                localSum=localSum+AddedNode.Val;
                if(AddedNode.left!=null) q.add(AddedNode.left);
                if(AddedNode.right!=null) q.add(AddedNode.right);

            }

            System.out.println("Level sum: "+localSum);
            if(localSum>MaxSum) MaxSum=localSum;
            q.add(null);
            localSum=0;
            //q.poll();




        }




    }



}