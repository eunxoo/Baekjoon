first = int(input())
num = first
cnt = 0

while True :
    a = num // 10
    b = num % 10
    c = (a+b) % 10
    num = (b * 10) + c

    cnt += 1
    if(num == first) :
        break
print(cnt)