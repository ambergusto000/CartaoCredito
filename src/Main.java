import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o limite do cartão: ");
        Double limite = sc.nextDouble();
        sc.nextLine();

        CartaoCredito cartaoCredito = new CartaoCredito(limite);

        int sair = 1;
        while (sair != 0) {
            System.out.println("Digite a descrição da compra:");
            String descricao = sc.nextLine();

            System.out.println("Digite o valor da compra:");
            Double valor = sc.nextDouble();
            sc.nextLine();

            Compra compra = new Compra(descricao, valor);
            boolean compraRealizada = cartaoCredito.lancaCompra(compra);
            if (compraRealizada) {
                System.out.println("Compra realizada com sucesso!");
                System.out.println("Digite 0 para sair ou 1 para continuar");
                sair = sc.nextInt();
                sc.nextLine(); // Limpa o buffer
            } else {
                System.out.println("Saldo insuficiente");
                sair = 0;
            }
        }

        System.out.println("***********************");
        System.out.println("COMPRAS REALIZADAS:\n");

        Collections.sort(cartaoCredito.getCompras());
        for (Compra c : cartaoCredito.getCompras()) {
            System.out.println(c.getDescricao() + " - " + c.getValor());
        }

        System.out.println("\n***********************");
        System.out.println("Saldo do cartão: " + cartaoCredito.getSaldo());
    }
}
