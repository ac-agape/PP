from copy import copy
from FIle import *
from abc import ABC, abstractmethod


class TextFile(File):
    def __init__(self):
        self.template = None
        super().__init__()
        self.read_file_from_stdin()

    def read_file_from_stdin(self):
        self.title = input("title: ")
        self.author = input("author: ")
        self.nr_paragraphs = int(input("number of paragraphs: "))
        self.paragraphs = []
        for i in range(self.nr_paragraphs):
            self.paragraphs.append(input("Paragraph: "))

    @abstractmethod
    def print_text(self):
        print(f'TEXT\ntitle: {self.title}\nauthor: {self.author}\n')
        for i in range(self.nr_paragraphs):
            print(self.paragraphs)

    def clone(self):
        return copy(self)
