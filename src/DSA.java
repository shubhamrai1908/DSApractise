import java.util.*;
public class DSA {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1, 2, 1, 5}));
        System.out.println(removeDuplicates(new int[]{1, 2, 3, 4, 4, 5}));
        System.out.println(findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,3},6)));
        System.out.println(Arrays.toString(twoSum2(new int[]{1,2,3},5)));
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));

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
    // 3. Find the Duplicate Number
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
    // 4. Two Sum - Unsorted Array
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i=0;i<nums.length;i++){
            int k=target-nums[i];
            if(map.containsKey(k)){
                res[0]=map.get(k);
                res[1]=i;
                return res;
            }else{
                map.put(nums[i],i);
            }
        }
        return res;
    }
    // 5. Two Sum - Sorted Array
    public static int[] twoSum2(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum==target){
                return new int[]{i+1,j+1};
            }
            if(sum<target){
                i++;
            }else{
                j--;
            }
        }
        return new int[0];

    }
    // 6. Find Pivot Index (Equilibrium Index)(left sum==right sum)
    public static int pivotIndex(int[] nums) {
        int total=0;
        for(int n:nums){
            total+=n;
        }
        int sum=0;
        for(int i=0;i<nums.length;i++){
            if(sum==total-nums[i]-sum)
                return i;
            sum+=nums[i];
        }
        return -1;

    }
}
