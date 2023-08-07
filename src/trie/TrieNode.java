package trie;

/**
 * 트라이의 각 노드를 나타내는 클래스입니다.
 */
public class TrieNode {

    /**
     * children은 26개의 알파벳을 저장하는 자식 노드 배열입니다
     * isEndOfWord는 해당 노드에서 끝나는 단어가 있는지의 여부를 나타냅니다.
     */
    private TrieNode[] children;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode[] children) {
        this.children = children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
