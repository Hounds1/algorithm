package trie.basic;

import trie.TrieNode;

/**
 * 트라이 알고리즘은 특히 문자열 검색과 관련된 문제를
 * 해결하기 위해 사용되는 트리 자료 구조입니다.
 * 트라이는 각 노드가 문자 하나를 나타내며, 문자열을
 * 저장하고 검색하는데 효율적인 방법을 제공합니다.
 * 주로 사전 검색이나 문자열 패턴 매칭과 같은 문제에서
 * 활용됩니다.
 */
public class Trie {

    private final TrieNode root;

    /**
     * 트라이 자료구조를 초기화하는 생정자입니다.
     * root 노드를 생성하여 트라이의 시작점을 나타냅니다.
     */
    public Trie() {
        root = new TrieNode();
    }


    /**
     * 주어진 문자열을 트라이에 삽입하는 메소드입니다.
     * 각 문자마다 해당하는 인덱스를 계산하고, 해당 노드가
     * 없으면 새로운 노드를 생성하여 자식으로 추가합니다.
     * 문자열을 모두 삽입한 뒤에는 해당 노드를 마지막
     * 문자열의 끝을 나타내는 노드로 표시합니다.
     */
    public void insert(final String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                current.getChildren()[index] = new TrieNode();
            }
            current = current.getChildren()[index];
        }
        current.setEndOfWord(true);
    }


    /**
     * 주어진 문자열이 트라이에 존재하는지 검색하는 메소드입니다.
     * 문자열의 각 문자마다 해당 노드가 존재하지 않으면 해당
     * 문자열은 트라이에 없는 것으로 판단합니다.
     * 마지막 문자에 도달한 뒤 해당 노드의 'isEndOfWord' 값을
     * 반환하여 검색 결과를 나타냅니다.
     */
    public boolean search(final String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                return false;
            }
            current = current.getChildren()[index];
        }

        return current.isEndOfWord();
    }


    /**
     * 주어진 접두사로 시작하는 문자열이 트라이에 있는지
     * 검색하는 메소드입니다.
     * 검색과 유사하게 진행되며, 마지막에 도달하더라도
     * 'isEndOfWord' 값을 검사하지 않고 true를 반환합니다.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (current.getChildren()[index] == null) {
                return false;
            }
            current = current.getChildren()[index];
        }

        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
