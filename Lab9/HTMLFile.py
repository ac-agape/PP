from FIle import *


class HTMLFile(File):
    def __init__(self):
        super().__init__()
        self.read_file_from_stdin()

    def read_file_from_stdin(self):
        self.title = input("title: ")
        self.author = input("author: ")
        self.nr_paragraphs = int(input("number of paragraphs: "))
        self.paragraphs = []
        for i in range(self.nr_paragraphs):
            self.paragraphs.append(input("Paragraph: "))

    def print_html(self):
        print(f'HTML\ntitle: {self.title}\nauthor: {self.author}\n')
        for i in range(self.nr_paragraphs):
            print(self.paragraphs)
