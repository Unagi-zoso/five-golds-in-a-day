class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        if len(s) == 0: return 0
        errorFlag = True
        for i in s:
            if '0' <= i <= '9': 
                errorFlag = False
                break
        if errorFlag: return 0
        if s[0] != '+' and s[0] != '-' and not '0' <= s[0] <= '9':
            errorFlag = True
        if errorFlag: return 0
        if (s[0] == '+' or s[0] == '-') and not '0' <= s[1] <= '9':
            errorFlag = True
        if errorFlag: return 0

        sign = 1
        numSt = 0
        numFlag = False
        numEnd = len(s)

        for i in range(len(s)):
            if not numFlag and '0' <= s[i] <= '9':
                numFlag = True
                numSt = i
                if i - 1 >= 0:
                    if s[i - 1] == '-': sign = -1
            if numFlag and not '0' <= s[i] <= '9':
                numEnd = i
                break
        
        temp = s[numSt: numEnd]
        
        if len(temp) < 10:
            return sign * int(temp)

        temp = temp.strip()

        zeroEnd = -1
        zeroFlag = False
        notZeroFlag = False
        for i in range(len(temp)):
            if not zeroFlag and temp[i] == '0':
                zeroFlag = True
                zeroEnd = i + 1
            if not zeroFlag and temp[i] != '0':
                notZeroFlag = True
                break
            if zeroFlag and temp[i] != '0':
                zeroEnd = i
                notZeroFlag = True
                break

        if zeroFlag:
            temp = temp[zeroEnd:]

        if zeroFlag and not notZeroFlag:
            return 0


        if len(temp) < 10:
            return sign * int(temp)
        if len(temp) > 10:
            if sign == 1:
                return sign * 2147483647
            else:
                return sign * 2147483648
        if sign == 1 and int(temp) >= 2147483647:
            return sign * 2147483647
        elif sign == -1 and int(temp) >= 2147483648:
            return sign * 2147483648
        else:
            return sign * int(temp)
            
class Solution:
    def myAtoi(self, s: str) -> int:
        state, sign, result = 1, 1, 0

        i = 0
        while i < len(s):
            c = s[i]
            print(state, c, i)
            if state == 1:
                if c == " ":
                    i += 1
                    continue
                elif c == "+":
                    state = 2
                elif c == "-":
                    state = 2
                    sign = -1
                elif "0" <= c <= "9":
                    state = 2
                    i -= 1
                else: 
                    return 0
            elif state == 2:
                if "0" <= c <= "9":
                    result = result * 10 + int(c)
                else:
                    print(state, c, i)
                    break
            i += 1

        result *= sign
        if result >= 2**31 - 1:
            return 2**31 - 1
        if result <= -(2**31):
            return -(2**31)
        return result


# 유한상태 오또마따~, 처리과정을 상태로 나눌 수 있다. 이 상태가 유한하다~
# 본격적으로 숫자를 만나기전 전처리 담당을 상태 1, 이후 숫자를 만나는게 상태 2
