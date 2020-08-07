'''

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


'''


class Solution:
    def detectCapitalUse(self, word: str) -> bool:
    	lower = 0;
    	upper = 0;

    	for i in word:
    		if(i.isupper()):
    			upper += 1;
    		if(i.islower()):
    			lower += 1;

    	if(upper == len(word) and lower == 0):
    		return True;
    	if(lower == len(word) and upper == 0):
    		return True;
    	if(word[0].isupper() and (lower+1) == len(word)):
    		return True;
    	return False;