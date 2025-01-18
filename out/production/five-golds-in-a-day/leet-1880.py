class Solution:
    def isSumEqual(self, firstWord: str, secondWord: str, targetWord: str) -> bool:
        def conv(s):
            numstr = "".join(str(ord(c) - ord('a')) for c in s)
            return int(numstr)
        return conv(firstWord) + conv(secondWord) == conv(targetWord)
    