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
#Exercicio 1
def heap_sort(arr):
    heap = Heap()

    # Insere todos os elementos na heap
    for num in arr:
        heap.insert(num)

    sorted_arr = []

    # Remove os elementos da heap em ordem decrescente
    while len(heap.items) > 1:
        sorted_arr.append(heap.remove())

    return sorted_arr


# Teste
nums = [4, 10, 3, 5, 1]
print(heap_sort(nums))  # Saída esperada: [10, 5, 4, 3, 1]


#Exercicio 2
def k_maiores_elementos(arr, k):
    heap = Heap()

    # Insere os elementos na heap
    for num in arr:
        heap.insert(num)

    # Remove os k maiores elementos
    maiores = [heap.remove() for _ in range(k)]

    return maiores


# Teste
nums = [20, 15, 30, 5, 10, 25, 40]
print(k_maiores_elementos(nums, 3))  # Saída esperada: [40, 30, 25]


#Exercicio 3

class Tarefa:
    def __init__(self, descricao, prioridade):
        self.descricao = descricao
        self.prioridade = prioridade

    def get_prioridade(self):
        """Retorna a prioridade da tarefa"""
        return self.prioridade

    def __repr__(self):
        return f"({self.prioridade}) {self.descricao}"

def fila_prioridade(tarefas):
    heap = Heap()

    # Insere as tarefas na heap manualmente ordenando pela prioridade
    for tarefa in tarefas:
        heap.insert((tarefa.prioridade, tarefa))  # Insere como tupla (prioridade, objeto)

    # Remove e executa as tarefas na ordem de maior prioridade
    return [heap.remove()[1] for _ in range(len(tarefas))]  # Retorna apenas os objetos Tarefa



# Teste
tarefas = [
    Tarefa("Corrigir bugs", 2),
    Tarefa("Enviar relatório", 3),
    Tarefa("Implementar feature", 5),
    Tarefa("Revisar código", 4),
]

print(fila_prioridade(tarefas))
# Saída esperada:
# [(5) Implementar feature, (4) Revisar código, (3) Enviar relatório, (2) Corrigir bugs]

