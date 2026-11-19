package visitor;

public class Livro implements Produto {
    private final String titulo;
    private final double preco;

    public Livro(String titulo, double preco) {
        this.titulo = titulo;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public void aceitar(ProdutoVisitor visitor) {
        visitor.visitar(this);
    }
}
