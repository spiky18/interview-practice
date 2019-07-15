package com.leetcode;

public class Trie {
	TrieNode root;
	 /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
    	TrieNode curr=root;
        for(int i=0;i<word.length();i++){
        	char ch=word.charAt(i);
        	//TrieNode node=curr.children[ch-'a'];
        	if(curr.children[ch-'a']==null){
        		curr.children[ch-'a']=new TrieNode();
        		
        	}
        	if(i==word.length()-1)
        		curr.children[ch-'a'].isCompleteword=true;
        	curr=curr.children[ch-'a'];
        }
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
    	TrieNode curr=root;
        for(int i=0;i<word.length();i++){
        	char ch=word.charAt(i);
        	if(curr.children[ch-'a']==null)
    			return false;
        	if(i==word.length()-1 && !curr.children[ch-'a'].isCompleteword)
        		return false;
        	curr=curr.children[ch-'a'];
        }
        return true;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	TrieNode curr=root;
    	for(char ch : prefix.toCharArray()){
    		if(curr.children[ch-'a']==null)
    			return false;
    		curr=curr.children[ch-'a'];
    	}
    	return true;
    }

}

class TrieNode{
	TrieNode[] children;
	boolean isCompleteword;
	public TrieNode() {
		children=new TrieNode[26];
		isCompleteword=false;
	}
	
}
