from TextFile import *


class ArticleTextFile(TextFile):
    def __init__(self):
        template = "Article"
        super().__init__()
        self.read_file_from_stdin()

    def print_text(self):
        print(f'TEXT_ARTICLE\ntitle: {self.title}\n by author: {self.author}\n')
        for i in range(self.nr_paragraphs):
            print(self.paragraphs)
