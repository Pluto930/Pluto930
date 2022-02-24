找出数组中重复的数字。
在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。


class Solution {
    public int findRepeatNumber(int[] nums) {
        /*HashSet<Integer> set=new HashSet();     //暴力做法，直接set 然后add判断
        for(int num:nums){
            if(!set.add(num)){
                return num;
            }
        }
        return 0;*/

        int i=0;
        while(i<nums.length){     //将i值给到i位置，判断是否有与i位置值一样的  有就返回nums[i]。
            if(i==nums[i]){
                i++;
                continue;
            }

            if(nums[i]==nums[nums[i]]) return nums[i];
            int tmp=nums[i];
            nums[i]=nums[tmp];
            nums[tmp]=tmp;
        }
        return -1;
    }
}
