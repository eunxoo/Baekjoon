num = []
for i in range(10):
    n = int(input())
    num.append(n%42)
num = set(num)
print(len(num))