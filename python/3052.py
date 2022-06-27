num = []
for i in range(10):
    n = int(input())
    num.append(n%42)
num = set(num)
print(len(num))

# nums = set()  # 중복되는 요소를 제거
# for _ in range(10):
#     i = int(input())
#     nums.add(i%42)  # 집합자료형에 원소를 추가할 때 add 함수를 사용
#
# print(len(nums))