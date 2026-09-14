class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> frequenceS = new HashMap<>(s.length());
        Map<Character, Integer> frequenceT = new HashMap<>(s.length());

        for (int i = 0; i < s.length(); i++) {
            frequenceS.merge(s.charAt(i), 1, Integer::sum);
            frequenceT.merge(t.charAt(i), 1, Integer::sum);
        }
        
        if (frequenceS.size() != frequenceT.size()){
            return false;
        }

        for (Map.Entry<Character, Integer> entries: frequenceS.entrySet()){
            if (!frequenceT.containsKey(entries.getKey())){
                return false;
            }

            if (!frequenceT.get(entries.getKey()).equals(entries.getValue())){
                return false;
            }
        }

        return true;
    }

}
