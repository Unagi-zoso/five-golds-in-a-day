
from itertools import product

def solution(users, emoticons):
    discount_rates = [10, 20, 30, 40]
    ans = (-1, -1)
    rate_li = list(product(discount_rates, repeat=len(emoticons)))

    for rates in rate_li:
        num_sub, amount = 0,0
        for agree_rate, over_critic in users:
            c_sum = 0
            for emo_id in range(len(emoticons)):
                if agree_rate > rates[emo_id]:
                    continue
                c_sum += emoticons[emo_id] - int(emoticons[emo_id] / 100) * rates[emo_id]
            if c_sum >= over_critic:
                
                num_sub += 1
            elif c_sum < over_critic:
                amount += c_sum
        ans = max(ans, (num_sub, amount), key=lambda x: (x[0], x[1]))
    return ans
