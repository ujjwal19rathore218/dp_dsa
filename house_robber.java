class Solution {//bottom up approach
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return 0;
        }
        int[] t = new int[n+1];
        t[0]=0;t[1]=nums[0];
        for(int i=2;i<=n;i++){
            int skip=t[i-1];
            int take=nums[i-1]+t[i-2];

            t[i] = Math.max(take,skip);
        }
        return t[n];
    }
}
//recur+memo approach
class Solution {
    int[] t = new int[100];
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0]; 
        }
        for(int i=0;i<100;i++){
            t[i]=-1;
        }   
        return solve(nums,0,n);

    }
    public int solve(int[] nums,int i,int n){
        if(i>=n){
            return 0;
        }
        if(t[i]!=-1){
            return t[i];
        }
        int skip=solve(nums,i+1,n);
        int take=nums[i]+solve(nums,i+2,n);
        t[i]=Math.max(skip,take);
        return t[i];
    }   
}
