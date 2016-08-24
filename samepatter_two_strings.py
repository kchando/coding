def samePattern(s1,s2):
    if s2 == "*" or s1 == s2: return True
    if s1 == "" or s2 == "": return False
    if s1[0] == s2[0]: return samePattern(s1[1:], s2[1:])
    if s2[0] == "*": return samePattern(s1, s2[1:]) or samePattern(s1[1:], s2)
    return False

print samePattern("aaab", "ab*")

