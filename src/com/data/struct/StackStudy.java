package com.data.struct;

import java.util.Stack;

public class StackStudy {

    private Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        StackStudy stackStudy = new StackStudy();
        boolean bool = stackStudy.isValid("{x[y(s)d]d}d");
        System.out.println(bool);
    }

    public boolean isValid(String s) {

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 左括号
            if(isLeftBracket(c)) {
                if(stack.isEmpty()) {
                    stack.push(c);
                }else {
                    if(c == '{') {
                        stack.push(c);
                    }else if(c == '[') {
                        char prev = stack.peek();
                        if(prev == '(') {
                            return false;
                        }
                        stack.push(c);
                    }else {
                        stack.push(c);
                    }
                }
            }else if(isRightBracket(c)) {
                if(stack.isEmpty()) {
                    return false;
                }else {
                    char prev = stack.peek();
                    if(customEquals(prev, c)) {
                        stack.pop();
                    }else {
                        return false;
                    }
                }            }
        }

        return stack.isEmpty();
    }

    private boolean customEquals(char prev, char c) {
        if(prev == '{' && c == '}') {
            return true;
        }else if(prev == '[' && c == ']') {
            return true;
        }else if(prev == '(' && c == ')') {
            return true;
        }
        return false;
    }

    public boolean isLeftBracket(char c) {
        return c == '{' ||
                c == '[' ||
                c == '(';
    }

    public boolean isRightBracket(char c) {
        return c == '}' ||
                c == ']' ||
                c == ')';
    }

}
