package com.leetcode;

import java.io.*;
import java.util.*;

class CountWords {

  static String[][] wordCountEngine(String document) {
    //"STRING!".replaceAll("[^a-zA-Z]", "");
    document=document.toLowerCase().trim();
    TreeMap<Word,Word> map=new TreeMap<>();
    String[] docArr=document.split(" ");
    
    for(int i=0;i<docArr.length;i++){
      
      String w=docArr[i].trim().replaceAll("[^a-zA-Z]", "");
      Word obj=new Word(w,0,i);
      if(map.containsKey(w)){
        obj=map.get(w);
      }
      obj.count++;
      map.put(obj,obj);
    }
    String[][] result=new String[map.size()][2];
    int i=0;
    for(Word word : map.keySet()){
      Word val=map.get(word);
      result[i][0]=val.word;
      result[i][1]=String.valueOf(val.count);
      i++;
    }
 
    return result;
  }

  public static void main(String[] args) {

  }

}

class Word implements Comparable<Word>{
  String word;
  int count,pos;
  
  public Word(String wrd,int cnt,int p ){
    word=wrd;
    count=cnt;
    pos=p;
  }
  
  public int compareTo(Word o){
    if(count==o.count)
      return o.pos-pos;
    return o.count-count;
  }
  
 @Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return word.hashCode();
	}
  
  public boolean equals(Object obj ){
	if(obj instanceof Word){
		String wrd=((Word) obj).word;
		return word.equals(((Word)obj).word);
		}
	return false;
  }
}