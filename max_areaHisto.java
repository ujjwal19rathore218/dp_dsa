class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea= 0;int n = heights.length;
        
        for(int i=0;i<n;i++){
            int count=0;int count1=0;
            for(int j=i;j<n;j++){
                if(heights[i] <= heights[j]){
                    count++;
                }
                else{
                    break;
                }
                
            }
            for(int j=i-1;j>=0;j--){
                if(heights[i] <= heights[j]){
                    count1++;
                }
                else{
                    break;
                }
              
            }
            int width = count + count1;
            int area = width * heights[i];

            
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
        
    }
}//Time complexity O(n^2)