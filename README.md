```markdown
# Conversor de Moedas 💱

Este é um projeto desenvolvido como parte do **Programa ONE (Oracle Next Education)**.
O objetivo é criar um conversor de moedas que utiliza uma API para obter taxas de câmbio em tempo real
e realizar conversões entre diferentes moedas.

## 🛠️ Funcionalidades

- Listar moedas disponíveis para conversão.
- Realizar conversões entre moedas com base nas taxas de câmbio.
- Interface interativa no console para interação com o usuário.

## 🚀 Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Maven**: Gerenciador de dependências.
- **Gson**: Biblioteca para manipulação de JSON.
- **HTTP Client**: Para realizar requisições à API de taxas de câmbio.

## 📂 Estrutura do Projeto

src/
├── main/
│   ├── java/
│   │   └── br/com/alura/conversorDeMoedas/
│   │       ├── Main.java
│   │       ├── ExchangeRateService.java
│   │       └── CurrencyConverter.java
│   └── resources/
└── test/
```

## ⚙️ Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/LiraS23/ORACLE-ONE-Challenge-Conversor-de-Moedas.git
   ```
2. Navegue até o diretório do projeto:
   ```bash
   cd ORACLE-ONE-Challenge-Conversor-de-Moedas
   ```
3. Compile o projeto com o Maven:
   ```bash
   mvn clean install
   ```
4. Execute o programa:
   ```bash
   java -cp target/classes br.com.alura.conversorDeMoedas.Main
   ```

## 📝 Como Usar

1. Escolha uma das opções do menu exibido no console.
2. Insira o valor a ser convertido.
3. Veja o resultado da conversão diretamente no console.

## 📖 Exemplos de Uso

### Exemplo 1: USD para BRL
- Entrada: `1` (opção do menu), `100` (valor a ser convertido)
- Saída: `Valor convertido: 500.00 BRL` (exemplo com taxa fictícia)

### Exemplo 2: BRL para EUR
- Entrada: `4` (opção do menu), `200` (valor a ser convertido)
- Saída: `Valor convertido: 36.00 EUR` (exemplo com taxa fictícia)

## 🐛 Tratamento de Erros

- **Erro de conexão com a API**: Mensagem clara é exibida ao usuário.
- **Entrada inválida**: O programa solicita uma nova entrada.

## 🌐 API Utilizada
- O projeto consome dados em tempo real da ExchangeRate-API 

## 📜 Licença

Este projeto é de uso educacional e faz parte do Programa ONE.

---

Desenvolvido com 💙 por [LiraS23](https://github.com/LiraS23)
