class Solution {
    public int search(int[] arr, int target) {
        return BinaryRecursion(arr,0,arr.length-1,target);
    }
    public int BinaryRecursion(int[] arr,int low,int high,int target){
        if(low>high){
            return -1;
        }

        int mid=(low+high)/2;
        if(arr[mid]==target) return mid;
        if(target>arr[mid]){
            return BinaryRecursion(arr,mid+1,high,target);
        }
        return BinaryRecursion(arr,low,mid-1,target);
    }
}