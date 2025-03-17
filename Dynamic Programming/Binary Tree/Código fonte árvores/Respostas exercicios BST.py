#Exercicio 1

# Função para encontrar o menor valor na árvore (recursiva)
def find_min(node):
    if node is None:
        return None
    if node.esquerda is None:  # O menor valor está no extremo esquerdo
        return node.valor
    return find_min(node.esquerda)

# Função para encontrar o maior valor na árvore (recursiva)
def find_max(node):
    if node is None:
        return None
    if node.direita is None:  # O maior valor está no extremo direito
        return node.valor
    return find_max(node.direita)


#Exercicio 2

# Função para percorrer a árvore em ordem e armazenar os valores em uma lista
def in_order(node, lista):
    if node is not None:
        in_order(node.esquerda, lista)  # Percorre a subárvore esquerda
        lista.append(node.valor)        # Adiciona o nó atual à lista
        in_order(node.direita, lista)   # Percorre a subárvore direita


#Exercicio 3
def k_esimo_menor(node, k):
    elementos = []
    in_order(node, elementos)  # Percorre a BST e armazena os elementos ordenados
    if 1 <= k <= len(elementos):
        return elementos[k-1]  # Retorna o k-ésimo menor (índice k-1)
    return None  # Retorna None se k estiver fora do intervalo válido

#Exercicio 4
# Buscar todas as palavras que começam com o prefixo
    
    def autocomplete(self, prefixo):
        resultado = []
        self._buscar_prefixo(self.raiz, prefixo, resultado)
        return sorted(resultado)  # Retorna a lista ordenada

    def _buscar_prefixo(self, node, prefixo, resultado):
        if node is None:
            return
        if node.palavra.startswith(prefixo):
            resultado.append(node.palavra)  # Adiciona palavra correspondente
        if node.esquerda is not None and node.palavra >= prefixo:
            self._buscar_prefixo(node.esquerda, prefixo, resultado)
        if node.direita is not None and node.palavra[:len(prefixo)] <= prefixo:
            self._buscar_prefixo(node.direita, prefixo, resultado)

