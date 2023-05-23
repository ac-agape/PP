from sympy import isprime

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

if __name__ == '__main__':
# se pot crea extensii DOAR pe clase custom
    text = str("pushi este pisica mea mai crazy asa de fel")
    print(text.toPascalCase())