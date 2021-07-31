n = int(input())

ppap = list(input())
ppap.extend([0] * 1000000)
num , i = 0, 0

while(i < n) :
    if(ppap[i]) == 'p' and (ppap[i+1]) == 'P' and (ppap[i+2]) == 'A' and (ppap[i+3]) == 'p':
        ppap[i+3] = 0
        num += 1
    i+=1
        

print(num)