case_num = int(input())
for _ in range(case_num):
    arr = list(map(int, input().split()))
    n = arr.pop(0)
    arr_avg = sum(arr) / n
    per = 0
    for score in arr:
        if score > arr_avg :
            per += 1
        percent = (per/n*100)
    print(f'{percent:.3f}%')
    #print("{:.3f}%".format(percent))