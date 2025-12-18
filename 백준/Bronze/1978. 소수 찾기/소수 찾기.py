def is_prime(n):
    if n == 1:
        return False
    
    i = 2
    while i**2 <= n:
        if n % i == 0:
            return False
        i += 1
        
    return True


_ = input()
nums = map(int, input().split())

cnt = 0
for num in nums:
    if is_prime(num):
        cnt += 1

print(cnt)    
