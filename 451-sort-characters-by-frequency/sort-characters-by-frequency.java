class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freqMap=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        int size=freqMap.size();
        Character[] chars=new Character[size];
     int index=0;
     for(char key:freqMap.keySet()){
        chars[index]=key;
        index++;
     }
     Arrays.sort(chars,(a,b)->freqMap.get(b)-freqMap.get(a));
     StringBuilder result=new StringBuilder();
     for(char ch:chars){
        int count=freqMap.get(ch);
        for(int j=0;j<count;j++){
            result.append(ch);
        }
     }
     return result.toString();
     }
    }
