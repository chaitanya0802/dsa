public class PermutationsOfString {

    private static void solution(String str, String ans, int i){
        //base case
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        //non repeatable
        if(!ans.contains("a")) solution(str, ans+"a" , i+1);

        if(!ans.contains("b")) solution(str, ans+"b", i+1);

        if(!ans.contains("c")) solution(str, ans+"c", i+1);

        //repeatable characters
        // solution(str, ans+"a" , i+1);
        // solution(str, ans+"b" , i+1);
        // solution(str, ans+"c" , i+1);

    }

    public static void main(String[] args) {
        String str = "abc";

        solution(str, "", 0);
    }
}