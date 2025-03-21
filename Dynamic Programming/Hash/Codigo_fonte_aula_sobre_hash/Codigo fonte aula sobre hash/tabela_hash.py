import hashlib
import pandas as pd

# Função para gerar um índice hash para um valor
def gerar_indice_hash(valor, tamanho_tabela):
    hash_obj = hashlib.sha256(valor.encode())  # Gera hash SHA-256
    hash_int = int(hash_obj.hexdigest(), 16)   # Converte hash para inteiro
    return hash_int % tamanho_tabela           # Índice dentro do tamanho da tabela

# Função para buscar um valor na "tabela hash"
def buscar_valor(valor_busca, df, tamanho_tabela):
    indice_busca = gerar_indice_hash(valor_busca, tamanho_tabela)
    resultados = df[df["Índice Hash"] == indice_busca]

    print(f"\n🔍 Buscando: '{valor_busca}' (Índice Hash: {indice_busca})")
    if not resultados.empty:
        encontrados = resultados[resultados["Valor"] == valor_busca]
        if not encontrados.empty:
            print("✅ Valor encontrado!")
            print(encontrados.to_string(index=False))
        else:
            print("⚠️ Colisão detectada. Valor com mesmo índice existe, mas não é o que você buscou:")
            print(resultados.to_string(index=False))
    else:
        print("❌ Valor não encontrado.")

# Parâmetros
tamanho_tabela = 50
valores = [
    "banana", "maçã", "laranja", "uva", "abacaxi", "pêssego", "morango", "melancia",
    "kiwi", "cereja", "manga", "abacate", "pera", "ameixa", "goiaba", "figo", "tangerina",
    "framboesa", "mirtilo", "caju", "coco", "limão", "pitanga", "jabuticaba", "maracujá",
    "graviola", "carambola", "tamarindo", "jenipapo", "cupuaçu", "açaí", "buriti", "cambuci",
    "siriguela", "umbu", "castanha", "noz", "avelã", "amêndoa", "cacau", "tomate", "pepino",
    "cenoura", "beterraba", "chuchu", "inhame", "batata", "mandioca", "ervilha", "feijão"
]

# Processando os valores
indices = []
for valor in valores:
    indice = gerar_indice_hash(valor, tamanho_tabela)
    indices.append((indice, valor))

# Exibindo a tabela como DataFrame
df = pd.DataFrame(indices, columns=["Índice Hash", "Valor"])
print(df.to_string(index=False))

# Teste de busca
buscar_valor("banana", df, tamanho_tabela)
buscar_valor("cenoura", df, tamanho_tabela)
buscar_valor("abacate", df, tamanho_tabela)
buscar_valor("morango", df, tamanho_tabela)
buscar_valor("camarão", df, tamanho_tabela)  # não existe



