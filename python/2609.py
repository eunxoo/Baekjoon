a, b = map(int, input().split())

def gcd(a, b):
    while b != 0:
        c = a % b
        a = b
        b = c    
    return a

def lcm(a, b):
    return a * b // gcd(a, b)

print(gcd(a, b))
print(lcm(a, b))
 