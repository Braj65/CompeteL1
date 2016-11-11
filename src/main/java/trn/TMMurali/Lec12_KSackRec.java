package trn.TMMurali;

public class Lec12_KSackRec {

	public static void main(String[] args) {
		Lec12_KSackRec k = new Lec12_KSackRec();
		int[] weight = {0, 1, 2, 5, 6, 7 };
		int[] val = {0, 1, 6, 18, 22, 28 };
		System.out.println(k.maxValStatWt(weight, val, 11, val.length-1));
		k.findOptJobs(weight, val, 11, val.length-1);
	}

	public int maxValStatWt(int[] weight, int[] val, int tarWt, int pos) {
		if (pos == 0) {
			return 0;
		} else if (weight[pos] > tarWt) {
			return maxValStatWt(weight, val, tarWt, pos - 1);
		} else {
			return max(
					val[pos]
							+ maxValStatWt(weight, val, tarWt - weight[pos],
									pos - 1),
					maxValStatWt(weight, val, tarWt, pos - 1));
		}
	}
	
	public void findOptJobs(int[] weight, int[] val, int tarWt, int pos){
		if(pos==0 || weight[pos]>tarWt)
			System.out.println();
		else if(val[pos]+maxValStatWt(weight, val, tarWt-weight[pos], pos-1)>maxValStatWt(weight, val, tarWt, pos-1)){
			System.out.println(pos);
			findOptJobs(weight, val, tarWt-weight[pos], pos-1);
		}else{
			findOptJobs(weight, val, tarWt, pos-1);
		}
	}

	public static int max(int a, int b) {
		return a > b ? a : b;
	}

}
