n, k = map(int, input().split())
pascal = [[1],[1,1]]

for i in range(2,30):
    m = [1]
    for j in range(1,i):
        m.append(pascal[i-1][j] + pascal[i-1][j-1])
    m.append(1)
    pascal.append(m)

print(pascal[n-1][k-1])