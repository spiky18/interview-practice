package com.leetcode;

public class WordDictionary {
	TrieNode root;
	/** Initialize your data structure here. */
    public WordDictionary() {
    	root=new TrieNode();  
        
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode curr=root;
        for(int i=0;i<word.length();i++){
        	char ch=word.charAt(i);
        	if(curr.children[ch-'a']==null)
        		curr.children[ch-'a']=new TrieNode();
        	if(i==word.length()-1)
        		curr.children[ch-'a'].isCompleteword=true;
        	
        	curr=curr.children[ch-'a'];
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	
        return dfs(0, root, word);
    }
    
    
    public boolean dfs(int start,TrieNode curr,String word){
    	if(start==word.length()-1 && word.charAt(start)!='.'){
    		return curr.children[word.charAt(start)-'a']!=null && curr.children[word.charAt(start)-'a'].isCompleteword;
    	}
    	char ch=word.charAt(start);
    	if(ch!='.')
    		return curr.children[ch-'a'] !=null && dfs(start+1, curr.children[ch-'a'], word);
    	for (int i = 0; i < 26; i++) {
            if(start<word.length()-1){
                if(curr.children[i]!=null && dfs(start+1, curr.children[i], word))
                    return true;
            }else if(curr.children[i]!=null && curr.children[i].isCompleteword)
                return true;
                
				
		}
    	return false;
    }

}


	
	

