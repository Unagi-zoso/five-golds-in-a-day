class Solution:
    def shortestPalindrome(self, s: str) -> str:
        def computeFailureArray(pattern):
            combined = pattern + '*' + pattern[::-1]
            failureArray = [0] * len(combined) 
            j = 0
            for i in range(1, len(combined)):
                while j > 0 and combined[j] != combined[i]:
                    j = failureArray[j-1]
                if combined[j] == combined[i]:
                    j += 1
                    failureArray[i] = j
            return failureArray[-1]
        
        return s[computeFailureArray(s):][::-1] + s
    