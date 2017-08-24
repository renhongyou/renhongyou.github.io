# function

print(abs(100))
print(abs(-20))
print(abs(12.34))

# abs(1, 2) # error, need less parameters

# abs('a') # error, invalid parameter

print(max(1, 2))
print(max(2, 3, 1, -5))

# data type conversion

print(int('123'))
print(int(12.34))
print(float('12.34'))
print(str(1.23))
print(bool(1))
print(bool(''))

a = abs # a to abs
print(a(-1))

# Exercise

# 请利用Python内置的hex()函数把一个整数转换成十六进制表示的字符串：
n1 = 255
n2 = 1000

print(hex(n1))
print(hex(n2))