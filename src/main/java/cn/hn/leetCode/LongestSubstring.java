package cn.hn.leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: hn
 * @email : hn@runisys.com
 * @date : 18-9-26 下午6:26
 * @desc : TODO
 **/
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int num=0;//记录最长子串长度
        int current=0;//记录当前子串长度
        char[] arr=s.toCharArray();
        LinkedList<Character> temp=new LinkedList<>();

        for (int i=0;i<arr.length ;i++ )
        {
            if (!temp.contains(arr[i]))
            {
                temp.add(arr[i]);
                current=temp.size();
                if (current>num)
                    num=current;
            }
            else//如果新增字符与原子串中字符有重复的，删除原子串中重复字符及在它之前的字符，与新增字符组成新的子串
            {
                temp.add(arr[i]);
                int first=temp.indexOf(arr[i]);

                for (int j=0;j<first ;j++ )
                    temp.remove();

                temp.remove();
            }
        }
        return num;
    }


    public int lengthOfLongestSubstring2(String s) {
        // write your code here
        if(s.length()==0){
            return 0;
        }
        int maxLength=1;
        List<Character> list=new ArrayList<Character>();
        list.add(s.charAt(0));
        for(int i=1;i<s.length();i++){
            if(list.contains(s.charAt(i))){
                int index=list.indexOf(s.charAt(i));
                list=list.subList(index+1, list.size());
                list.add(s.charAt(i));
//				System.out.println(list);
                maxLength=Math.max(maxLength, list.size());
            }else{
                list.add(s.charAt(i));
                maxLength=Math.max(maxLength, list.size());
            }
        }
        return maxLength;
    }



    public static void main(String[] args) {
        LongestSubstring s = new LongestSubstring();
        s.lengthOfLongestSubstring("qweqweqweqweqwerq");
        s.lengthOfLongestSubstring2("qweqweqweqweqwerq");
    }
}
