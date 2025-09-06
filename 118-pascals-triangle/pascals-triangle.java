class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> mainlist=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    list.add(1);
                }
                else{
                    int temp=mainlist.get(i-1).get(j-1)+ mainlist.get(i-1).get(j);
                    list.add(temp);
                }
            }
            mainlist.add(list);
        }
        return mainlist;
    }

}