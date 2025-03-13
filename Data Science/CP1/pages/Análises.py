import streamlit as st
import pandas as pd
import numpy as np
import plotly.express as px

def app():
    tab1, tab2 = st.tabs(["Análises Descritivas", "Distribuições"])
    
    with tab1:
        st.write("Welcome to the Home page")

    with tab2:
        st.write("Welcome to the other page")

if __name__ == '__main__':
    app()