class Solution {
    static class Pair{
        int[] key;
        List<String> value;
    }
    
    private int[] frequencyCompute(String word){
        int[] frequency = new int[26];
        for (char c: word.toCharArray()){
            int index = c - 'a';
            frequency[index]++;
        }

        return frequency;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
                List<Pair> pairList = new ArrayList<>(strs.length);
        int[] firstFrequency = frequencyCompute(strs[0]);
        Pair firstPair = new Pair();
        firstPair.key = firstFrequency;
        firstPair.value = new ArrayList<>(List.of(strs[0]));
        pairList.add(firstPair);

        for (int i = 1; i < strs.length; i++){
            int[] frequency = frequencyCompute(strs[i]);
            boolean isAdd = false;
            for (Pair pair: pairList){
                if (Arrays.equals(pair.key, frequency)){
                    pair.value.add(strs[i]);
                    isAdd = true;
                    break;
                }
            }

            if (!isAdd){
                Pair newPair = new Pair();
                newPair.key = frequency;
                newPair.value = new ArrayList<>(List.of(strs[i]));
                pairList.add(newPair);
            }
        }

        List<List<String>> result = new ArrayList<>(pairList.size());
        for (Pair pair : pairList){
            result.add(pair.value);
        }

        return result;
    }
}
