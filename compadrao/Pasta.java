package compadrao;

import java.util.ArrayList;
import java.util.List;

// Composite: guarda uma única lista de ComponenteArquivo, podendo conter
// tanto Arquivos quanto outras Pastas, sem precisar diferenciá-los.
public class Pasta implements ComponenteArquivo {
    private String nome;
    private List<ComponenteArquivo> componentes = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionar(ComponenteArquivo componente) {
        componentes.add(componente);
    }

    public void remover(ComponenteArquivo componente) {
        componentes.remove(componente);
    }

    @Override
    public String getNome() {
        return nome;
    }

    // Um único laço resolve o cálculo, independente do filho ser
    // um Arquivo ou outra Pasta: cada um sabe calcular seu próprio tamanho.
    @Override
    public long getTamanho() {
        long total = 0;
        for (ComponenteArquivo componente : componentes) {
            total += componente.getTamanho();
        }
        return total;
    }

    // Mesma ideia aqui: delega a exibição para cada filho, que sabe
    // se exibir sozinho (seja folha ou outro composto).
    @Override
    public void exibir(String indentacao) {
        System.out.println(indentacao + "[Pasta] " + nome);
        for (ComponenteArquivo componente : componentes) {
            componente.exibir(indentacao + "  ");
        }
    }
}
