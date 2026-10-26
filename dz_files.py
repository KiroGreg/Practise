class MyOpen:
    def __init__(self, file_path, mode='r'):
        self.file_path = file_path
        self.mode = mode

    def __enter__(self):
        pass

    def __exit__(self, exc_type, exc_val, exc_tb):
        pass


def files1(listname):
    """1. Write a function that writes the contents of a list containing integers and floats to a text file, one number per line. The file is specified by name."""
    with open('file1-11.txt', 'w') as file:
        file.writelines(str(line) + '\n' for line in listname)


def files2(listname):
    with open('file1-11.txt', 'r') as file:
        l = []
        l.append(file.readlines())
        print(l)


def files3(filename):
    with open(filename, 'r') as file:
        l = file.read().split('\n')
        if '' in l:
            l.remove('')
        return l


def file7():
    """8. A text file of several dozen GB contains representations of integers and floats, one per line. Blank lines are allowed. Write a function that finds from the file: – the number of integers recorded in the file;"""
    with open('file1-11.txt', 'r') as file:
        a = file.read(4)
        print("a", a)


if __name__ == "__main__":
    file7()
