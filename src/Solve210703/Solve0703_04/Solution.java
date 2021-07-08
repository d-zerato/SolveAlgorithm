package Solve210703.Solve0703_04;

public class Solution {
    //
    public int minPartitions(String n) {
        //
//        char maxChar = 0;
//
//        for (int idx = 0; idx < n.length(); idx++) {
//            //
//            maxChar = maxChar < n.charAt(idx) ? n.charAt(idx) : maxChar;
//        }
//
//        return Integer.parseInt(String.valueOf(maxChar));

        char maxChar = '0';
        int idx = 0;
        while(true) {
            maxChar = maxChar < n.charAt(idx) ? n.charAt(idx) : maxChar;
            idx++;

            if (idx >= n.length()) {
                break;
            }
        }

        return Integer.parseInt(String.valueOf(maxChar));
    }
}
