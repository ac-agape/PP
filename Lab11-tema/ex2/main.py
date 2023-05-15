#ip a | grep inet | wc -l
from subprocess import run, PIPE, CompletedProcess

if __name__ == "__main__":
    data = input("Please enter the command: ")

    first = True

    prev: CompletedProcess[bytes]

    for raw_command in data.split("|"):
        commands = [arg for arg in raw_command.split(" ") if arg != ""]


        if first:
            prev = run(commands, stdout=PIPE)

            first = False
        else:
            prev = run(commands, input=prev.stdout, stdout=PIPE)

    print(f'{prev.stdout.decode("utf-8")}')