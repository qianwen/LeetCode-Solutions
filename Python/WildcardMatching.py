# -*- coding: utf-8 -*-

##############################################
## Wildcard Matching
#'?' Matches any single character.
#'*' Matches any sequence of characters (including the empty sequence).
#The matching should cover the entire input string (not partial).
#The function prototype should be:
#bool isMatch(const char *s, const char *p)
#Some examples:
#isMatch('aa', 'a') → false
#isMatch('aa', 'aa') → true
#isMatch('aaa', 'aa') → false
#isMatch('aa', '*'') → true
#isMatch('aa', 'a*'') → true
#isMatch('ab', '?*'') → true
#isMatch('aab', 'c*a*b') → false
##############################################

class WildcardMatching:
    # @param s, an input string
    # @param p, a pattern string
    # @return a boolean
    def isMatch(self, s, p):
        pPosition = 0
        sPosition = 0
        lastP = -1
        lastS = -1
        
        while sPosition < len(s): 
            if pPosition < len(p) and (s[sPosition] == p[pPosition] or p[pPosition] == '?'):
                pPosition += 1
                sPosition += 1
            elif pPosition < len(p) and p[pPosition] == '*':
                pPosition += 1
                lastP = pPosition
                lastS = sPosition
            elif lastP != -1:
                lastS +=1
                pPosition = lastP
                sPosition = lastS   
            else:
                return False
        
        while pPosition < len(p) and p[pPosition] == '*':
            pPosition += 1
            
        return pPosition == len(p) and sPosition == len(s)  

def main():
    match = WildcardMatching();
    print(match.isMatch('aa', '*')) 

if __name__ == '__main__':
    main()