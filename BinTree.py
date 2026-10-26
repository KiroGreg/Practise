class BinTree:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

    def add_left(self, key):
        if not self.left:
            self.left = BinTree(key)
        else:
            self.left.add_left(key)

    def add_right(self, key):
        if not self.right:
            self.right = BinTree(key)
        else:
            self.right.add_right(key)

    def change_right(self, data):
        self.right = BinTree(data)

    def change_left(self, data):
        self.left = BinTree(data)

    def get_data(self):
        return self.data

    def get_left(self):
        return self.left

    def get_right(self):
        return self.right

    def find_data(self, data):
        if self.data == data:
            return self
        else:
            data_right = self.right.find_data(data) if self.right else None
            data_left = self.left.find_data(data) if self.left else None
            return data_left, data_right

    def deep(self):
        if not self.right and not self.left:
            return 1
        elif not self.right:
            return 1 + self.left.deep()
        elif not self.left:
            return 1 + self.right.deep()
        else:
            return 1 + max(self.right.deep(), self.left.deep())


if __name__ == "__main__":
    t = BinTree(3)
    t.add_right(4)
    t.add_left(100)
    t.left.add_right(101)
    t.left.change_right(4)
    t.right.add_right(5)
    d = t.deep()
    print(d)
