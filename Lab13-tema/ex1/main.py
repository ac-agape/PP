from functools import reduce
from more_itertools import map_reduce, chunked

def ex2():
    words = "imi e somn si am pofta de un pepene galben aromat".split()

    a = map_reduce(words, keyfunc=lambda x: x[0], reducefunc=lambda l: sorted(l))
    b = sorted(a.items())
    c = map(lambda x: x[1], b)
    d = list(reduce(lambda arr, el: arr+el, c))

    print(d)

def ex3():
    lists = (1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8)
    a = filter(lambda x: x >= 5, lists)
    #print(f'a) {list(a)}')

    b = chunked(a, 2)
    #print(f'b) {list(b)}')

    c = map(lambda l: l[0] * l[1], b)
    #print(f'c) {list(c)}')

    d = reduce(lambda sum, x: sum + x, c, 0)
    print(f'd) {d}')


if __name__ == "__main__":
    ex2()
    ex3()