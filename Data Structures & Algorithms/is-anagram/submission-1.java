class Solution {
    public boolean isAnagram(String s, String t) {
        int[] frequencyS =new int[26];
        int[] frequencyT =new int[26];
        if (s.length()!=t.length()){
            return false;
        }
        for (int i=0;i<s.length();i++){
            int m=s.charAt(i)-'a';
            int n=t.charAt(i)-'a';
            frequencyS[m]++;
            frequencyT[n]++;
        }
        if (!Arrays.equals(frequencyS, frequencyT)){
            return false;
        }
        return true;
    }
}
