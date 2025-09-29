class Solution {
    public int findMinArrowShots(int[][] points) {
        int n=points.length;
       Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0])); 

        int[] prev=points[0];
        int cnt=1;

        for(int i=1;i<n;i++){
            int currentstart=points[i][0];
            int currentend=points[i][1];

            int prevstart=prev[0];
            int prevend=prev[1];

            if(currentstart>prevend){
                cnt++;
                prev=points[i];
            }else{
                prev[0]=Math.max(currentstart,prevstart);
                prev[1]=Math.min(currentend,prevend);
            }
        }
        return cnt;
    }
}