import hashlib
import os

senha_1 = "fiap25"
senha_2 = "fiap25"

salt_1 = os.urandom(16)
salt_2 = os.urandom(16)

hash_1 = hashlib.sha256(salt_1 + senha_1.encode()).hexdigest()
hash_2 = hashlib.sha256(salt_2 + senha_2.encode()).hexdigest()

print(hash_1)
print(hash_2)