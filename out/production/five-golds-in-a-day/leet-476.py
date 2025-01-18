class Solution:
    def findComplement(self, num: int) -> int:
        bin = []
        while num != 0:
            bin.append(num % 2)
            num = num // 2
            
        ans = 0
        for i in range(len(bin)):
            bin[i] = (bin[i] + 1) % 2
            if bin[i] == 1:
                ans += 2**(i)
        
        return ans
    
# bin 으로 문자형태의 이진값을 구할 수 있어. 시간 비용은 O(log(n)) 2씩 나눠나가니 맞는 말이네
class Solution:
    def findComplement(self, num: int) -> int:
        return num ^ ((1 << len(bin(num)[2:])) - 1)
# 전부 1 인 비트와 xor 하면 반전되잖아. 근데 그냥 Not 걸면 안돼? 정수형 32비트 전체가 반전되서 그런가?
# # 암튼 num 사이즈의 1 로 꽉찬 비트 덩어리를 구하기 위해 위의 식을 수행   
class Solution:
    def findComplement(self, num: int) -> int:
        return num ^ ((1 << num.bit_length()) - 1)
# 파이썬 정수형엔 bit_length() 라는 편리한 함수가?!

