public class findsubstring {

    //total 2^n substrings -  including null string

    private static void solution(String str, String ans, int i){
        //base case
        if(i == str.length()){
            System.out.println(ans);
            return;
        }

        //yes choice, include
        solution(str, ans+str.charAt(i) , i+1);

        //no choice, not include
        solution(str, ans, i+1);

    }

    public static void main(String[] args) {
        String str = "abc";

        solution(str, "", 0);
    }
    
}
