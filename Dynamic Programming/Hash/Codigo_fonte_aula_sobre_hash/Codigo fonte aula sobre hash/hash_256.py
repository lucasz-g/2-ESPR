import hashlib

texto = "Olá mundo"
hash = hashlib.sha256(texto.encode()).hexdigest()

print(hash)