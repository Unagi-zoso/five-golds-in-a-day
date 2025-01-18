class Solution:
    def numberOfSteps(self, num: int) -> int:
        cnt = 0
        while num != 0:
            cnt += 1
            if num % 2 == 0:
                num //= 2
            else:
                num -= 1
        return cnt

# 시간복잡도 O(N) 이 되려면 전부 1로 빼버리는 수 밖에 없는데
# 양,음수는 절반씩 존재하니 2씩 나누는 행위를 무시하기 힘들다.
# O(log(n)) 으로 보는게 좋을 듯 하다.

# 공간복잡도 O(1)

# 횟수 최소화 문제가 있었던거 같은데.. 뭐였지..


class Solution:
    def numberOfSteps(self, num: int) -> int:
        if num == 0: return 0
        return num.bit_length() - 1 + num.bit_count()

# 재밌는 코드다.문제의 원리를 따져보면 비트의 관점으로 봤을 떄
# lesser bit 가 1일 경우 1을 차감하고, lesser bit 가 0일 경우 right shift 를 한다.
# bit length - 1 만큼 right shift 가 일어나고 1의 수만큼 subtract 가 일어나는 것이다.

# 이 때의 시간복잡도는 O(1), 공간복잡도는 O(1) 으로 작성자가 주장하는데
# 또 다른 의견으로는 num.bit_length() 가 비트의 사이즈를 구하기 위해
# 선형적인 시간을 소요한다는 것이다.

# 이에 따른 다른 이의 주장은 num.bit_length 같은 연산은
# 하드웨어연산 수준에서 최적화가 잘되어 거의 하나의 명령어 처럼도 동작하고
# 그렇게 시간에 관계될만큼 연연할 요소가 아니라 주장한다.
# 네이티브 수준? 로우한 수준의 명령어라는 관점은 신기했다.
