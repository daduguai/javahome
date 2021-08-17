package leetcode;

/**
 * 学生出勤记录551
 * 给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
 * <p>
 * 'A'：Absent，缺勤
 * 'L'：Late，迟到
 * 'P'：Present，到场
 * 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：
 * <p>
 * 按 总出勤 计，学生缺勤（'A'）严格 少于两天。
 * 学生 不会 存在 连续 3 天或 3 天以上的迟到（'L'）记录。
 * 如果学生可以获得出勤奖励，返回 true ；否则，返回 false
 */
public class LeetCode551 {

    public static boolean checkRecord(String s) {
        boolean rs1=false,rs2=false;
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='A'){
                count++;
                if(count>=2){
                    return false;
                }
            }
        }

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                if((i+1)<s.length()&&(i+2)<s.length()){
                    if(s.charAt(i+1)=='L'&&s.charAt(i+2)=='L'){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
