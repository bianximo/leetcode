// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
//
// For example:
// Given "25525511135",
//
//
// return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


public class Solution {
    public List<String>list;
	    public List<String> restoreIpAddresses(String s) {
	        list = new ArrayList<>();
	        if(s==null||s.length()<4)return list;
	        getIp(s,0,4,"");
	        return list;
	    }
	    public void getIp(String s,int begin,int left,String before){
	        if(left<0)return;
	        if(left==0&&begin==s.length()){
	            list.add(before.substring(0,before.length()-1));
	        }
	        for(int i=1;i<=3;i++){
	            if(i+begin>s.length())break;
	            String temp = s.substring(begin,i+begin);
	            if(temp.startsWith("0")&&temp.length()>1||temp.length()==3&&Integer.parseInt(temp)>255)continue;
	            getIp(s,begin+i,left-1,before+temp+(left>0?".":""));
	        }
	    }
    
}
