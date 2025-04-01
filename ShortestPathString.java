//give string of N,S,E,W
//to find the shortest distance from origin

//TC = O(n), n = number of chars
public class ShortestPathString {

    static void solution(String path){
        int x = 0;
        int y = 0;

        //travel
        for(int i = 0; i<path.length(); i++){

            if(path.charAt(i) == 'N'){
                y++;
            }

            else if(path.charAt(i) == 'S'){
                y--;
            }

            else if(path.charAt(i) == 'E'){
                x++;
            }

            else if(path.charAt(i) == 'W'){
                x--;
            }
        }

        //calculate distance
        double distance = Math.sqrt(((int)(Math.pow(x,2) + Math.pow(y,2))));
        System.out.println(distance);

    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";

        solution(path);
    }
}
