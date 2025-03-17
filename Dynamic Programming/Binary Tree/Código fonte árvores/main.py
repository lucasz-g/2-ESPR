from print_binary_tree import print_tree


class NodeTree:
    def __init__(self, data=None, left=None, right=None):
        self.data = data
        self.left = left
        self.right = right


def insert(root, node):
    if root is None:
        root = node

    elif root.data < node.data:
        if root.right is None:
            root.right = node
        else:
            insert(root.right, node)

    else:
        if root.left is None:
            root.left = node
        else:
            insert(root.left, node)


def pre_order(root):
    if not root:
        return

    print(root.data, end=" ")

    pre_order(root.left)
    pre_order(root.right)


def in_order(root):
    if not root:
        return

    in_order(root.left)
    print(root.data, end=" ")
    in_order(root.right)


def post_order(root):
    if not root:
        return

    post_order(root.left)
    post_order(root.right)
    print(root.data, end=" ")


def search(root, data):
    if root is None or root.data == data:
        return root

    if data < root.data:
        return search(root.left, data)
    else:
        return search(root.right, data)


tree = NodeTree(40)

for data in [20, 60, 50, 70, 10, 30]:
    node = NodeTree(data)
    insert(tree, node)

items = in_order_transversal(tree)
print(items)
