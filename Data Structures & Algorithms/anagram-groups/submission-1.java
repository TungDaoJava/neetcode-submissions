class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> bucket = new HashMap<>();
        for (String str : strs){
            String sorted = sorted(str);
            if (bucket.containsKey(sorted)){
                bucket.get(sorted).add(str);
            } else {
                bucket.put(sorted, new ArrayList<>(List.of(str)));
            }
        }

        return bucket.values().stream().toList();
    }

    private String sorted(String input){
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
