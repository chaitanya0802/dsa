public class selectionsort {
    public static void main(String[] args) {
        int[] arr = {4,5,6,2,22,7,88,1,21,4,9,5,2};

        int l = arr.length;

        for(int i = 0; i < l-1; i++){
            for(int j=i+1; j<l; j++){
                //swap if
                if(arr[i] > arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for(int a: arr){
            System.out.println(a);
        }
    }
}
