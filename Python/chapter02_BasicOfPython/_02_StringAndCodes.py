# string in python
print('包含中文的str')

print(ord('A'))
print(ord('中'))
print(chr(66))
print(chr(25991))

print('\u4e2d\u6587')

print('ABC'.encode('ascii'))
print('中文'.encode('utf-8'))
# print('中文'.encode('ascii')) error

print(b'ABC'.decode('ascii'))
print(b'\xe4\xb8\xad\xe6\x96\x87'.decode('utf-8'))

print(len('ABC'))
print(len('中文'))

print(len(b'ABC'))
print(len(b'\xe4\xb8\xad\xe6\x96\x87'))
print(len('中文'.encode('utf-8')))

print('Hello, %s' % 'world')
print('Hi, %s, you have $%d' % ('Michael', 1000000))
'''
popular placeholder:
%d -> integer
%f -> float
%s -> string
%x -> hexinteger
'''

print('%2d-%02d' % (3, 1))
print('%.2f' % 3.1415926)

print('Age: %s. Gender: %s' % (25, True))

print('growth rate: %d %%' % 7)

# Exercise
# 小明的成绩从去年的72分提升到了今年的85分，请计算小明成绩提升的百分点，
# 并用字符串格式化显示出'xx.x%'，只保留小数点后1位：
s1 = 72
s2 = 85
r = (s2 - s1) / s1 * 100
print('%2.1f%%' % r)