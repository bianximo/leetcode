// Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
//
//
// Examples: 
// "123", 6 -> ["1+2+3", "1*2*3"] 
// "232", 8 -> ["2*3+2", "2+3*2"]
// "105", 5 -> ["1*0+5","10-5"]
// "00", 0 -> ["0+0", "0-0", "0*0"]
// "3456237490", 9191 -> []
//
//
// Credits:Special thanks to @davidtan1890 for adding this problem and creating all test cases.


public class Solution {
    List<String>list;
    public List<String> addOperators(String num, int target) {
        list = new ArrayList<>();
        if(num==null||num.length()==0)return list;
        recursion(num,"",target,0,0,0);
        return list;
    }
    public void recursion(String num,String path,int target,int index,long total,long last){
        int len = num.length();
        if(index==len&&total==target){
            list.add(path);
            return;
        }
        for(int i = index;i<len;i++){
           if(i!=index&&num.charAt(index)=='0')break;
           long now = Long.parseLong(num.substring(index,i+1));
           if(index==0)recursion(num,path+now,target,i+1,total+now,now);
           else{
                recursion(num,path+"+"+now,target,i+1,total+now,now);
                recursion(num,path+"-"+now,target,i+1,total-now,-now);
                recursion(num,path+"*"+now,target,i+1,total-last+last*now,last*now);
           }
        }
    }
}
