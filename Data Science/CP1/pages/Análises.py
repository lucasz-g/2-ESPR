import streamlit as st
import pandas as pd
import plotly.express as px

def app():
    st.title("Análises")
    st.subheader("Faça análises descritivas e distribuições dos dados")

    file = st.file_uploader("Escolha um arquivo CSV", type="csv")

    if file:
        df = pd.read_csv(file)

        df['Product_ID'] = df["Product_ID"].astype(str)

        # Criando as abas corretamente
        tab1, tab2, tab3 = st.tabs(["Visualização", "Análises Descritivas", "Distribuições"])

        with tab1:
            st.subheader("Dataframe")
            st.write(df)

        with tab2:
            st.subheader("Análises Descritivas")

            st.write("#### Primeiras linhas do dataframe")
            st.write(df.head())

            st.write("#### Estatísticas descritivas")
            st.caption("Somente colunas **numéricas**")
            st.write(df.describe())

            st.write("#### Tipos dos dados")
            st.write(df.dtypes)

            st.write("#### Colunas")
            st.write(df.columns.tolist())

            st.write("#### Dimensões do dataframe")
            st.write(f"Linhas: {df.shape[0]}, Colunas: {df.shape[1]}")

            st.write("#### Valores nulos por coluna")
            st.write(df.isnull().sum())

            st.write("#### Número de valores únicos por coluna")
            st.write(df.nunique())

        with tab3:  # Correção do erro do `tab2` duplicado
            st.subheader("Distribuições")

            colunas_numericas = df.select_dtypes(include=["number"]).columns.tolist()
            
            if not colunas_numericas:
                st.write("Nenhuma coluna numérica encontrada no dataset.")
            else:
                coluna_escolhida = st.selectbox("Escolha uma coluna para visualizar a distribuição:", colunas_numericas)
                
                fig = px.histogram(df, x=coluna_escolhida, nbins=30, title=f"Distribuição de {coluna_escolhida}")
                st.plotly_chart(fig)

            st.subheader("Distribuição Binomial")



if __name__ == '__main__':
    app()
