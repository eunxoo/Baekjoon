M = int(input())
N = int(input())
num = M
result = 0
arr = []
def prime(num):
    if num == 1:
        return False
    elif num == 2:
        return True
    for i in range(2, num):
        if num % i == 0:
            return False
    return True

while num <= N :
    if prime(num) :
        result += num
        arr.append(num)
    num +=1 
if result != 0:
    print(result)
    print(arr[0])
else :
    print(-1)