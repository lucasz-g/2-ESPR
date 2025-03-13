import streamlit as st

def app():
    tab1, tab2 = st.tabs(["Perfil", "Objetivos e Skills"])
    
    with tab1:
        st.write("Welcome to the Home page")

    with tab2:
        st.write("Welcome to the other page")

if __name__ == '__main__':
    app()