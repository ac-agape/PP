from TextFile import *


class BlogTextFile(TextFile):
    def __init__(self):
        template = "Blog"
        super().__init__()
        self.read_file_from_stdin()

    def print_text(self):
        print(f'BLOG_ARTICLE\ntitle: {self.title}')
        for i in range(self.nr_paragraphs):
            print(self.paragraphs)
        print(f'\nby author: {self.author}')
