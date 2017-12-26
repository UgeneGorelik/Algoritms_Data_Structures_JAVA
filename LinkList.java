import java.util.Stack;


/*
 * Implementation of linked list Data structure 
 * and Several algorithms Using this data structure
 */


public class LinkList {

    public Node Head;
    Node left;

    public LinkList() {
        Head = null;

    }

    //insert at first place
    public void InsertFirst(String Val) {
        Node tnode=new Node(Val);

        if (Head == null) {
            Head =tnode;
        }

        else {
            tnode.next=Head;
            this.Head=tnode;
        }
    }
    
    //insert at end
    public void InsertLast(String Val) {
        Node tnode=new Node(Val);
        Node tmp=Head;

        while(tmp.next!=null) {
            tmp=tmp.next;
        }
        tmp.next=tnode;

    }
    
    //print the members of the list
    public void display() {
        Node tmp=Head;

        while(tmp!=null) {
            tmp.display();
            tmp=tmp.next;
        }
    }
//remove member
    public void remove(int pos) {
        Node cur=Head;

        for (int i=0;i<pos-1;i++) {
            cur=cur.next;
        }


        cur.next=cur.next.next;

    }
    
    //insert after certain member
    public void InsertAfter(String str,String Val) {
        Node cur=Head;
        Node newNode=new Node(Val);

        while(cur.Val!=str) {

            cur=cur.next;
        }
        newNode.next=cur.next;
        cur.next=newNode;


    }
//find the middle of the list
    public void findMiddle() {
        Node slowptr=Head;
        Node fastptr=Head;

        while(fastptr!=null) {
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }

        System.out.println("\n middle is");
        slowptr.display();


    }
//check if palindrome recursive
    public boolean IsPalindrome() {
        Node slowptr=Head;
        Node fastptr=Head;
        Stack<Node> st= new  Stack();

        while(fastptr!=null) {
            st.push(slowptr);
            slowptr=slowptr.next;
            fastptr=fastptr.next.next;
        }

        while(st.size()>0) {
            if (st.pop().Val!=slowptr.Val) {
                return false;

            }
            slowptr=slowptr.next;

        }
        return true;



    }

    boolean isPalindromeUtil(Node right)
    {
        left=Head;

        if(right==null)
            return true;
        boolean isp = (isPalindromeUtil(right.next));
        if(isp == false)
            return false;

        boolean isp1=(right.Val== left.Val);

        left= left.next;
        return isp1;

    }

    // A wrapper over isPalindromeUtil()
    boolean isPalindrome(Node head)
    {
        boolean result=isPalindromeUtil(head);
        return result;
    }



}






