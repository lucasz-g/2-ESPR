class Heap:
    def __init__(self):
        self.items = [None]

    def insert(self, item):
        self.items.append(item)

        i = len(self.items) - 1

        while i > 1:

            pai = i // 2

            if self.items[i] > self.items[pai]:
                self.items[i], self.items[pai] = self.items[pai], self.items[i]
                i = pai
            else:
                break

    def remove(self):
        if len(self.items) <= 1:
            return None

        # Troca a raiz pelo último elemento e remove a raiz
        raiz = self.items[1]
        self.items[1] = self.items[-1]
        self.items.pop()

        # Reorganiza a heap descendo o novo elemento na raiz
        i = 1
        while 2 * i < len(self.items):  # Enquanto houver pelo menos um filho
            c = 2 * i  # Filho esquerdo

            # Se o filho direito existir e for maior que o esquerdo, escolhe o direito
            if c + 1 < len(self.items) and self.items[c + 1] > self.items[c]:
                c += 1

            # Se o pai for maior ou igual ao maior filho, a heap está ajustada
            if self.items[i] >= self.items[c]:
                break

            # Troca o pai com o maior filho
            self.items[i], self.items[c] = self.items[c], self.items[i]
            i = c  # Atualiza o índice para continuar descendo

        return raiz  # Retorna o maior elemento removido

    def __repr__(self):
        return str(self.items)


heap = Heap()
heap.insert(50)
heap.insert(40)
heap.insert(30)
heap.insert(15)
heap.insert(10)
heap.insert(8)
heap.insert(16)

print(heap.items)  # Exibe a heap antes da remoção
print(heap.remove())  # Remove e imprime o maior elemento
print(heap.items)  # Exibe a heap após a remoção
