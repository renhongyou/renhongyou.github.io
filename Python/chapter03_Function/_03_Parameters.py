# location parameter

def power(x):
    return x * x

print(power(5))
print(power(15))

def power(x, n):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(5, 2))
print(power(5, 3))

# default parameter

# power(5) # missing 1 required positional argument
def power(x, n = 2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(5))
print(power(5, 2))

def enroll(name, gender):
    print('name:', name)
    print('gender:', gender)

enroll('Sarah', 'F')

def enroll(name, gender, age = 6, city = 'Beijing'):
    print('name:', name)
    print('gender:', gender)
    print('age:', age)
    print('city:', city)

enroll('Sarah', 'F')

enroll('Bob', 'M', 7)
enroll('Adam', 'M', city = 'Tianjin')

def add_end(L = []):
    L.append('END')
    return L

print(add_end([1, 2, 3]))
print(add_end(['x', 'y', 'z']))

print(add_end())
print(add_end())
print(add_end())