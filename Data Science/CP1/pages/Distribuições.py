import streamlit as st
import numpy as np
import pandas as pd
from scipy.stats import binom, poisson, norm
import plotly.express as px


def calcular_binomial(n, p, x):
    probabilidade_binomial = binom.pmf(x, n, p)
    return probabilidade_binomial

def calcular_poisson(lambda_, k):
    probabilidade_poisson = poisson.pmf(k, lambda_)
    return probabilidade_poisson

def calcular_normal(media, desvio_padrao, x_limite):
    probabilidade_normal = 1 - norm.cdf(x_limite, media, desvio_padrao)
    return probabilidade_normal


st.title("Distribuições")
st.subheader("Calcule a probabilidade de eventos com distribuições binomial, de Poisson e normal")

file = st.file_uploader("Escolha um arquivo CSV", type="csv")


if file:
    df = pd.read_csv(file)
    df['Product_ID'] = df["Product_ID"].astype(str)

    with st.expander("Distribuições", expanded=True):  # Expandir seção
        st.subheader("Escolha a distribuição")
        distribucao = st.radio("Selecione a distribuição", ["Binomial", "Poisson", "Normal"])

        if distribucao == "Binomial":
            st.subheader("Distribuição Binomial")
            st.write("De **n** vendas, qual a probabilidade de **y** vendas serem para novos clientes?")
            n = st.number_input("Total de tentativas (n)", min_value=1, value=1000)
            p = st.number_input("Probabilidade de sucesso (p)", min_value=0.0, max_value=1.0, value=0.504)
            x = st.number_input("Número de sucessos desejados (x)", min_value=0, value=500)

            probabilidade_binomial = calcular_binomial(n, p, x)
            st.write(f"A probabilidade de exatamente {x} vendas para novos clientes é: {probabilidade_binomial:.4f}")

            # Explicação
            st.write("""
            A **distribuição binomial** descreve o número de sucessos em um número fixo de tentativas, com cada tentativa tendo duas possibilidades: sucesso ou falha.
            
            Onde:
            - **n** é o número de tentativas,
            - **p** é a probabilidade de sucesso em cada tentativa,
            - **x** é o número de sucessos que estamos interessados em calcular.
            O valor resultante indica a **probabilidade de ocorrer exatamente x sucessos em n tentativas**.
            """)

        elif distribucao == "Poisson":
            st.subheader("Distribuição de Poisson")
            st.write("Qual a probabilidade de vender exatamente **k** unidades em um dia?")
            total_vendas = df['Quantity_Sold'].sum()
            total_dias = df['Sale_Date'].nunique()  # Substitua pela coluna correta
            lambda_ = total_vendas / total_dias
            k = st.number_input("Número de unidades vendidas (k)", min_value=0, value=30)

            probabilidade_poisson = calcular_poisson(lambda_, k)
            st.write(f"A probabilidade de vender exatamente {k} unidades em um dia é: {probabilidade_poisson:.4f}")

            # Explicação
            st.write("""
            A **distribuição de Poisson** é usada para modelar o número de eventos que ocorrem em um intervalo fixo de tempo ou espaço, quando esses eventos são independentes entre si.

            Onde:
            - **λ** é a taxa média de eventos por intervalo (a média de vendas por dia, neste caso),
            - **k** é o número exato de eventos (vendas) que queremos calcular.
            O resultado indica a **probabilidade de vender exatamente k unidades em um dia**.
            """)

        elif distribucao == "Normal":
            st.subheader("Distribuição Normal")
            st.write("Qual a chance de uma venda ultrapassar **x**?")
            media = df["Sales_Amount"].mean()
            desvio_padrao = df["Sales_Amount"].std()
            x_limite = st.number_input("Limite de vendas (x)", min_value=0, value=5000)

            probabilidade_normal = calcular_normal(media, desvio_padrao, x_limite)
            st.write(f"A probabilidade de uma venda ultrapassar R$ {x_limite} é: {probabilidade_normal:.4f}")

            # Explicação
            st.write("""
            A **distribuição normal** é usada para modelar fenômenos que se distribuem de forma simétrica ao redor de uma média. A maioria dos dados está próxima à média, com menos dados nas extremidades.

            Onde:
            - **x** é o valor de vendas que queremos calcular a probabilidade de ultrapassar,
            - **média** e **desvio padrão** são calculados com base nos dados históricos.
            O valor resultante indica a **probabilidade de uma venda ser maior que x**.
            """)

    st.write(
    """
    ## Funções da biblioteca `scipy.stats` utilizadas:

    ### **1. `binom.pmf` (Distribuição Binomial)**:
    A função `binom.pmf(x, n, p)` calcula a **função de massa de probabilidade (PMF)** para a distribuição binomial. Ela retorna a probabilidade de exatamente **x sucessos** em **n tentativas** independentes, onde a probabilidade de sucesso em cada tentativa é **p**. 

    Exemplo de código:
    ```python
    from scipy.stats import binom

    n = 1000  # Total de vendas
    p = 0.504  # Probabilidade de um novo cliente
    x = 500  # Número de vendas desejadas (exemplo)

    probabilidade_binomial = binom.pmf(x, n, p)
    print(probabilidade_binomial)
    ```

    ### **2. `poisson.pmf` (Distribuição de Poisson)**:
    A função `poisson.pmf(k, mu)` calcula a **probabilidade de massa (PMF)** para a distribuição de Poisson. Ela retorna a probabilidade de ocorrer exatamente **k eventos** em um intervalo de tempo ou espaço, onde **mu** (λ) é a taxa média de ocorrências do evento por intervalo.


    Essa distribuição é adequada para modelar eventos raros que ocorrem independentemente em intervalos fixos, como o número de vendas feitas em um dia específico.

    Exemplo de código:
    ```python
    from scipy.stats import poisson

    total_vendas = 1000
    total_dias = 30
    lambda_ = total_vendas / total_dias  # Taxa média de vendas por dia
    k = 30  # Número de vendas desejadas

    probabilidade_30 = poisson.pmf(k, lambda_)
    print(probabilidade_30)
    ```

    ### **3. `norm.cdf` (Distribuição Normal)**:
    A função `norm.cdf(x, loc, scale)` calcula a **função de distribuição acumulada (CDF)** para a distribuição normal. Ela retorna a probabilidade de uma variável aleatória normal ser **menor ou igual a x**, dado uma média (`loc`) e desvio padrão (`scale`). 

    Onde **erf** é a função erro. Usamos essa função para calcular a probabilidade acumulada de que um valor da variável aleatória seja inferior ou igual a um determinado valor.

    Exemplo de código:
    ```python
    from scipy.stats import norm

    media = 1000  # Exemplo de média
    desvio_padrao = 200  # Exemplo de desvio padrão
    x_limite = 5000

    probabilidade = 1 - norm.cdf(x_limite, media, desvio_padrao)
    print(probabilidade)
    ```
    """
)