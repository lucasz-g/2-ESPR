import hashlib

texto = "Olá mundo"
hash_texto = hashlib.sha256(texto.encode()).hexdigest()

print(hash_texto)