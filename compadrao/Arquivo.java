// Leaf: não tem filhos, apenas implementa o contrato do Component.

package compadrao;

public class Arquivo implements ComponenteArquivo {
    private String nome;
    private long tamanho; // em KB

    public Arquivo(String nome, long tamanho) {
        this.nome = nome;
        this.tamanho = tamanho;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public long getTamanho() {
        return tamanho;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "[Arquivo] " + nome + " (" + tamanho + "KB)");
    }
}
