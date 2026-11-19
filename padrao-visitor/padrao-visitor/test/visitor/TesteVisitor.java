package visitor;

public class TesteVisitor {
    public static void main(String[] args) {
        testeLivroIsentoDeImposto();
        testeEletronicoTaxa20();
        testeAlimentoTaxa7();
        testeSomaDeVariosProdutos();
        testeVisitorNovoComecaZerado();
        testeRelatorio();
        System.out.println("Todos os testes passaram");
    }

    private static void testeLivroIsentoDeImposto() {
        ImpostoVisitor v = new ImpostoVisitor();
        new Livro("Java", 50.0).aceitar(v);
        verificar(iguais(v.getTotal(), 0.0), "livro e isento de imposto");
    }

    private static void testeEletronicoTaxa20() {
        ImpostoVisitor v = new ImpostoVisitor();
        new Eletronico("Notebook", 1000.0, 12).aceitar(v);
        verificar(iguais(v.getTotal(), 200.0), "eletronico paga 20% de imposto");
    }

    private static void testeAlimentoTaxa7() {
        ImpostoVisitor v = new ImpostoVisitor();
        new Alimento("Cafe", 10.0, 30).aceitar(v);
        verificar(iguais(v.getTotal(), 0.7), "alimento paga 7% de imposto");
    }

    private static void testeSomaDeVariosProdutos() {
        ImpostoVisitor v = new ImpostoVisitor();
        new Livro("Java", 50.0).aceitar(v);
        new Eletronico("Notebook", 1000.0, 12).aceitar(v);
        new Alimento("Cafe", 10.0, 30).aceitar(v);
        verificar(iguais(v.getTotal(), 200.7), "visitor acumula o imposto de varios produtos");
    }

    private static void testeVisitorNovoComecaZerado() {
        verificar(iguais(new ImpostoVisitor().getTotal(), 0.0), "visitor novo comeca com total zero");
    }

    private static void testeRelatorio() {
        RelatorioVisitor v = new RelatorioVisitor();
        new Livro("Java", 50.0).aceitar(v);
        new Eletronico("Notebook", 1000.0, 12).aceitar(v);
        new Alimento("Cafe", 10.0, 30).aceitar(v);
        String esperado = "Livro: Java - R$ 50.00\n"
                + "Eletronico: Notebook - R$ 1000.00 - garantia 12 meses\n"
                + "Alimento: Cafe - R$ 10.00 - validade 30 dias\n";
        verificar(esperado.equals(v.getRelatorio()), "relatorio lista os produtos na ordem visitada");
    }

    private static void verificar(boolean condicao, String descricao) {
        if (!condicao) {
            throw new AssertionError("FALHOU: " + descricao);
        }
        System.out.println("OK - " + descricao);
    }

    private static boolean iguais(double a, double b) {
        return Math.abs(a - b) < 1e-6;
    }
}
