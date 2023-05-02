from FileFactory import *


def main():
    file_type = input("type of file: ")
    my_file = FileFactory.factory(file_type)
    my_file.read_file_from_stdin()

    match (file_type):
        case "HTML":
            my_file.print_html()
        case "JSON":
            my_file.print_json()
        case "Article", "Blog":
            my_file.print_text()


main()
