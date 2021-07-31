num, k  = map(int, input().split())

a = 1
list =[]
while a <= num :
    if num % a == 0 :
        list.append(a)
    a += 1
if len(list) < k :
    print(0)
else :
    print(list[k-1])