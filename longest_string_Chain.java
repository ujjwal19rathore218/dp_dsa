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
    if(a.length() - b.length() !=1) return false;//ab yaha par length ka check karna isiliye tha kyuki exactly ek hi character ka difference hona chahiye
    int i=0,j=0;
    boolean skipped = false;//skip ka concept hai ki ek baar hi character ko skip karna hai
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
    for(int[] row:dp){//here we are initializing the dp array with -1 ek poore row ko -1 se fill karna hai
        Arrays.fill(row, -1);
    }
    return solve(words,0,-1,dp);
}