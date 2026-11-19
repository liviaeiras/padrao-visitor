package visitor;

import java.util.Locale;

public class RelatorioVisitor implements ProdutoVisitor {
    private final StringBuilder relatorio = new StringBuilder();

    @Override
    public void visitar(Livro livro) {
        relatorio.append(String.format(Locale.US, "Livro: %s - R$ %.2f\n", livro.getTitulo(), livro.getPreco()));
    }

    @Override
    public void visitar(Eletronico eletronico) {
        relatorio.append(String.format(Locale.US, "Eletronico: %s - R$ %.2f - garantia %d meses\n",
                eletronico.getNome(), eletronico.getPreco(), eletronico.getGarantiaMeses()));
    }

    @Override
    public void visitar(Alimento alimento) {
        relatorio.append(String.format(Locale.US, "Alimento: %s - R$ %.2f - validade %d dias\n",
                alimento.getNome(), alimento.getPreco(), alimento.getDiasValidade()));
    }

    public String getRelatorio() {
        return relatorio.toString();
    }
}
