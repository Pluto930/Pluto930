  //二分查找通用模板1  好理解 但 速度慢 
class Solution{
  public static int process(int[] nums){    //查找一个数
      if(nums.length==1) return nums[0]==0?1:0;
      if(nums[0]!=0) return 0;
        
      int l=-1,r=nums.length;
      int mid;
      while(l+1!=r){
          mid=l+(r-l)/2;
          if(nums[mid]==mid){
              l=mid;
          }else{
              r=mid;
          }
      }
      return r;
  }
}


