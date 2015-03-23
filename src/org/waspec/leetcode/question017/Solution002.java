package org.waspec.leetcode.question017;

import java.util.*;

/**
 * Created by Timothy on 3/22/2015.
 */

// 7个月前自己写的一个算法……好长啊！显然那个时候算法能力还相当弱
public class Solution002 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, List<Character>> dic = this.getDictionary();
        char[] chars = digits.toCharArray();
        Queue<List<Character>> queue = new LinkedList<List<Character>>();
        queue.offer(new ArrayList<Character>());

        for (int i = 0; i < chars.length; i++) {

            // 如果没有把1(无对应字符)加进dic，则不必有这步判断
            if (dic.get(chars[i]).isEmpty()) {
                continue;
            }

            Queue<List<Character>> tempQueue = new LinkedList<List<Character>>();
            while (!queue.isEmpty()) {
                List<Character> head = queue.poll();
                for (Character c : dic.get(chars[i])) {
                    ArrayList<Character> newList = new ArrayList<Character>(head);
                    newList.add(c);
                    tempQueue.offer(newList);
                }
            }

            queue = tempQueue;
        }

        List<String> result = new ArrayList<String>();

        StringBuilder stringBuilder = null;
        for (List<Character> characters : queue) {
            stringBuilder = new StringBuilder();
            for (Character c : characters) {
                stringBuilder.append(c);
            }

            String str = stringBuilder.toString();
            result.add(str);
        }

        return result;
    }

    public HashMap<Character, List<Character>> getDictionary() {
        HashMap<Character, List<Character>> dic = new HashMap<Character, List<Character>>();
        for (int i = 0; i < 10; i++) {
            Character character = String.valueOf(i).charAt(0);
            ArrayList<Character> characters = new ArrayList<Character>();
            switch (i) {
                case 0:
                    characters.add(' ');
                    break;
                case 1:
                    break;
                case 2:
                    characters.add('a');
                    characters.add('b');
                    characters.add('c');
                    break;
                case 3:
                    characters.add('d');
                    characters.add('e');
                    characters.add('f');
                    break;
                case 4:
                    characters.add('g');
                    characters.add('h');
                    characters.add('i');
                    break;
                case 5:
                    characters.add('j');
                    characters.add('k');
                    characters.add('l');
                    break;
                case 6:
                    characters.add('m');
                    characters.add('n');
                    characters.add('o');
                    break;
                case 7:
                    characters.add('p');
                    characters.add('q');
                    characters.add('r');
                    characters.add('s');
                    break;
                case 8:
                    characters.add('t');
                    characters.add('u');
                    characters.add('v');
                    break;
                case 9:
                    characters.add('w');
                    characters.add('x');
                    characters.add('y');
                    characters.add('z');
                    break;
            }

            dic.put(character, characters);
        }

        return dic;
    }
}
