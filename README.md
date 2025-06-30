# Consulta-Cep 📫

Projeto em **Java** para consultar e armazenar dados de endereços brasileiros a partir de códigos postais (CEP), utilizando a API pública [ViaCEP](https://viacep.com.br/). 🇧🇷

---

## Descrição 📝

Este programa realiza buscas de endereços por CEP, obtendo os dados diretamente da API ViaCEP e armazenando os resultados em um arquivo JSON para consulta posterior.

- **Cep.java**: classe que representa os dados retornados pela API, modelando o endereço em formato de registro.
- **principalComApi.java**: classe principal que realiza a interação com o usuário, busca os CEPs na API, armazena as respostas em uma lista e grava os dados em um arquivo JSON (`Cps.txt`).

---

## Funcionalidades ⚙️

- Solicita ao usuário um ou mais CEPs para consulta.
- Faz requisições HTTP à API ViaCEP para obter os dados do endereço correspondente.
- Armazena os resultados em uma lista interna.
- Salva os dados consultados em arquivo JSON para uso futuro.

---

## Requisitos 📚

- **JDK 11** ou superior instalado no sistema.
- Biblioteca **Gson** para manipulação de JSON.
  - [Download Gson](https://github.com/google/gson/releases) 📥
  - Incluir o `.jar` do Gson no classpath do projeto.

---

## Como executar ▶️

1. Clone ou baixe o repositório.

2. Certifique-se de que o JDK 11+ esteja instalado e configurado corretamente.

3. Baixe a biblioteca Gson e adicione ao seu projeto.

4. Compile os arquivos `.java` no terminal:

```bash
javac -cp gson-<versão>.jar Cep.java principalComApi.java
```
Execute o programa:

```bash
java -cp .;gson-<versão>.jar principalComApi
```
Nota: No Linux ou macOS, substitua o ponto e vírgula ; por dois pontos : no classpath, assim:

```bash
java -cp .:gson-<versão>.jar principalComApi
```
Insira os CEPs quando solicitado (exemplo: 01001-000), pressione Enter após cada um.

Para finalizar a inserção, siga a instrução exibida no programa (exemplo: deixar vazio e pressionar Enter).

Arquivo de saída 💾
Os dados consultados serão salvos no arquivo Cps.txt na raiz do projeto, no formato JSON.

Você poderá reutilizar ou analisar os dados posteriormente com qualquer ferramenta que leia JSON.

Observações ⚠️
O programa depende da disponibilidade da API ViaCEP.

Caso a API não retorne dados para um CEP informado, o programa trata e informa o erro.

A inclusão da biblioteca Gson é essencial para a correta manipulação dos dados JSON.

Referências 🔗
API ViaCEP: https://viacep.com.br/

Biblioteca Gson: https://github.com/google/gson
