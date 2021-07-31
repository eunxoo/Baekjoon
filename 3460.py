t = int(input())

for _ in range(t):
    a = 0
    n = int(input())
    while (n>= 1) :
        if n%2 == 1 :
            print(a, end = " ")
        n = n //2
        a += 1
    print("")

