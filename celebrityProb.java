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