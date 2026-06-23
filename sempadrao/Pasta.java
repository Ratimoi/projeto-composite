package sempadrao;

import java.util.ArrayList;
import java.util.List;

public class Pasta {
    private String nome;

    // Problema: precisamos de uma lista separada para cada tipo de conteúdo.
    // Se surgir um novo tipo (ex.: LinkSimbolico), precisaremos de mais uma lista.
    private List<Arquivo> arquivos = new ArrayList<>();
    private List<Pasta> subPastas = new ArrayList<>();

    public Pasta(String nome) {
        this.nome = nome;
    }

    public void adicionarArquivo(Arquivo arquivo) {
        arquivos.add(arquivo);
    }

    public void adicionarSubPasta(Pasta pasta) {
        subPastas.add(pasta);
    }

    public String getNome() {
        return nome;
    }

    // Precisa percorrer DOIS tipos de listas, com lógica praticamente duplicada.
    // Se surgir um terceiro tipo de conteúdo, este método cresce de novo.
    public long calcularTamanhoTotal() {
        long total = 0;

        for (Arquivo arquivo : arquivos) {
            total += arquivo.getTamanho();
        }

        for (Pasta subPasta : subPastas) {
            total += subPasta.calcularTamanhoTotal(); // recursão só funciona pq Pasta conhece Pasta
        }

        return total;
    }

    // Mesma duplicação aqui: o laço para arquivos e o laço para subpastas
    // repetem a mesma estrutura vista em calcularTamanhoTotal().
    public void exibir(String indentacao) {
        System.out.println(indentacao + "[Pasta] " + nome);

        for (Arquivo arquivo : arquivos) {
            System.out.println(indentacao + "  [Arquivo] " + arquivo.getNome()
                    + " (" + arquivo.getTamanho() + "KB)");
        }

        for (Pasta subPasta : subPastas) {
            subPasta.exibir(indentacao + "  ");
        }
    }
}
