s = sorted(list(input().upper()))
s.append('-')

mx_cnt = -1
mx_w = s[0]
cnt = 1
for cur in range(1, len(s)):
    prev = cur - 1
    if s[prev] == s[cur]:
        cnt += 1
    else:
        if cnt > mx_cnt:
            mx_cnt = cnt
            mx_w = s[prev]
        elif cnt == mx_cnt:
            mx_w = '?'
        cnt = 1
    prev = cur

print(mx_w)
