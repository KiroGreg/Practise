class Node:
    def __init__(self, data=None, prev=None, next=None):
        self.data = data
        self.next = next
        self.prev = prev

    def __repr__(self):
        return f"[{self.prev}], {self.data},<{self.next.data}>" if self.next else f"[{self.prev}], {self.data},<None>"


class DLinkedList:

    def __init__(self):
        self.head = None

    def add_to_list(self, data):
        node = Node(data)
        if self.head is None:
            self.head = node
            return
        self.head = Node(node.data, next=self.head)
        self.head.next.prev = self.head

    def __repr__(self):
        return str(self.head)


if __name__ == "__main__":
    d = DLinkedList()
    d.add_to_list(3)
    d.add_to_list(4)
    d.add_to_list(45)
    print(d)
