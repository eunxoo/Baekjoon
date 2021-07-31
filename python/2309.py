import random
a = 0
b = 0
total = 0
dw = list()

for _ in range(9) :
    n = int(input())
    dw.append(n)
    total += n

while True :
    a = random.choice(dw)
    b = random.choice(dw)
    if a+b == (total - 100) :
        dw.remove(a)
        dw.remove(b)
        dw.sort()
        for i in dw:
            print(i)
        break
    else :
        continue