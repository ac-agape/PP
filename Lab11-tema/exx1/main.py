from asyncio import Queue, gather, run, create_task
from functools import reduce


async def calculate_sum(queue):
    while not queue.empty():
        n = await queue.get()

        result = reduce(lambda sum, x: x + sum, range(0, n+1), 0)

        queue.task_done()

        print(f"sum(0, {n})(i)={result}")


async def main():
    queue = Queue()

    for i in range(50):
        queue.put_nowait(i)

    tasks = [
        create_task(calculate_sum(queue)),
        create_task(calculate_sum(queue)),
        create_task(calculate_sum(queue)),
        create_task(calculate_sum(queue)),
    ]

    await gather(*tasks)


if __name__ == "__main__":
    run(main())