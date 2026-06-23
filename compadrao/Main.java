package compadrao;

public class Main {
    public static void main(String[] args) {
        ComponenteArquivo readme = new Arquivo("README.md", 2);
        ComponenteArquivo pom = new Arquivo("pom.xml", 1);

        Pasta src = new Pasta("src");
        src.adicionar(new Arquivo("Main.java", 5));
        src.adicionar(new Arquivo("Util.java", 3));

        Pasta raiz = new Pasta("projeto");
        raiz.adicionar(readme);
        raiz.adicionar(pom);
        raiz.adicionar(src); // uma Pasta dentro de outra Pasta, sem nenhum tratamento especial

        raiz.exibir("");
        System.out.println("Tamanho total: " + raiz.getTamanho() + "KB");

        // Vantagem: se quisermos um novo tipo de conteúdo, por exemplo
        // "LinkSimbolico", basta criar uma classe que implementa
        // ComponenteArquivo. Nenhuma linha de Pasta ou de Main precisa mudar
        // (Princípio Aberto/Fechado).
    }
}
