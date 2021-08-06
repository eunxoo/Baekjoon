t = int(input())
tt = t
i = 0
result = []
while t > 0 :
    arr = list(map(int, input().split()))
    arr.sort(reverse=True)
    result.append(arr)
    
    arr.clear
    t -= 1

while i < tt :
    print(result[i][2])
    i += 1
