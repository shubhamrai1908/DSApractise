import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,6,3,2,3,7,5};
        System.out.println("Nums: "+ Arrays.toString(nums));
        System.out.println("Largest in Nums: "+findLargest(nums));
        System.out.println("Second Largest in Nums: "+findSecondLargest(nums));
    }
    public static int findLargest(int[] nums){
        int largest=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]>largest)
                largest=nums[i];
        }
        return largest;
    }
    public static int findSecondLargest(int[] nums){
        int largest=nums[0];
        int sLargest=-1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>largest){
                sLargest=largest;
                largest=nums[i];
            }
        }
        return sLargest;
    }
}