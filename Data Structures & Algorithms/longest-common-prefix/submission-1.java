class Solution {
    static class TrieNode{
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    private TrieNode root = new TrieNode();

    private void insert(String word){
        TrieNode node = root;

        for (char c: word.toCharArray()){
            if (!node.children.containsKey(c)){
                node.children.put(c, new TrieNode());
            }

            node = node.children.get(c);
        }

        node.isEnd = true;
    }


    public String longestCommonPrefix(String[] strs) {
        for (String word : strs){
            insert(word);
        }

        StringBuilder builder = new StringBuilder();
        TrieNode node = root;

        while (node.children.size() == 1 && !node.isEnd){
            Map.Entry<Character, TrieNode> onlyChild =
                    node.children.entrySet().iterator().next();

            builder.append(onlyChild.getKey());

            node = onlyChild.getValue();

        }

        return builder.toString();
    }
}