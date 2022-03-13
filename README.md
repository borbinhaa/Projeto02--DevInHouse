# DEV-AGRO

## O QUE É?

Uma REST api desenvolvido em java no qual será possível:

- [ x ] Criar empresas
- [ x ] Criar fazendas
- [ x ] Criar grãos
- [ x ] Criar funcionários
- [ x ] Ver todas as empresas
- [ x ] Ver todas as fazendas de uma empresa
- [ x ] Ver a quantidade de fazendas de uma empresa
- [ x ] Ver quando será a próxima colheita de uma fazenda
- [ x ] Adicionar uma colheita em uma fazenda
- [ x ] Adicionar uma saque de uma fazenda
- [ x ] Ver os grãos de uma empresa
- [ x ] Ver os estoques desses grãos
- [ x ] Ver os funcionários de uma empresa
- [ x ] Ver a quantidade de funcionários em uma empresa


## Como usar:

### Para Criar:

* #### Empresas 

*localhost:8080/* no método **POST**

{
    "nome": "Empresa 1",
    "cnpj": "05.532.578/0001-02",
    "endereco": "Rua Almiranto. n° 8"
}

* #### Fazendas 

*localhost:8080/fazendas/{id_da_empresa_que_voce_deseja_adicionar}* no método **POST**

{
    "nome": "Fazenda 01",
    "endereco": "RuaXYZ",
    "graoId": 1,
    "estoque": 1.5,
    "ultimaColheita": "20/01/2000"
}

    
* #### Grãos 

*localhost:8080/graos/{id_da_empresa_que_voce_deseja_adicionar}* no método **POST**

{
        "nome": "Feijao",
        "diasColheita": 15
}        


* #### Funcionarios 

*localhost:8080/funcionarios/{id_da_empresa_que_voce_deseja_adicionar}* no método **POST**

{
    "nome": "Maria",
    "sobrenome": "dos Santos",
    "cpf": "760.426.510-30",
    "endereco": "Rua Sao Paulo",
    "telefone": "(99) 999999999",
    "sexo": "FEMININO",
    "dataNascimento": "08/02/2000",
    "dataContratacao": "09/07/2020"
}

### Para ver:

* #### Todas as empresas

*localhost:8080/* no método **GET**

* #### Todas fazendas de uma empresa

*localhost:8080/fazendas/{id_da_empresa_que_voce_deseja_ver}* no método **GET**


* #### Quantidade de fazendas de uma empresa

*localhost:8080/fazendas/{id_da_empresa_que_voce_deseja_ver}/qtd* no método **GET**

* #### Proximas colheitas de uma empresa

*localhost:8080/fazendas/{id_da_empresa_que_voce_deseja_ver}/proximacolheita* no método **GET**

* #### Todos os grãos de uma empresa
  
*localhost:8080/graos/{id_da_empresa_que_voce_deseja_ver}* no método **GET**

* #### Estoque de grãos de uma empresa

*localhost:8080/graos/{id_da_empresa_que_voce_deseja_ver}/estoque* no método **GET**

* #### Todos os funcionários de uma empresa
  
*localhost:8080/funcionarios/{id_da_empresa_que_voce_deseja_ver}* no método **GET**

* #### Quantidade de funcionários de uma empresa

*localhost:8080/funcionarios/{id_da_empresa_que_voce_deseja_ver}/qtd* no método **GET**

### Para adicionar:

* #### Colheita

*localhost:8080/fazendas/colheita/{id_da_fazenda_que_voce_deseja_ver}* no método **PUT**

{
    "qtd": 1.5
}

* #### Saque

*localhost:8080/fazendas/saque/{id_da_fazenda_que_voce_deseja_sacar}* no método **PUT**

{
    "qtd": 1.5
}