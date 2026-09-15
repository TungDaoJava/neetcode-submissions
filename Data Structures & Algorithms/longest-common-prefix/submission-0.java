class Solution {
static class TrieNode{
        TrieNode[] children = new TrieNode[26];
        int childCount = 0;
        boolean isEnd = false;
    }

    private TrieNode root = new TrieNode();

    private void insert(String word){
        TrieNode node = root;

        for (char c: word.toCharArray()){
            int index = c - 'a';
            if (node.children[index] == null){
                node.children[index] = new TrieNode();
                node.childCount++;
            }

            node = node.children[index];
        }

        node.isEnd = true;
    }


    public String longestCommonPrefix(String[] strs) {
        for (String word : strs){
            insert(word);
        }

        StringBuilder builder = new StringBuilder();
        TrieNode node = root;

        while (node.childCount == 1 && !node.isEnd){
            for (int i = 0; i < 26; i++){
                if (node.children[i] != null){
                    builder.append((char) ('a' + i));
                    node = node.children[i];
                    break;
                }
            }
        }

        return builder.toString();
    }
}