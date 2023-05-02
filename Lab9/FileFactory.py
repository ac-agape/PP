from FIle import *
from HTMLFile import *
from JSONFile import *
from TextFile import *
from ArticleTextFile import *
from BlogTextFile import *


class FileFactory:
    @staticmethod
    def factory(file_type):
        match file_type:
            case "JSON":
                return JSONFile()
            case "HTML":
                return HTMLFile()
            case "Article":
                return ArticleTextFile()
            case "Blog":
                return BlogTextFile()