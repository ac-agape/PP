import threading
import multiprocessing
from concurrent.futures import ThreadPoolExecutor
import time

import random

x = 10
array =  random.sample(range(0, 100), x)
my_set =  random.sample(range(0, 100), x)


def primes(y):
    for i in range(2, int(y / 2)):
        if y % i == 0:
            return 0
    return 1


def countdown(arr, myset):
    array_s = sorted(arr)
    set_f = list(filter(primes, myset))


def ver_1(arr, myset):
    threads = []
    thread_count = 2
    for i in range(thread_count):
        threads.append(threading.Thread(target=lambda: countdown(arr, myset)))

    for thread in threads:
        thread.start()

    for thread in threads:
        thread.join()


def ver_2(arr, myset):
    countdown(arr, myset)
    countdown(arr, myset)


def ver_3(arr, myset):
    processes = []
    thread_count = 2
    for i in range(thread_count):
        processes.append(multiprocessing.Process(target=lambda: countdown(arr, myset)))

    for process in processes:
        process.start()

    for process in processes:
        process.join()


def ver_4(arr, myset):
    max_workers = 2
    with ThreadPoolExecutor(max_workers=max_workers) as executor:
        for i in range(max_workers):
            future = executor.submit(lambda: countdown(arr, myset))


if __name__ == '__main__':
    start = time.time()
    ver_1(array.copy(), my_set.copy())
    end = time.time()
    print("\nTimp executie pseudoparalelism cu GIL")
    print(end - start)

    start = time.time()
    ver_2(array.copy(), my_set.copy())
    end = time.time()
    print("\nTimp executie secvential")
    print(end - start)

    start = time.time()
    ver_3(array.copy(), my_set.copy())
    end = time.time()
    print("\nTimp executie paralela cu multiprocessing")
    print(end - start)

    start = time.time()
    ver_4(array.copy(), my_set.copy())
    end = time.time()
    print("\nTimp executie paralela cu concurrent.futures")
    print(end - start)