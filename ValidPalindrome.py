'''

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:

Input: "race a car"
Output: false

 

Constraints:

    s consists only of printable ASCII characters.



'''

class Solution:

    def isPalindrome(self, s):
        if not s:
            return True

        i = 0
        j = len(s) - 1
        if j == -1:
            return False

        while i < j:
            if self.isAlphaNumeric(s[i]):
                if self.isAlphaNumeric(s[j]):
                    if s[i].lower() == s[j].lower():
                        i += 1
                        j -= 1
                    else:
                        return False
                else:
                    j -= 1
            else:
                i += 1
        return True

    def isAlphaNumeric(self, s):
        if s >= 'a' and s <= 'z' or s >= 'A' and s <= 'Z' or s >= '0' \
            and s <= '9':
            return True
        else:
            return False