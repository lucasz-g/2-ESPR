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
        tab1, tab2, tab3 = st.tabs(["Visualização", "Análises Descritivas", "Gráficos"])

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

        with tab3:
            st.subheader("Gráficos")

            # Correlação
            dados_numeric = df.select_dtypes(include=["number"])
            fig_corr = px.imshow(dados_numeric.corr(), color_continuous_scale='Thermal', title="Correlação entre variáveis numéricas")
            st.plotly_chart(fig_corr)

            # Dispersão
            fig_disp_1 = px.scatter(df, x='Unit_Cost', y='Unit_Price', title="Dispersão: Custo por unidade vs Preço por unidade")
            st.plotly_chart(fig_disp_1)
            fig_disp_2 = px.scatter(df, x='Sales_Amount', y='Quantity_Sold', title="Dispersão: Faturamento vs Quantidade Vendida")
            st.plotly_chart(fig_disp_2)

            # Faturamento por região - Total
            amount_per_region = df.groupby('Region')[['Sales_Amount']].sum().reset_index()
            amount_per_region = amount_per_region.sort_values('Sales_Amount', ascending=False)
            fig_region_total = px.bar(amount_per_region, x='Region', y='Sales_Amount', color='Sales_Amount', color_continuous_scale='teal', title='Total de Faturamento por Região')
            st.plotly_chart(fig_region_total)

            # Faturamento por região - Média
            mean_amount_per_region = df.groupby('Region')[['Sales_Amount']].mean().reset_index()
            mean_amount_per_region = mean_amount_per_region.sort_values('Sales_Amount', ascending=False)
            fig_region_mean = px.bar(mean_amount_per_region, x='Region', y='Sales_Amount', color='Sales_Amount', color_continuous_scale='teal', title='Média de Faturamento por Região')
            st.plotly_chart(fig_region_mean)

            # Categoria mais vendida
            quantity_per_category = df.groupby('Product_Category')[['Quantity_Sold']].sum().reset_index()
            quantity_per_category = quantity_per_category.sort_values('Quantity_Sold', ascending=False)
            fig_category = px.bar(quantity_per_category, x='Product_Category', y='Quantity_Sold', color='Quantity_Sold', color_continuous_scale='teal', title='Quantidade Vendida por Categoria de Produto')
            st.plotly_chart(fig_category)

            # Sazonalidade de quantidade vendida
            data_grouped = df.groupby('Sale_Date')['Quantity_Sold'].sum().reset_index()
            data_grouped.sort_values('Quantity_Sold', ascending=False)
            fig_seasonality = px.line(data_grouped, x='Sale_Date', y='Quantity_Sold', title="Sazonalidade de Vendas por Data")
            st.plotly_chart(fig_seasonality)


if __name__ == '__main__':
    app()
