// Compare two version numbers version1 and version2.
// If version1 &gt; version2 return 1, if version1 &lt; version2 return -1, otherwise return 0.
//
// You may assume that the version strings are non-empty and contain only digits and the . character.
// The . character does not represent a decimal point and is used to separate number sequences.
// For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
//
// Here is an example of version numbers ordering:
// 0.1 &lt; 1.1 &lt; 1.2 &lt; 13.37
//
// Credits:Special thanks to @ts for adding this problem and creating all test cases.


public class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1==null||version2==null||version1.equals("")||version2.equals(""))return 0;
        String []s1 = version1.split("\\.");
        String []s2 = version2.split("\\.");
        int[]v1 = new int[s1.length];
        int[]v2 = new int[s2.length];
        for(int i=0;i<s1.length;i++){
            v1[i] = Integer.valueOf(s1[i]);
        }
        for(int i=0;i<s2.length;i++){
            v2[i] = Integer.valueOf(s2[i]);
        }
        int num = s1.length<s2.length?s1.length:s2.length;
        for(int i=0;i<num;i++){
            if(v1[i]<v2[i])return -1;
            if(v1[i]>v2[i])return 1;
            
        }
        if(s1.length==s2.length)return 0;
        else {
            if(s1.length>s2.length){
                for(int i=s2.length;i<s1.length;i++){
                    if(v1[i]!=0)return 1;
                }
                return 0;
            }else{
                for(int i=s1.length;i<s2.length;i++){
                    if(v2[i]!=0)return -1;
                }
                return 0;
            }
        }
    }
}
