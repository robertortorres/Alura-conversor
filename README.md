# Conversor de Moedas (ExchangeRate-API) — Console Java

Projeto em Java (console) que consome a **ExchangeRate-API** para converter moedas em tempo real.
Feito no estilo do challenge da Alura (menu textual + 6 opções de conversão).

## Requisitos
- Java **17+**
- Maven **3.8+**

## Segurança (boas práticas)
A **API key NÃO fica no código**. Você deve fornecer via variável de ambiente:

- `EXCHANGE_API_KEY`

> Dica: nunca suba sua API key no GitHub.

## Como executar

### 1) Defina a variável de ambiente
Linux/macOS (bash/zsh):
```bash
export EXCHANGE_API_KEY="SUA_CHAVE_AQUI"
```

Windows (PowerShell):
```powershell
setx EXCHANGE_API_KEY "SUA_CHAVE_AQUI"
```
> Feche e reabra o terminal após usar `setx`.

### 2) Rodar via Maven
```bash
mvn -q clean package
java -jar target/conversor-moedas-1.0.0.jar
```

## Funcionalidades
- Menu com 6 conversões:
  - USD -> BRL
  - BRL -> USD
  - EUR -> BRL
  - BRL -> EUR
  - USD -> EUR
  - EUR -> USD
- Busca taxa em tempo real via endpoint `latest/{BASE}`
- Validação básica de entrada
- Mensagens de erro amigáveis

## Estrutura
- `ExchangeRateClient`: chamada HTTP + desserialização JSON (Gson)
- `ConversorMoeda`: converte valor base -> target
- `Menu`: exibe opções e lê input
- `Main`: ponto de entrada

## Extras (ideias)
- Cache local de taxas por alguns minutos para reduzir chamadas
- Histórico de conversões em arquivo (JSON/CSV)
- Menu dinâmico com mais moedas
