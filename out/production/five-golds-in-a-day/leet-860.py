class Solution:
    def lemonadeChange(self, bills: List[int]) -> bool:
        account = [0, 0, 0]
        for b in bills:
            if b == 5:
                account[0] += 1
            elif b == 10:
                if account[0] >= 1:
                    account[0] -= 1
                    account[1] += 1
                else:
                    return False
            elif b == 20:
                if account[1] >= 1 and account[0] >= 1:
                    account[1] -= 1
                    account[0] -= 1
                elif account[0] >= 3:
                    account[0] -= 3
                else:
                    return False
                account[2] += 1

        return True