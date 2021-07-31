n = int(input())
fb = [0,1]

for i in range(2, n+1) :
    result = fb[i-1] + fb[i-2]
    fb.append(result)

print(fb[n])