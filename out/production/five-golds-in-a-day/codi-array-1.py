def solution(A, K):
    if len(A) == 0: return []
    # Implement your solution here
    for _ in range(K):
        c = A.pop()
        A = [c] + A
    return A
    pass
