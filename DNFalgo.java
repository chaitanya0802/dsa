//dutch national flag algorithm

public class DNFalgo {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2 , 2};

        int c0 = 0, c1=0, c2=0;

        //count numbers of 0, 1, 2
        for(int a: arr){
            if(a==0){
                c0++;
            }
            else if(a==1){
                c1++;
            }
            else{
                c2++;
            }
        }

        //alter the array
        // Place all the 0s
        for (int i = 0; i < c0; i++)
            arr[i++] = 0;

        // Place all the 1s
        for (int i = 0; i < c1; i++)
            arr[i++] = 1;

        // Place all the 2s
        for (int i = 0; i < c2; i++)
            arr[i++] = 2;

        for(int a: arr){
            System.out.println(a);
        }
    }
}
