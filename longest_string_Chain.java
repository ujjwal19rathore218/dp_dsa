public int solve(String[] words,int i,int prev,int[][]dp){
    int  = words.length;

    if(i==n){
        return 0;
    }
    if(dp[i][prev +1]!=-1){
        return dp[i][prev+1];

    }
    if(prev == -1 || ispredessor(words[prev],words[i])){
         take = 1+solve(words,i+1,i,dp);    

    }
    int skip = solve(words,i+1,prev,dp);
    return dp[i][prev + 1] = Math.max(take, skip);
}

private boolean ispredessor(String a , String b){
    if(a.length() - b.length() !=1) return false;
    int i=0,j=0;
    boolean skipped = false;
    while(i <a.length() && j<b.length()){
        if(a.charAt(i) ==b.charAt(j)){
            i++;
        }else{
            if(skipped) return false;
            skipped = true;
        }
        j++;
    }
    return true;
}
public int longestStrChain(String [] words){
    int n= words.length;
    Arrays.sort(word,(a,b)-> a.length() - b.length());
    int[][] dp = new int[n][n+1];
    for(int[] row:dp){
        Arrays.fill(row, -1);
    }
    return solve(words,0,-1,dp);
}