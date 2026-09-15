The idea of Trie submission is using a tree node to store the character order of each word.

A TrieNode in this case has 3 fields:

children: array of TrieNode that have the size of 26 (number of alphabet character)
childCount: number of children of the node
isEnd: to signal if any word end at this TrieNode

When insert a word to a TrieNode, travel char in the word's charArray. For each char, put it in the child node list of the TrieNode,then travel to the child node. When travel to the end of char Array, signal this is the end of the word with isEnd;

When computing the common prefix, travel from the root of TrieNode until either childCount > 1 or isEnd; then build the word and return
