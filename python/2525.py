h, m = map(int, input().split())
p = int(input())
hp = (m+p) // 60
mp = (m+p) % 60
hresult = h + hp
if hresult > 23:
    hresult -= 24
print(hresult, mp)