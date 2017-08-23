# list

classmates = ['Michael', 'Bob', 'Tracy']
print(classmates)
print(len(classmates))
print(classmates[0])
print(classmates[1])
print(classmates[2])
# print(classmates[3]) IndexError
print(classmates[-1])
print(classmates[-2])
print(classmates[-3])
# print(classmates[-4]) IndexError

classmates.append('Adam')
print(classmates)

classmates.insert(1, 'Jack')
print(classmates)

print(classmates.pop())
print(classmates)

print(classmates.pop(1))
print(classmates)

classmates[1] = 'Sarah'
print(classmates)

L = ['Apple', 123, True]
print(L)

s = ['python', 'java', ['asp', 'php'], 'schme']
print(len(s))
print(s[2][1])

L = []
print(len(L))

# tuple

classmates = ('Michael', 'Bob', 'Tracy')

t = (1, 2)
print(t)

t = ()
print()

t = (1)
print(t)

t = (1,)
print(t)

t = ('a', 'b', ['A', 'B'])
print(t)
t[2][0] = 'X'
t[2][1] = 'Y'
print(t)

# Exercise
L = [
    ['Apple', 'Google', 'Microsoft'],
    ['Java', 'Python', 'Ruby', 'PHP'],
    ['Adam', 'Bart', 'Lisa']
]
# print Apple:
print(L[0][0])
# print Python:
print(L[1][1])
# print Lisa
print(L[-1][-1])