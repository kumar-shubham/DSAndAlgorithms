package com.my.test1;


public class SumSegmentTree {

	public int[] createTree(int input[]) {
		int height = (int) Math.ceil(Math.log(input.length) / Math.log(2));
		int segmentTree[] = new int[(int) (Math.pow(2, height + 1) - 1)];
		constructTree(segmentTree, input, 0, input.length - 1, 0);
		return segmentTree;
	}

	private void constructTree(int[] segmentTree, int[] input, int low, int high, int pos) {
		
		if(low == high){
            segmentTree[pos] = input[low];
            return;
        }
        int mid = (low + high)/2;
        constructTree(segmentTree,input,low,mid,2*pos+1);
        constructTree(segmentTree,input,mid+1,high,2*pos+2);
        segmentTree[pos] = segmentTree[2*pos+1] + segmentTree[2*pos+2];
        
	}
	
	public int rangeQuery(int[] segmentTree, int qlow, int qhigh, int len) {
		return rangeQuery(segmentTree, 0, len-1, qlow, qhigh, 0);
	}

	private int rangeQuery(int[] segmentTree, int low, int high, int qlow, int qhigh, int pos) {
		
		if(low >= qlow && high <= qhigh) {
			return segmentTree[pos];
		}
		if(qlow > high || qhigh < low){
            return 0;
        }
		
		int mid = (low + high)/2;
		
		return rangeQuery(segmentTree, low, mid, qlow, qhigh, 2*pos +1) +
				rangeQuery(segmentTree, mid+1, high, qlow, qhigh, 2*pos+2);
	}
	
	public void updateValueForSumOperation(int input[],int segmentTree[],int newVal,int index){
        int diff = newVal - input[index];
        input[index] = newVal;
        updateVal(segmentTree,0,input.length-1,diff,index,0);
    }
    
    private void updateVal(int segmentTree[],int low,int high,int diff,int index, int pos){
        if(index < low || index > high){
            return;
        }
        segmentTree[pos] += diff;
        if(low >= high){
            return;
        }
        int mid = (low + high)/2;
        updateVal(segmentTree,low,mid,diff,index,2*pos+1);
        updateVal(segmentTree,mid+1,high,diff,index,2*pos+2);
    }

}
