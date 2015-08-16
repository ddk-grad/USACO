package usaco.dhinesh.section1_2;

/*
ID: ddk
LANG:JAVA
TASK:namenum 
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class namenum {

    static char[][] NUMPAD= {{}, {}, {'A','B','C'}, {'D','E','F'},
                             {'G','H','I'}, {'J','K','L'}, {'M','N','O'}, {'P','R','S'},
                             {'T','U','V'}, {'W','X','Y'}};
    public static void main(String[] args) throws Exception{
	    String name = "namenum";
	    BufferedReader br = new BufferedReader(new FileReader(new File(name+".in")));
	    PrintWriter pw = new PrintWriter(new File(name+".out"));
	    Node dictionary = buildDictionary("dict.txt");
	    char[] digits = br.readLine().toCharArray();
	    
	    List<Pair<Node, String>> nameList = new ArrayList<Pair<Node, String>>();
	    nameList.add(new Pair<Node, String>(dictionary,""));
	    
	    for(int i=0; i < digits.length; i++) {
	        char[] chars = NUMPAD[digits[i]-'0'];
	        List<Pair<Node, String>> tempList = new ArrayList<Pair<Node, String>>();
	        for(int j=0; j<nameList.size();j++) {
	            Pair<Node, String> pair = nameList.get(j);
	            Node node = pair.getFirst();
	            for(int k=0; k<chars.length;k++) {
	                Node childNode = node.getChildren(chars[k]);
	                if(childNode != null) {
	                    tempList.add(new Pair<Node, String>(childNode, pair.getSecond()+chars[k]));
	                }
	            }
	        }
	        nameList = tempList;
	    }
	    
	    List<String> finalNames = new ArrayList<String>();
	    for(int i=0; i<nameList.size(); i++) {
	        Pair<Node, String> pair = nameList.get(i);
	        if(pair.getFirst().isWord) {
	            finalNames.add(pair.getSecond());
	        }
	    }
	    
	    if(finalNames.size() == 0) {
	        pw.println("NONE");
	    } else {
	        for(int i=0; i<finalNames.size(); i++) {
	            pw.println(finalNames.get(i));
	        }
	    }
	    
	    br.close();
	    pw.close();
	    
	}

	    
	
	private static Node buildDictionary(String fileName) throws Exception{
        Node dictionary = new Node('!');
        BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
        String word = null;
        while(( word = br.readLine()) != null) {
            Node temp = dictionary;
            char[] chars = word.toCharArray();
            for(int i=0; i < chars.length; i++) {
                temp = temp.addChildren(chars[i]);
            }
            temp.setWord(true);
        }
        br.close();
        return dictionary;
    }

	private static class Pair<T, Q> {
	    T t;
	    Q q;
	    
	    Pair(T t, Q q) {
	        this.t = t;
	        this.q = q;
	    }
	    
	    T getFirst() {
	        return t;
	    }
	    
	    Q getSecond() {
	        return q;
	    }
	}
    private static class Node {
	    final char letter;
	    final Node[] children;
	    boolean isWord;
	    
	    Node(char letter, boolean isWord) {
	        this.letter = letter;
	        children = new Node[26];
	        this.isWord = isWord;
	    }
	    
	    Node(char letter) {
	        this(letter, false);
	    }
	    
	    public void setWord(boolean isWord) {
            this.isWord = isWord;
        }

	    Node addChildren(char c) {
	        Node node = children[c-'A'];
	        if(node == null) {
	            node = new Node(c);
	            children[c-'A'] = node;
	        }
	        return node;
	    }
	    
	    Node getChildren(char c) {
	        return children[c-'A'];
	    }
	}

}
