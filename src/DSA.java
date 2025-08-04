import java.util.*;
public class DSA {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 1, 5}));
        System.out.println(removeDuplicates(new int[]{1, 2, 3, 4, 4, 5}));
        System.out.println(findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));

    }
// 1. Contains Duplicate
    public static boolean containsDuplicate(int[] nums){
        Set<Integer> s = new HashSet<>();
        for(int n:nums){
            if(!s.add(n))
                return true;
        }
        return false;
    }
// 2. Remove Duplicates from Sorted Array
    public static int removeDuplicates(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: Find intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}
