import java.util.Arrays;

public class MergeSort {

	public void sort(int[] arr){
		mergeSort(arr, 0, arr.length-1);
	}
	
	public void mergeSort(int[] arr,int l,int r){
		if(l<r){
			int mid=(l+r)/2;
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			merge(arr,l,mid,r);
		}
	}

	private void merge(int[] arr, int l, int mid, int r) {
		int[] c=new int[r-l+1];
		int i=l,j=mid+1,k=0;
		while(k<c.length ){
			if(i<=mid && j<=r){
				if(arr[i]<=arr[j]){
					c[k]=arr[i];
					i++;
				}else{
					c[k]=arr[j];
					j++;
				}
			}else if(i<=mid){
				c[k]=arr[i];
				i++;
			}else{
				c[k]=arr[j];
				j++;
			}
			
			k++;
		}
		k=0;
		for(i=l;i<=r;i++){
			arr[i]=c[k];
			k++;
		}
		
	}
	
	public static void main(String[] args) {
		int[] arr={38, 27, 43, 3, 9, 82, 10};
		
		MergeSort obj=new MergeSort();
		obj.sort(arr);
		
		System.out.println(Arrays.toString(arr));
	}
	
}
