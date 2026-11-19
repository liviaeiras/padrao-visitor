package visitor;

public class ImpostoVisitor implements ProdutoVisitor {
    private static final double TAXA_LIVRO = 0.0;
    private static final double TAXA_ELETRONICO = 0.20;
    private static final double TAXA_ALIMENTO = 0.07;

    private double total;

    @Override
    public void visitar(Livro livro) {
        total += livro.getPreco() * TAXA_LIVRO;
    }

    @Override
    public void visitar(Eletronico eletronico) {
        total += eletronico.getPreco() * TAXA_ELETRONICO;
    }

    @Override
    public void visitar(Alimento alimento) {
        total += alimento.getPreco() * TAXA_ALIMENTO;
    }

    public double getTotal() {
        return total;
    }
}
