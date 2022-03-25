# Gerenciamento de usuários 
## Overview do projeto
Trata-se de uma API RESTful Web Services para cadastro de usuários

### Tecnologias utilizadas:

* Java
* Spring boot 

### Dependências utilizadas:
* Starter validation

## Funcionalidades
### Cadastro de usuário

- Deve ser possível cadastrar um novo usuário localmente.

**Regras de Negócio** 
- Não deve ser possível criar usuário com valor nulo para qualquer um dos atributos.
- Não deve ser possível criar usuário com email inválido.

### Listagem dos usuários

- Deve ser possível listar todos os usuários.
- Deve ser possível listar todas as informações de um usuário específico - passando o  userId como parâmetro.

### Atualização de dados de um usuário

- Deve ser possível atualizar um usuário - informando o  userId a ser atualizado.
- Deve ser possível atualizar fistName e lastName do usuário.
- Deve retornar todos os dados do usuário com o respectivo userId.

**Regras de Negócio** 
- Não deve ser possível atualizar dados de um usuário que não está salvo localmente.
- Não deve ser possível atualizar o email e password de um usuário.


### Remoção de um usuário

- Deve ser possível deletar um usuário - informando o userId do usuário a ser deletado.

**Regras de Negócio** 
- Não deve ser possível deletar um usuário que não está com o userId cadastrado.
