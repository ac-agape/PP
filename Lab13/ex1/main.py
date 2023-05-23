from sympy import isprime

#ex1
class int(int):
    def is_prime(self):
        if isprime(self):
            return True
        return False

print("is 5 prime? " + str(int(5).is_prime()))
print("is 6 prime? " + str(int(6).is_prime()))