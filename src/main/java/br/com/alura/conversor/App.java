package br.com.alura.conversor;

import br.com.alura.conversor.core.ConversorMoeda;
import br.com.alura.conversor.http.ExchangeRateClient;
import br.com.alura.conversor.menu.Menu;
import br.com.alura.conversor.menu.MenuOption;

import java.util.Locale;

public class App {

    public void run() {
        Locale.setDefault(Locale.US);

        String apiKey = System.getenv("EXCHANGE_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            System.out.println("ERRO: variável de ambiente EXCHANGE_API_KEY não definida.");
            System.out.println("Defina a chave e execute novamente. Veja README.md.");
            return;
        }

        ExchangeRateClient client = new ExchangeRateClient(apiKey);
        ConversorMoeda conversor = new ConversorMoeda();
        Menu menu = new Menu();

        while (true) {
            MenuOption option = menu.askOption();
            if (option == MenuOption.SAIR) {
                System.out.println("Programa encerrado.");
                return;
            }

            double valor = menu.askValue();

            try {
                var rates = client.latest(option.getBase());
                double convertido = conversor.converter(valor, option.getTarget(), rates);

                System.out.printf("Resultado: %.2f %s = %.2f %s%n%n",
                        valor, option.getBase(), convertido, option.getTarget());

            } catch (Exception e) {
                System.out.println("Erro na conversão: " + e.getMessage());
                System.out.println();
            }
        }
    }
}
