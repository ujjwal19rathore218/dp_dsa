class Solution {
    public int solve(String t1,String t2,int i,int j,Integer[][]dp){
        int n=t1.length();
        int m=t2.length();

        if(i==n||j==m){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        int take =0;
        if(t1.charAt(i)==t2.charAt(j)){
            take = 1+solve(t1,t2,i+1,j+1,dp);
        }
        int skip =solve(t1,t2,i+1,j,dp);
        int skip1 = solve(t1,t2,i,j+1,dp);
        return  dp[i][j] = Math.max(take,Math.max(skip,skip1));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length(),m=text2.length();

        Integer[][] dp = new Integer[n][m];
        return solve(text1,text2,0,0,dp);
   
         
        
    }
}//iska time complexity O(n*m) and space complexity O(n*m) hai
//so now we can use bottom to optimize the space complexity