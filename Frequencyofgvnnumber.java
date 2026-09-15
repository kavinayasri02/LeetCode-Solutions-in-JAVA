package FrequencyorCounting;
import java.util.*;
public class Frequencyofgvnnumber {
    public static void main(String[]args){
        Scanner kavi = new Scanner(System.in);
        int k = kavi.nextInt();
        int[] arr = new int[k];
        for(int i = 0; i < k; i++){
            arr[i] = kavi.nextInt();
        }
        int target = kavi.nextInt();
        int count = 0;
        for(int i = 0; i < k; i++){
            if(arr[i] == target){
                count++;
            }
        }
        System.out.println("The frequency of " + target + " is: " + count);
    }
    
}
