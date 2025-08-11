//recur + memo approach
class Solution {
    int [] t = new int[100];
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<100;i++){
            t[i]=-1;
        }
        return Math.max(solve(nums,0,n-1),solve1(nums,1,n));
    }
    public int solve(int[] nums,int i,int n){
        if(i>n){
            return 0;
        }
        if(t[i]!= -1){
            return t[i];
        }
        int take = nums[i]+solve(nums,i+2,n);
        int not_take = solve(nums,i+1,n);
        return t[i] = Math.max(take, not_take);    
    }
    public int solve1(int[] nums,int i,int n){
        if(i>n){
            return 0;
        }
        if(t[i]!= -1){
            return t[i];
        }
        int take = nums[i]+solve1(nums,i+2,n);
        int not_take = solve1(nums,i+1,n);
        return t[i] = Math.max(take, not_take);    
    }
    
}
//constant 