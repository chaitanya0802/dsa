public class mergesort {

    //time complexity is O(n logn)
    //space complexity is O(n logn)

    static void sort(int[] arr, int l, int r) {
        if (l < r) {
            // middle
            int m = l + (r - l) / 2;

            // sort recursively
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // merge the sorted arrays
            merge(arr, l, m, r);
        }
    }

    static void merge(int[] arr, int l, int m, int r) {
        // size of both subarrays to merge
        int n1 = m - l + 1;
        int n2 = r - m;

        //create temp arrays
        int[] L = new int[n1];
        int[] R = new int[n2];

        //copy data to new arrays
        for(int i=0; i<n1; i++){
            L[i] = arr[l+i];
        }
        for(int j=0; j<n2; j++){
            R[j] = arr[m+1+j];
        }

        //add elements in arr by comparing 
        //index for 1st and 2nd array
        int i=0;
        int j=0;
        //index for arr
        int k = l;

        while(i<n1 && j<n2) {
            if(L[i] <=R[j]){
                arr[k]=L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 2, 22, 7, 88, 1, 21, 4, 9, 5, 2 };

        sort(arr, 0, arr.length-1);

        for(int a: arr){
            System.out.println(a);
        }
    }
}