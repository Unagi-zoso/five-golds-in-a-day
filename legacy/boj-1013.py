from sys import stdin
T = int(stdin.readline())

for _ in range(T):
    str = stdin.readline()
    idx = 0
    l_idx = len(str) - 2
    match_flag = True

    while idx <= l_idx and match_flag:
        if str[idx] == '0':
            idx += 1
            if idx > l_idx or str[idx] == '0':
                match_flag = False
                break
            idx += 1

        elif str[idx] == '1':
            idx += 1
            n1_idx = str.find('1', idx)
            if n1_idx == -1 or n1_idx - idx < 2 :
                match_flag = False
                break
            idx = n1_idx

            n0_idx = str.find('0', idx)
            if n0_idx == l_idx:
                match_flag = False
                break

            if n0_idx == -1:
                idx = l_idx + 1
                break

            idx = n0_idx
            if (str[idx + 1] == '0' and n0_idx - n1_idx > 1):
                idx -= 1

    print("YES") if match_flag == True else print("NO")
