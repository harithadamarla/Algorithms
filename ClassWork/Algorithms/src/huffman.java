//Question: Calculate the frequency of each letter/symbol in the text.•Then,  create the Huffman Tree based on 32 characters (i.e.,  26 letters plusspace, period, comma, exclamation point, question mark, apostrophe – discardeverything  else.).  (If  you  want,  you  can choose  to  do 64  letters  to  supportmore symbols, or even do the full 128 letters of ASCII1, but this is optional.)•Make sure you can print out your code.  For example:e:  000a:  010f:  111 ...Discussion:Now you know how many bits are used by each alphabet/symbol inyour code.  Count the total number of bits required to encode your text using yourcode (i.e., the size of the text that uses your encoding).  Now count the number ofbits required for the same text if you use a 5-bit fixed length code2.  (Note:  If youused 64 characters, compare your code with a 6-bit fixed length code, and if youused 128, compare with a 7-bit fixed length code).•How many bits were you able to save?•How many characters did you choose to go with – 32, 64, or 128?
//input sciencestories.txt
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

@SuppressWarnings("unused")

class Node implements Comparable<Node>{
	char data;
	int freq;
	Node left,right;
	Node parent;
	
	Node(char data, int freq, Node left, Node right, Node parent)
	{
		this.data=data;
		this.freq=freq;
		this.left=left;
		this.right=right;
		this.parent=parent;
		
	}
	Node()
	{
		parent=null;
	}
	@Override
	public int compareTo(Node arg0) {
		// TODO Auto-generated method stub
		return this.freq-arg0.freq;
	}
	
}

class HuffmanTree{
	
	PriorityQueue<Node> hq= new PriorityQueue<Node>();
	
	
	Node root=new Node();
	
	int lensum=0;
	int origlen=0;
	
	HuffmanTree(Object[] chars, Object[] freq)
	{
		
		// iterate through all the elements and insert into the priority queue
			for(int i=0;i<freq.length;i++)
			{
				hq.offer(new Node((char)chars[i],(int)freq[i],null,null,null));
			}

		createTree(hq);
		
		printCodes(root,new StringBuffer());
		
		
		System.out.println("\nTotalCharactersUsed="+lensum);
		System.out.println("Ideally no. of characters required="+origlen);
		System.out.println("No. of characters saved="+(origlen-lensum));
		
	}
	
	private void createTree(PriorityQueue<Node> hq) {
		// TODO Auto-generated method stub
		// retrieve the first 2 elements from the priorty queue and create a new node with the freq equal to sum of freq of both
		while(hq.size()>1)
		{
			Node templ=hq.poll();
			Node tempr=hq.poll();
			Node parent=new Node('0',templ.freq+tempr.freq,templ,tempr,null);
			templ.parent=parent;
			tempr.parent=parent;
			
			hq.offer(parent);
			
		}
		//after the construction of the tree, assign the root node as the last node that was created in the above loop.
		this.root=hq.peek();
		
	}
	

	private void printCodes(Node root2, StringBuffer prefix) {
		// TODO Auto-generated method stub
		
		if(root2==null)
			return;
		if(root2.left==null && root2.right==null)
		{
			 System.out.println(root2.data + "\t" + root2.freq + "\t" + prefix);
			 
			 
			  lensum=lensum+(prefix.length()*root2.freq);
			  origlen=origlen+(root2.freq*5);
			  
		}
		
		else{
			Node temp=root2;
			
			prefix.append('0');
			printCodes(temp.left,prefix);
			prefix.deleteCharAt(prefix.length()-1);
			
			prefix.append('1');
			printCodes(temp.right,prefix);
			prefix.deleteCharAt(prefix.length()-1);
		}
		
	}

	
}


public class huffman {

	@SuppressWarnings("unchecked")
	
	public static void main(String[] args) throws IOException {

		String filename="supersciencestories.txt";
		String outputfile="output.txt";
		int count=0;
		

		File file = new File(filename);
		File file1= new File(outputfile);
		BufferedReader br=new BufferedReader(new FileReader(file));
		int c;
		HashMap<Character, Integer> hm=new HashMap<Character,Integer>();
		
//read through the characters in a file, push the characters into the hashmap and find the count, iff, the characters are in A-Z,a-z,'.',',','!','?',' '		
		while((c=br.read())>0)
		{
			char ch=(char)c;
			if((c>=65&&c<=90)||(c>=97&&c<=122)||c==39||ch=='.'||ch==','||ch=='!'||ch=='?'||c==' ')
			{
				if(Character.isUpperCase(ch))
				{
					ch=Character.toLowerCase(ch);
				}
				if(hm.containsKey(ch))
				{
					count=hm.get(ch);
					count++;
				}
				else
				{
					count=1;
				}
				hm.put(ch, count);
			}
		}
		br.close();
		
		Set<Entry<Character, Integer>> set=hm.entrySet();

		
		
		ArrayList<Character> characters=new ArrayList<Character>(hm.keySet());
		ArrayList<Integer> frequencies=new ArrayList<Integer>(hm.values());
		
		Object[] chars=characters.toArray();
		Object[] freq=frequencies.toArray();
		
	    
	    new HuffmanTree(chars,freq);
		
		
		
	}

		
}

	
	
	


