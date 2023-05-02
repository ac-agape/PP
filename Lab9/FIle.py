from abc import ABC, abstractmethod


class File(ABC):
    def __init__(self):
        self.title = None
        self.author = None
        self.paragraphs = None
        self.nr_paragraphs = None

    @abstractmethod
    def read_file_from_stdin(self):
        self.title = input("title: ")
        self.author = input("author: ")
        self.nr_paragraphs = int(input("number of paragraphs: "))
        self.paragraphs = []
        for i in range(self.nr_paragraphs):
            self.paragraphs.append(input("Paragraph: "))