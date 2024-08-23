class Solution:
    def fractionAddition(self, e: str) -> str:
        fList = []
        st = 0
        idx = st + (2 if e[0] == '-' else 1)
        while idx <= len(e):
            if idx == len(e):
                fList.append(e[st:idx])
                break
            if e[idx] == '+' or e[idx] == '-':
                fList.append(e[st:idx])
                st = idx
            idx += 1

        def gcd(lhs, rhs):
            if lhs % rhs == 0: return rhs
            if lhs == 1: return 1
            return gcd(rhs, lhs % rhs)
        
        def lcm(lhs, rhs):
            return int(lhs * rhs / gcd(lhs, rhs))

        for i in range(1, len(fList)):
            lC, lP = map(int, fList[i - 1].split('/'))
            rC, rP = map(int, fList[i].split('/'))
            nP = lcm(lP, rP)
            nLC = lC * int(nP / lP)
            nRC = rC * int(nP / rP)

            if nLC + nRC != 0:
                fList[i] = str(nLC + nRC) + '/' + str(nP)
            else:
                fList[i] = '0/1'
        
        c, p = map(int, fList[-1].split('/'))
        np = gcd(c, p)
        return ("{}/{}".format(c//np, p//np))


