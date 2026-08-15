class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n=nums1.length;
        int q=queries.length;
        int[][]points=new int[n][2];
        for(int i=0;i<n;i++){
            points[i][0]=nums1[i];
            points[i][1]=nums2[i];
        }
        Arrays.sort(points,(a,b)->Integer.compare(b[0],a[0]));
        int[][]qs=new int[q][3];
        for(int i=0;i<q;i++){
            qs[i][0]=queries[i][0];
            qs[i][1]=queries[i][1];
            qs[i][2]=i;
        }
        Arrays.sort(qs,(a,b)->Integer.compare(b[0],a[0]));
        int[]ans=new int[q];
        Arrays.fill(ans,-1);
        ArrayList<Integer>values=new ArrayList<>();
        ArrayList<Integer>sums=new ArrayList<>();
        int j=0;
        for(int i=0;i<q;i++){
            int x=qs[i][0];
            int y=qs[i][1];
            while(j<n && points[j][0]>=x){
                int a=points[j][0];
                int b=points[j][1];
                int sum=a+b;
                while(!values.isEmpty()&& sums.get(sums.size()-1)<=sum){
                    values.remove(values.size()-1);
                    sums.remove(sums.size()-1);
                }
                if(values.isEmpty()|| b>values.get(values.size()-1)){
                    values.add(b);
                    sums.add(sum);
                }
                j++;
            }
            int left=0;
            int right=values.size()-1;
            int pos=-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(values.get(mid)>=y){
                    pos=mid;
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }
            if(pos!=-1)ans[qs[i][2]]=sums.get(pos);
        }
        return ans;
    }
}