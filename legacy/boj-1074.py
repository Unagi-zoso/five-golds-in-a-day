N, r, c = map(int, input().split())                     #   1  :   2
ans = 0                                                 #      :    
                                                        # --------------
def quarter_divide_search(len_edge, r, c):              #   3  :   4 
    global ans                                          #      :

    len_edge = int(len_edge)      
    new_len_edge = int(len_edge/2)
    quarter_area = (int(len_edge/2))**2

    if 1 == len_edge:
        return   

    if r < (len_edge/2):                                
        if c < (len_edge/2): # ... 1                    
            quarter_divide_search(new_len_edge, r, c)
        else:                # ... 2
            ans += quarter_area
            quarter_divide_search(new_len_edge, r, c - new_len_edge)
    else:
        if c < (len_edge/2): # ... 3
            ans += (quarter_area * 2)
            quarter_divide_search(new_len_edge, r - new_len_edge, c)
        else:                # ... 4
            ans += (quarter_area * 3)
            quarter_divide_search(new_len_edge, r - new_len_edge, c - new_len_edge)
    

quarter_divide_search(2**N, r, c)

print(ans)

