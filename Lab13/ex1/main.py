from sympy import isprime
from functional import seq

#ex1
class int(int):
    def is_prime(self):
        if isprime(self):
            return True
        return False

print("is 5 prime? " + str(int(5).is_prime()))
print("is 6 prime? " + str(int(6).is_prime()))

#ex2
class str(str):
    def toPascalCase(self):
        l = list(self.split(" "))
        return "".join(map(lambda x: x.capitalize(), l))

text = str("pushi este pisica mea mai crazy asa de fel")
print(text.toPascalCase())

#ex3
def pair(str1, str2):
    list = map(lambda x, y: (x, y), str1, str2)
    return list

list1 = ['a', 'b', 'c', 'd']
list2 = ['A', 'B', 'C', 'D']

list3 = pair(list1, list2)
print(tuple(list3))

#ex4
#n = int(input('n = '))
n = 6
var = (x ** 2 for x in range(n))
filtered = list(filter(lambda x: x%2==0, var))
print(filtered)

#ex5
text = str("aaaaaabbbbbbbbbccccccc")

result = (
    seq(list(text))
    .map(lambda a: (a, 1))
    .reduce_by_key(lambda x, y: x+y)
    .map(lambda t: t[0])
    .make_string("")
)

print(result)

#ex6
text = str("aaaabbbccd")

result = (
    seq(list(text))
    .map(lambda a: (a, 1))
    .reduce_by_key(lambda x, y: x + y)
    .map(lambda t: t[0] + str(t[1]) if t[1] > 1 else t[0])
    .make_string("")
)

print(result)