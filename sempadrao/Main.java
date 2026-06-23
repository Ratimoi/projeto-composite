package sempadrao;

public class Main {
    public static void main(String[] args) {
        Pasta raiz = new Pasta("projeto");
        Arquivo readme = new Arquivo("README.md", 2);
        Arquivo pom = new Arquivo("pom.xml", 1);

        Pasta src = new Pasta("src");
        Arquivo classeMain = new Arquivo("Main.java", 5);
        Arquivo classeUtil = new Arquivo("Util.java", 3);

        src.adicionarArquivo(classeMain);
        src.adicionarArquivo(classeUtil);

        raiz.adicionarArquivo(readme);
        raiz.adicionarArquivo(pom);
        raiz.adicionarSubPasta(src);

        raiz.exibir("");
        System.out.println("Tamanho total: " + raiz.calcularTamanhoTotal() + "KB");

        // Problema visível: e se eu quiser adicionar um novo tipo de conteúdo,
        // por exemplo "LinkSimbolico"? Seria necessário:
        //   1) criar uma nova List<LinkSimbolico> dentro de Pasta;
        //   2) duplicar o laço dentro de calcularTamanhoTotal();
        //   3) duplicar o laço dentro de exibir().
        // Quanto mais tipos de conteúdo existirem, mais a classe Pasta cresce
        // e mais frágil ela fica a cada alteração.
    }
}
