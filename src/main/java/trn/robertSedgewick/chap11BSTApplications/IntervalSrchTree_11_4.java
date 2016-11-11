package trn.robertSedgewick.chap11BSTApplications;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class IntervalSrchTree_11_4 {
	public static void main(String[] args){
		List<Integer[]> in=new ArrayList<Integer[]>();
		in.add(new Integer[]{17, 19});
		in.add(new Integer[]{5, 8});
		in.add(new Integer[]{21, 24});
		in.add(new Integer[]{4, 8});
		in.add(new Integer[]{15, 18});
		in.add(new Integer[]{7, 10});
		Collections.sort(in, new CustomComparator());
		
		Node root=balanceTree(in, 0, in.size()-1);
		System.out.println(root.data);
	}
	
	public static Node balanceTree(List<Integer[]> arr, int begin, int end){
		if(begin>end)
			return null;
		int mid=(begin+end)/2;
		Node n=new Node(arr.get(mid));
		n.left=balanceTree(arr, begin, mid-1);
		n.right=balanceTree(arr, mid+1, end);
		if(n.left!=null){
			if(n.left.max>=n.max)
				n.max=n.left.max;
		if(n.right!=null)
			if(n.right.max>=n.max)
				n.max=n.right.max;
		}
		return n;		
	}
}

class CustomComparator implements Comparator<Integer[]>{
	
	@Override
	public int compare(Integer[] a1, Integer[] a2){
		return Integer.compare(a1[0], a2[0]);
	}
}

class Node{
    Integer[] data;
    Node left;
    Node right;
    Integer max;
    public Node(Integer[] data){
          this.data = data;
          this.max=data[1];
          left = null;
          right = null;
    }
}
