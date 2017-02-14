// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//
// For example,
// If n = 4 and k = 2, a solution is:
//
//
//
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]


public class Solution {
    List<List<Integer>>list;
    public List<List<Integer>> combine(int n, int k) {
        list = new ArrayList<>();
        if(n<=0||k<=0||k>n)return list;
        List<Integer> temp = new ArrayList<>();
        combine(n,1,k,temp);
        return list;
    }
    public void combine(int n,int begin,int num,List<Integer>temp){
        if(num==0){
            list.add(new ArrayList<>(temp));
            return;
        }
        else if(begin>n){
            return;
        }
        temp.add(begin);
        combine(n,begin+1,num-1,temp);
        temp.remove(temp.size()-1);
        combine(n,begin+1,num,temp);
    }
}
