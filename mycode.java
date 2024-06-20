class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n=nums.length,temp=0;
        int i=0,j=n-1;
        if(n==1){
            return nums;
        }
        int x=0,y=0;
       while(i<j){
            x=nums[i];
            y=nums[j];
            if(x%2!=0 && y%2==0){
                temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
                j--;
            }
            if(x%2!=0 && y%2!=0){
              j--;
            }
            if(x%2==0&& y%2!=0){
               i++;
               j--;
            }
            if(x%2==0 && y%2==0){
                i++;
            }
        }
        return nums;
    }
} 