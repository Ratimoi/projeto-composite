// Component: interface comum entre folhas (Arquivo) e compostos (Pasta).
// É ela que permite ao cliente tratar arquivos e pastas de forma uniforme.

package compadrao;

public interface ComponenteArquivo {
    String getNome();
    long getTamanho();
    void exibir(String indentacao);
}
