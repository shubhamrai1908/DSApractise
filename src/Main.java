import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,6,3,2,3,7,5};
        System.out.println("Nums: "+ Arrays.toString(nums));
        System.out.println("Largest in Nums: "+findLargest(nums));
        System.out.println("Second Largest in Nums: "+findSecondLargest(nums));
        System.out.println("Smallest in Nums: "+findSmallest(nums));
        System.out.println("Second Smallest in Nums: "+findSecondSmallest(nums));

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
            else if(nums[i]<largest && nums[i]>sLargest)
                sLargest=nums[i];
        }
        return sLargest;
    }
    public static int findSmallest(int[] nums){
        int smallest= Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(smallest>nums[i])
                smallest=nums[i];
        }
        return smallest;
    }
    public static int findSecondSmallest(int[] nums){
        int smallest = nums[0];
        int sSmallest = Integer.MAX_VALUE;
        for(int i=0;i< nums.length;i++){
            if(smallest>nums[i]){
                sSmallest=smallest;
                smallest=nums[i];
            }
            else if(nums[i]>smallest&&nums[i]<sSmallest)
                sSmallest=nums[i];
        }
        return sSmallest;
    }
}