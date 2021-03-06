/*

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

 

Example 1:

Input: "USA"
Output: True

 

Example 2:

Input: "FlaG"
Output: False

 

Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.


*/


class Solution {
    public boolean detectCapitalUse(String word) {
        int lower = 0;
        int upper = 0;
        
        for(int i=0;i<word.length();i++){
            if(Character.isUpperCase(word.charAt(i))) {
                upper++;
            }
            if(Character.isLowerCase(word.charAt(i))) {
                lower++;
            }
        }
        if(upper == word.length() && lower == 0) {
            return true;
        } else if(lower == word.length() && upper == 0) {
            return true;
        } else if(Character.isUpperCase(word.charAt(0)) && (lower+1) == word.length()) {
            return true;
        }
        return false;
    }
}