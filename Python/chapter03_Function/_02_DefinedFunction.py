# defined function

"""
def my_abs(x):
    if x >= 0:
        return x
    else:
        return -x
"""

x = -123
# print(my_abs(x))

# empty function
def nop():
    pass

age = 18
if age >= 18:
    pass

# parameter check

# my_abs(1, 2) # TypeError

# my_abs('A') # str() >= int()

# abs('A') # TypeError

def my_abs(x):
    if not isinstance(x, (int, float)):
        raise TypeError('bad operand type')
    if x >= 0:
        return x
    else:
        return -x

# my_abs('A') # TypeError

# return more parameters
import math
def move(x, y, step, angle=0):
    nx = x + step * math.cos(angle)
    ny = y - step * math.sin(angle)
    return nx, ny

x, y = move(100, 100, 60, math.pi / 6)
print(x, y)

r = move(100, 100, 60, math.pi / 6)
print(r)

# Exercise

"""
请定义一个函数quadratic(a, b, c)，接收3个参数，返回一元二次方程：

ax2 + bx + c = 0

的两个解。

提示：计算平方根可以调用math.sqrt()函数：
"""
import math
def quadratic(a, b, c):
    delta = b * b - 4 * a * c
    if delta >= 0:
        x1 = (-b + math.sqrt(delta)) / (2 * a)
        x2 = (-b - math.sqrt(delta)) / (2 * a)
    else:
        pass
    return x1, x2

print(quadratic(2, 3, 1))
print(quadratic(1, 3, -4))