class Solution {
    static class Pair{
        Pair(int key, int frequence){
            this.key = key;
            this.frequence = frequence;
        }

        int key;
        int frequence;
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequence = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            frequence.put(nums[i], frequence.getOrDefault(nums[i], 0) + 1);
        }

        if (k == 1){
            Pair biggestFrequence = new Pair(0, -1);
            for (Map.Entry<Integer, Integer> entryList : frequence.entrySet()){
                if (biggestFrequence.frequence < entryList.getValue()){
                    biggestFrequence = new Pair(entryList.getKey(), entryList.getValue());
                }
            }

            return new int[]{biggestFrequence.key};
        }

        Pair[] frequenceList = new Pair[k];
        for (Map.Entry<Integer, Integer> entryList : frequence.entrySet()){
            int i = 0;

            while (i < k
                    && frequenceList[i] != null
                    && frequenceList[i].frequence >= entryList.getValue()){
                i++;
            }

            if (i == k){
                continue;
            }

            if (frequenceList[i] == null){
                frequenceList[i] = new Pair(entryList.getKey(), entryList.getValue());
                continue;
            }

            for (int j = k - 1; j > i; j--){
                frequenceList[j] = frequenceList[j - 1];
            }

            frequenceList[i] = new Pair(entryList.getKey(), entryList.getValue());
        }

        int[] result = new int[k];

        for (int i = 0; i < k; i++){
            result[i] = frequenceList[i].key;
        }

        return result;

    }
}
