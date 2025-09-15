class Solution {
    public int removeDuplicates(int[] nums) {
        int curr=0;
        List<Integer> list= new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            if(nums[curr]!=nums[i]){
                list.add(nums[curr]);
                curr=i;
            }
        }
        list.add(nums[curr]);
        for(int i=0;i<list.size();i++)
        {
            nums[i]=list.get(i);
        }
        return list.size();      
    }
}