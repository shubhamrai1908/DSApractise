import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



public class Main {
    public static void main(String[] args) {
        int[] nums = {1,4,6,3,2,3,7,5};
        int[] nums1 = {1,1,2,2,3,4,5,6,6,7};
        System.out.println("Nums: "+ Arrays.toString(nums));
        System.out.println("Nums1: "+ Arrays.toString(nums1));
        System.out.println("Largest in Nums: "+findLargest(nums));
        System.out.println("Second Largest in Nums: "+findSecondLargest(nums));
        System.out.println("Smallest in Nums: "+findSmallest(nums));
        System.out.println("Second Smallest in Nums: "+findSecondSmallest(nums));
        System.out.println("is Nums sorted? : "+isSorted(nums));
        System.out.println("is Nums1 sorted? : "+isSorted(nums1));
        System.out.println("Removed duplicates from sorted : "+ Arrays.toString(removeDuplicateFromSorted(nums1)));

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
            else if(nums[i]!=smallest&&nums[i]<sSmallest)
                sSmallest=nums[i];
        }
        return sSmallest;
    }
    public static boolean isSorted(int[] nums){
        for(int i=1;i< nums.length;i++){
            if(nums[i-1]>nums[i])
                return false;
        }
        return true;
    }
    public static int[] removeDuplicateFromSorted(int[] nums){
//        Set<Integer> set=new HashSet<>();
//        for(int i=0;i<nums.length;i++){
//            set.add(nums[i]);
//        }
//        System.out.println("Number of Unique elements: "+set.size());
//        return set.stream().mapToInt(Integer::intValue).toArray();
        int i=0;
        for(int j=1;j< nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        System.out.println("Number of Unique elements: "+(i+1));
        return nums;
    }
}