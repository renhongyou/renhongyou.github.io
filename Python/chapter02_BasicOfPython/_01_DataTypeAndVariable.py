# Integer
1, 100, -8080, 0
0xff00, 0xa5b4c3d2

# Float
1.23, 3.14, -9.01
1.23e9, 12.3e8,
# 0.000012 = 1.2e-5

# String
'abc', "xyz"
"I'm OK" # I'm OK
'I\'m\"OK\"!' # I'm "OK"!
print('\\\n\\')
print('''line1
line2
line3''')

# Boolean
True, False
print(3 > 2)
print(3 > 5)
print('True and True:', True and True)
print('True and False:', True and False)
print('False and False:', False and False)
print('True or True:', True or True)
print('True or False:', True or False)
print('False or False:', False or False)
age = 17
if age >= 18:
    print('adult')
else:
    print('teenager')

# Null
None

# Variable
a = 1
t_007 = 'T007'
Answer = True
a = 123 # a is an integer
print(a)
a = 'ABC' # a is a string
print(a)
# this "="" is not "=" which in math
x = 10
x = x + 2
print(x)

# constant (capital)
PI = 3.14159265359
print(10 / 3)
print(9 / 3)
print(10 // 3)
print(10 % 3)

# Exercise

# Please print out:
"""
n = 123
f = 456.789
s1 = 'Hello, world'
s2 = 'Hello, \'Adam\''
s3 = r'Hello, "Bart"'
s4 = r'''Hello,
Lisa!'''
"""
n = 123
f = 456.789
s1 = "\'Hello, world\'"
s2 = "r\'Hello, \\\'Adam\\\'\'"
s3 = "r\'Hello, \"Bart\"\'"
s4 = "r\'\'\'Hello,\nLisa!\'\'\'\n\"\"\""
print("n =", n)
print("f =", f)
print("s1 =", s1)
print("s2 =", s2)
print("s3 =", s3)
print("s4 =", s4)