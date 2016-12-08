# Regular Expression Matching 
# '*' Matches zero or more of the preceding element
# References:- http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
def isMatch(s1,s2):
    
    if s1 == '' or s2 == '':
        return False
    if s1 == s2 or s2=='*':
        return True
    if s1[0] == s2[0]:
        return isMatch(s1[1:],s2[1:])
    if s2[0] == '*':
        return isMatch(s1,s2[1:]) or isMatch(s1[1:],s2)
    if len(s2) == 1 or s2[1] != '*':
        if (len(s1) < 1 or (s1[0] != s2[0])):
            return False
        return isMatch(s1[1:],s2[1:])
    elif s2[1] == '*':
        return isMatch(s1,s2[2:])
    else: 
        return False
    
print isMatch("aa","a")
print isMatch("aa","aa")
print isMatch("aaa","aa")
print isMatch("aa", "a*")
print isMatch("aa", "*")
print isMatch("ab", "*")
print isMatch("aab", "c*a*b")
print isMatch("cccccaab","c*a*b")
