
public class test {

    static void demo(int n){
        //base case
        if(n==1){
            System.out.println(n);
            return;
        }
        
        demo(n-1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 4, 3, 0, 5, 0 };

        int n = arr.length;

        demo(10);

    }
}