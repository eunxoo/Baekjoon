a = [1,0]
b = [0,1]


n = int(input())

for i in range(2, n+1) :
    a_result = a[i-1] + a[i-2]
    b_result = b[i-1] + b[i-2]
    a.append(a_result)
    b.append(b_result)

print("{} {}" .format(a[n] ,b[n]))
