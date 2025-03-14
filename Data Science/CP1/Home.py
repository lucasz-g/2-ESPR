import streamlit as st

def app():
    tab1, tab2 = st.tabs(["Perfil", "Objetivos e Skills"])
    
    with tab1:
        st.header("Bem-vindo!")
        st.subheader("Sobre mim:")
        st.write("""
        Meu nome é **Lucas Garcia**, sou estudante de Engenharia de Software na FIAP (4º semestre), com sólida experiência prática em desenvolvimento de software, análise de dados, Machine Learning e integração de sistemas.<br><br>
        
        Como Consultor Oracle Trainee, integrei aplicações do EBS ao OIC, desenvolvi APIs e trabalhei com bancos de dados relacionais (SQL Oracle) e soluções baseadas em OCI.<br><br>   
                 
        Atualmente, atuo como Estagiário em Data Science, onde realizo análises de dados, desenvolvo modelos de Machine Learning, e crio aplicações Python que consomem e fornecem dados via APIs.
                 """, unsafe_allow_html=True)


    with tab2:
        st.header("Bem-vindo!")
        st.subheader("Minhas Skills:")
        st.markdown("""
        - **Desenvolvimento Backend**: APIs, Java, Python
        
        - **Desenvolvimento Frontend**: React, HTML, CSS
        
        - **Bancos de Dados Relacionais**: SQL Oracle, MySQL
        
        - **Ciência de Dados**: Análise e visualização de dados, Machine Learning e IA.
        
        - **Integrações de Sistemas**: Oracle Integration Cloud (OIC) e soluções OCI
        """)

        st.subheader("Objetivos:")
        st.markdown("""
        - **Desenvolver minhas habilidades em Ciência de Dados e Machine Learning**
        - **Aprimorar minhas habilidades em desenvolvimento de software e crescer na área**
        - **Contribuir para o crescimento da empresa onde atuo, melhorando a minha gestão de pessoas**"
        - **Aprender novas tecnologias e metodologias**
        """)

if __name__ == '__main__':
    app()