import jwt
import datetime

# Definição da chave secreta (NUNCA exponha essa chave!)
SECRET_KEY = "minha_chave_secreta_super_segura"

# Função para gerar um token JWT com ID e e-mail do usuário
def gerar_token(usuario_id, email, expiracao_minutos=30):
    payload = {
        "sub": usuario_id,  # ID do usuário
        "email": email,  # E-mail do usuário
        "exp": datetime.datetime.utcnow() + datetime.timedelta(minutes=expiracao_minutos),  # Expiração
        "iat": datetime.datetime.utcnow(),  # Data de emissão
        "iss": "meu_sistema"  # Identificação do emissor
    }
    token = jwt.encode(payload, SECRET_KEY, algorithm="HS256")
    return token

# Função para verificar e decodificar um token JWT
def verificar_token(token):
    try:
        payload = jwt.decode(token, SECRET_KEY, algorithms=["HS256"])
        return {"valid": True, "dados": payload}
    except jwt.ExpiredSignatureError:
        return {"valid": False, "erro": "Token expirado"}
    except jwt.InvalidTokenError:
        return {"valid": False, "erro": "Token inválido"}

# Exemplo de geração e validação de token
usuario_id = 123
email = "usuario@email.com"
token = gerar_token(usuario_id, email)

print("Token JWT gerado:", token)

# Verificando o token
verificacao = verificar_token(token)
print("Verificação do Token:", verificacao)
