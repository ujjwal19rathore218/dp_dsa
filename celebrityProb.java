class Solution {
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int[] ind = new int[n];
        Arrays.fill(ind,1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(mat[i][j]==1 && mat[j][i]!=1){
                        ind[j]++;
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            if(ind[i]==n){
                return i;//ek hi celebrity exists krega tabhi sahi hoga 
            }
        }
        return -1;
        
    }
}
//O(n) approach

class Solution {
    public int celebrity(int mat[][]) {
        // code here
        //two pointer approach
        int n = mat.length;
        int i =0;int j=n-1;
        while(i<j){
            if(mat[i][j]==1){
                i++;//because i is not a celebrity
            }
            else if(mat[i][j]==0){
                j--;
            }
        }//verification
        int candidate = i;
        for(int k=0;k<n;k++){
            if(k!=candidate){
                if(mat[k][candidate]==0 || mat[candidate][k]==1){//candidate row has all 0 othher than itself
                    return -1;
                }
            }
        }
        return candidate;
    }
}