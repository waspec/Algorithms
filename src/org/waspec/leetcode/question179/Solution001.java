package org.waspec.leetcode.question179;

public class Solution001 {

    public static void main(String[] args) {
        Solution001 solution001 = new Solution001();
        int[] numbers = {0, 0};
        String result = solution001.largestNumber(numbers);
        System.out.println(result);
    }

    public String largestNumber(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strings[i] = String.valueOf(numbers[i]); // 或者Integer.toString(numbers[i])
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            for (int j = i + 1; j < strings.length; j++) {
                String leftRight = strings[i].concat(strings[j]);
                String rightLeft = strings[j].concat(strings[i]);
                if (leftRight.compareTo(rightLeft) < 0) { // 题眼
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
            }

            if (stringBuilder.length() == 0 && strings[i].equals("0")) { // 坑：又是String的==
                continue;
            } else {
                stringBuilder.append(strings[i]);
            }
        }

        String result = stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
        return result;
    }
}

/**
 * 1. 解这个题一开始的弯路：先想到把数字按长度对齐，然后用*补齐，再比大小。
 * 发现*的编码比0小，然后换成用A补齐。结果发现用A补齐可以对付3*>30的情况，但同时也3*>34（过分关注某一边界）
 * 又想到用末位数字补齐，比如3和344补成333和344，最后再去掉33，但写题的时候发现如果后面有133和233，那怎么办？
 * 总之这个题陷入了比较难思考清楚的境地。感觉更像是一道智力题。
 * 2. 思考难点在于：已经多位的数字不能被拆开
 * 3. 经过在纸上画，找到规律：（1）按开头数字分组（2）组内排序（3）用组里最大的数和后面的数字组成新数字、补齐、选最大的
 * 4. 最后看答案，发现这个题就（用排序）暴力破解……
 * 5.  if (stringBuilder.length() == 0 && strings[i] =="0") 这一句里有两个坑：（1）这样防止不了0成为开头，因为如果是["0","0"]的话，第2个0也进不来
 * （2）这里的==应该用.equals()代替
 * 6. 此题全价值比较高（1）排序的妙用（2）综合细节不少
 */
