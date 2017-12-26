import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;;

/*
 *Collection of Array releated algorithms
 * Frequently asked as Interview Questions
 *
 */

public class ArrayQuestions {


    /*
     * Find the Array that represents the union of 2 below arrays
     * @param arr
     * @param arr1
     *
     */

    public void unionOfArrays(int [] arr,int [] arr1) {
        int i=0;
        int j=0;

        while(i<arr.length && j<arr1.length) {

            if(arr[i]<arr1[j])i++;

            if(i>=arr.length)break;

            if(arr[i]>arr1[j])j++;

            if (arr[i]==arr1[j]) {
                System.out.println(arr[i]);
                i++;
                j++;
            }

        }
    }
    /*
     * Find the member of array that repeats twice
     * @param arr
     *
     *
     */


    public void FindOneRepeatedTwice(int [] arr) {

        int stoic=0;

        for(int i =0 ;i<arr.length;i++) {
            stoic=stoic^arr[i];
        }
        System.out.println(stoic);
    }

    /*
     * Find the two largest array members
     * @param arr
     *
     *
     */

    public void TwoLarges(int [] arr) {

        int a=Integer.MIN_VALUE;
        int b=Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++) {

            if(a<arr[i])a=arr[i];
            if(b<arr[i] && arr[i]<a) b=arr[i];

        }

        System.out.println(a+"  "+b);
    }

    /*
     * in the array that we know the number of members and
     * is increased by one find the one taht is missing
     * @param arr
     * @param TotalCount
     *
     */

    public void MissingNum(int [] arr,int TotalCount) {

        int Sum=TotalCount*((TotalCount+1)/2);
        int actualSum=0;

        for(int i:arr) {
            actualSum=actualSum+i;
        }

        System.out.println(Sum-actualSum);

    }


    /*
     * Find duplicates in array
     * @param arr
     *
     *
     */

    public void FindDuplicates(int [] arr) {

        Integer [] hash=new Integer[100];

        for (int i=0;i<100;i++) hash[i]=0;

        for (int i=0;i<arr.length;i++) {
            if (hash[arr[i]]==1) System.out.println(arr[i]);
            else hash[arr[i]]=1;

        }

    }

    /*
     * Find duplicates in array not using hash table
     * @param arr
     *
     *
     */

    public void FindDuplicatesNoHAsh(int [] arr) {
        Arrays.sort(arr);
        for(int i =0; i< arr.length-1;i++) {
            if (arr[i]==arr[i+1])System.out.println(arr[i]);
        }

    }

    /*
     * Find all pairs that by summing them we get the number passed to array
     * @param arr
     * @param num
     *
     */

    public void FindAllPairsThatSum(int [] arr,int num) {

        boolean [] hash=new boolean[100];

        for(int i=0;i<arr.length-1;i++) {
            hash[i]=true;
        }

        for(int i=0;i<arr.length-1;i++) {
            int diff=(num-arr[i]);
            if(hash[diff]!=false) {
                System.out.println(arr[i]+"+"+diff);
            }

        }


    }

    /*
     * remove duplicates using sort
     * @param arr
     *
     *
     */

    public void RemoveDuplicatesWithSort(int [] arr) {
        Arrays.sort(arr);

        int [] result=new int[arr.length];
        result[0]=arr[0];

        int reference=arr[0];
        int j=1;
        for(int i=1;i<arr.length;i++) {
            if(reference==arr[i]) i=i;
            else {
                result[j]=arr[i];
                j++;
                reference=arr[i];
            }

        }

        for (int i: result) {
            System.out.println(i);
        }

    }

    public void ArrangeNegatives(int [] arr){

        int j=arr.length-1;
        int border=0;

        for(int i=0;i<arr.length;i++) {
            if((i%2)==0 && arr[i]>0 ) {
                while(j>=0 && j>border ) {
                    if(arr[j]<0) {
                        i=border;
                        swap(i,j, arr);
                        j--;
                        break;
                    }
                    else j--;
                }

            }

        }

        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);

    }


    /*
     * helper function for swaping two indexes in array
     * @param arr
     * @param a
     * @param b
     */


    public void swap(int a,int b,int [] arr ) {
        int tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;


    }

    /*
     * find all  sequence that by summing it it produces 0
     * @param arr
     *
     *
     */

    public boolean ZeroSumSubarry(int [] arr) {
        HashMap<Integer, Integer> sums= new HashMap<Integer, Integer>();

        int sum =0;
        for(int i =0;i<= arr.length;i++) {
            sum=sum+arr[i];

            if(sums.containsKey(sum))
                return true;
            else
                sums.put(sum, i);
        }

        return false;


    }

    /*
     * Find maximum consequtive subbaray  that produces maximum value
     * @param arr
     *
     *
     */

    public void 	MaxConsectSum(int [] arr) {

        int max_ending_here=0;
        int max_ending_total=0;
        for(int i=0;i<=arr.length;i++) {
            if(max_ending_here<0)
                max_ending_here=0;
            else
                max_ending_here=max_ending_here+arr[i];
            if(max_ending_total<max_ending_here)
                max_ending_total=max_ending_here;


        }

    }
    /*
     * recursive implementation of binary search
     * @param arr
     *
     *
     */

    public boolean BinarySearch(int [] arr,int start,int end,int num) {

        if(start==end && arr[start]!=num ) return false;

        int median=(start+end)/2;

        if (arr[median]<num)
            return(BinarySearch(arr,median+1,end,num));

        if (arr[median]>num)
            return(BinarySearch(arr,start,median-1,num));
        else
            return true;

    }

    /*
     * swap two values in  without temp variable
     * @param x
     *@param y
     *
     */


    public void SwapWithoutTemp(int x,int y) {

        System.out.println("x = " + x + "y= "+ y);
        x=x+y;
        y=x-y;
        x=x-y;

        System.out.println("x = " + x + "y= "+ y);



    }

    /*
     * see if one string rotation of another
     * @param x
     *@param y
     *
     */

    public void SeeIfRotated(String a,String b) {
        String c = a+b;

        if(c.contains(a)) {
            System.out.println("True");
        }


    }


}


