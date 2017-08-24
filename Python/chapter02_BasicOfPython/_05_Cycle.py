# Cycle

# for

names = ['Michael', 'Bob', 'Tracy']
for name in names:
    print(name)

sum = 0
for x in [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]:
    sum = sum + x
print(sum)

print(list(range(5)))

sum = 0
for x in range(101):
    sum = sum + x
print(sum)

# while

sum = 0
n = 99
while n > 0:
    sum = sum + n
    n = n - 2
print(sum)

# break

n = 1
while n <= 100:
    if n > 10: # when n = 11, break
        break # break the cycle
    print(n)
    n = n + 1
print('END')

# continue

n = 0
while n < 10:
    n = n + 1
    if n % 2 == 0: # if n is an even, continue
        continue # continue to next cycle
    print(n)

# Exercise
# 请利用循环依次对list中的每个名字打印出Hello, xxx!

for name in names:
    print('Hello,', name)

n = 0
while n < len(names):
    print('Hello,', names[n])
    n = n + 1
