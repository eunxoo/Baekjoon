num = int(input())
test_list = list(map(int, input().split()))
sum = 0
max_n = max(test_list)
for i in test_list:
    sum += i/max_n*100
print(sum/num)

# n = int(input())  # 과목 수
# test_list = list(map(int, input().split()))
# max_score = max(test_list)
#
# new_list = []
# for score in test_list :
#     new_list.append(score/max_score *100)  # 새로운 점수 생성
# test_avg = sum(new_list)/n
# print(test_avg)