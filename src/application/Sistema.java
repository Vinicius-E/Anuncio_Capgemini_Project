package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Anuncio;
import model.entities.Clientes;
import model.exception.DomainException;

public class Sistema {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Clientes clientes = new Clientes();

		try {

			System.out.println("SISTEMA PARA CADASTRO DE ANÚNCIOS");
			System.out.println();
			System.out.print("Quantos anúncios deseja cadastrar? ");
			int nAnuncio = sc.nextInt();
			sc.nextLine();

			// LENDO DADOS ANÚNCIOS
			for (int i = 1; i <= nAnuncio; i++) {
				System.out.println();
				System.out.println("Dados do anúncio #" + i);
				System.out.print("Nome do anúncio: ");
				String nomeA = sc.nextLine();
				System.out.print("Nome do cliente: ");
				String nomeCliente = sc.nextLine();
				System.out.print("Investimento por dia: R$");
				Double investimentoPorDia = sc.nextDouble();
				sc.nextLine();
				System.out.print("Data de início (dd/mm/aaa): ");
				Date dataInicio = sdf.parse(sc.next());
				sc.nextLine();
				System.out.print("Data de término (dd/mm/aaa): ");
				Date dataTermino = sdf.parse(sc.next());
				sc.nextLine();

				Anuncio anuncio = new Anuncio(nomeA, nomeCliente, dataInicio, dataTermino, investimentoPorDia);
				clientes.addAnuncio(anuncio);
			}

			// RELATÓRIO POR FILTRO
			System.out.println();
			System.out.print("Deseja filtrar por nome do cliente ou por intervalo de tempo (c/t)? ");
			char c1 = sc.next().charAt(0);
			sc.nextLine();

			if (c1 == 'c' || c1 == 'C') {
				System.out.print("Nome do cliente: ");
				String nomeCliente = sc.nextLine();
				clientes.existeCliente(nomeCliente);
			} else if (c1 == 't' || c1 == 'T') {
				System.out.print("Intervalo de tempo - Data início (dd/mm/aaaa): ");
				String dataInicio = sc.next();
				System.out.print("Intervalo de tempo - Data término (dd/mm/aaaa): ");
				String dataTermino = sc.next();

				int diaI = Integer.parseInt(dataInicio.substring(0, 2));
				int mesI = Integer.parseInt(dataInicio.substring(3, 5));
				int anoI = Integer.parseInt(dataInicio.substring(6, 10));
				int diaT = Integer.parseInt(dataTermino.substring(0, 2));
				int mesT = Integer.parseInt(dataTermino.substring(3, 5));
				int anoT = Integer.parseInt(dataTermino.substring(6, 10));
				clientes.existeTempo(diaI, mesI, anoI, diaT, mesT, anoT);
			} else {
				while (c1 != 'c' && c1 != 'C' && c1 != 't' && c1 != 'T') {
					System.out.println("O sistema aceita apenas (c) ou (t) como resultado!");
					System.out.print("Digite novamente: ");
					c1 = sc.next().charAt(0);
					sc.nextLine();
				}
				if (c1 == 'c' || c1 == 'C') {
					System.out.print("Nome do cliente: ");
					String nomeCliente = sc.nextLine();
					clientes.existeCliente(nomeCliente);
				} else {
					System.out.print("Intervalo de tempo - Data início (dd/mm/aaaa): ");
					String dataInicio = sc.next();
					System.out.print("Intervalo de tempo - Data término (dd/mm/aaaa): ");
					String dataTermino = sc.next();	

					int diaI = Integer.parseInt(dataInicio.substring(0, 2));
					int mesI = Integer.parseInt(dataInicio.substring(3, 5));
					int anoI = Integer.parseInt(dataInicio.substring(6, 10));
					int diaT = Integer.parseInt(dataTermino.substring(0, 2));
					int mesT = Integer.parseInt(dataTermino.substring(3, 5));
					int anoT = Integer.parseInt(dataTermino.substring(6, 10));
					clientes.existeTempo(diaI, mesI, anoI, diaT, mesT, anoT);
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Erro: Valor inválido");
		} catch (ParseException e) {
			System.out.println("Erro: Formato de data inválido");
		} catch (DomainException e) {
			System.out.println("Erro em anúncio: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}

}
