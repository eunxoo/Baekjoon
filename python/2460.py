all = 0
maximum = 0

for _ in range(10) :
    out, into  = map(int, input().split())
    all += (into - out)
    maximum = max(all, maximum)

print(maximum)

    