public class insertionsort {

    private static void sort(int[] arr){
        int l = arr.length;

        for(int i=1; i<l; i++){
            //current key
            int key = arr[i];
            int j=i-1;;

            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=key;
        }
        
        for(int a: arr){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,2,22,7,88,1,21,4,9,5,2};

        sort(arr);
    }
    
}
