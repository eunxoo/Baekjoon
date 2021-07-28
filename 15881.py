n = int(input())

ppap = list(input())

num , i = 0, 0

while(i < n) :
    if(ppap[i]) == 'p' and (ppap[i]) == 'P' and (ppap[i]) == 'A' and (ppap[i]) == 'p':
        num += 1
        i+=1
        ppap[i+3] = 0

print(num)