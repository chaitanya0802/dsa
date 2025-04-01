class bubblesort{

    private static void bubbleSort(int[] arr){
        int l = arr.length;
        for(int i = 0; i < l - 1; i++){
            for(int j = 0; j < l-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        
        for(int a: arr){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,2,22,7,88,1,21,4,9,5,2};

        bubbleSort(arr);
        
    }

}