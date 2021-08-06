A, B = map(int, input().split())

arr = []
arr.append(0)
for i in range(46):
    for j in range(i):
        arr.append(i)

sum = 0
for i in range(A, B+1):
    sum += arr[i]
print(sum)