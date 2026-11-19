package visitor;

import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        List<Produto> produtos = List.of(
                new Livro("Clean Code", 90.0),
                new Eletronico("Fone Bluetooth", 250.0, 12),
                new Alimento("Chocolate", 8.5, 90));

        ImpostoVisitor imposto = new ImpostoVisitor();
        RelatorioVisitor relatorio = new RelatorioVisitor();

        for (Produto produto : produtos) {
            produto.aceitar(imposto);
            produto.aceitar(relatorio);
        }

        System.out.print(relatorio.getRelatorio());
        System.out.printf(Locale.US, "Total de impostos: R$ %.2f%n", imposto.getTotal());
    }
}
