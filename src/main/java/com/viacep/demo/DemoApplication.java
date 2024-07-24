package com.viacep.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.InputMismatchException;
import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		menu();

	 System.out.println("Fim do programa.");
	}
	



	public static void menu() {
		boolean repete = true;

		while (repete) {
			System.out.println("Qual função deseja realizar? ");
			System.out.println("1 - Dividir por zero");
			System.out.println("2 - Listar nomes ");
			System.out.println("3 - Perguntar endereco ");
			System.out.println("4 - Sair");

			Scanner sc = new Scanner(System.in);

			try {
				int opcao = sc.nextInt();
				switch (opcao) {
					case 1:
						dividePorZero();
						break;
					case 2:
						listarNomes();
						break;
					case 3:
						perguntaEndereco();
						break;
					case 4:
						System.out.println("Saindo do programa...");
						repete = false;
						break;
					default:
						System.out.println("Opção inválida. Digite um número entre 1 e 3.");
						break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Opção inválida. Digite um número inteiro.");
				sc.next();
			}
		}
	}

	public static void perguntaEndereco() {

		System.out.println("Digite o CEP: ");
		Scanner sc = new Scanner(System.in);
		String cep = sc.nextLine();

		Endereco endereco = Endereco.getEnderecoByCep(cep);

		System.out.println("Endereço encontrado: ");
		System.out.println("CEP: " + cep);
		System.out.println("Logradouro: " + endereco.getLogradouro());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Cidade: " + endereco.getLocalidade());
		System.out.println("Estado: " + endereco.getUf());
		System.out.println("Complemento: " + endereco.getComplemento());

	}

	public static void listarNomes() {
		String[] nomes = { "Lucas", "Enzo", "Eloisa" };
		for (int i = 0; i < nomes.length; i++) {
			System.out.println((i + 1) + "- " + nomes[i]);
		}

		System.out.println("Escolha um nome da lista: ");
		Scanner sc = new Scanner(System.in);
		try {
			int opcao = sc.nextInt();
			opcao--;
			System.out.println("O nome escolhido foi: " + nomes[opcao]);
		} catch (InputMismatchException e) {
			System.out.println("Opção inválida. Digite um número inteiro.");
			sc.next();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Opção inválida. Digite um número entre 1 e " + nomes.length);
		}
	}

	public static void dividePorZero(){

		System.out.println("Digite um número: ");
		Scanner sc = new Scanner(System.in);
		
		try {
			int numero = sc.nextInt();
	
			System.out.println("Informe o divisor: ");
			// Dispara um erro InputMismatch caso digite uma letra
			int divisor = sc.nextInt();

			System.out.println("O resultado da divisão é: " 

			// Dispara um erro caso o divisor informado seja 0
			+ (numero / divisor));

		} catch (Exception e) {
			System.out.println("Erro! " + e.getMessage());
		}
	}
}
