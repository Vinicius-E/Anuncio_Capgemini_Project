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

			System.out.println("SISTEMA PARA CADASTRO DE AN�NCIOS");
			System.out.println();
			System.out.print("Quantos an�ncios deseja cadastrar? ");
			int nAnuncio = sc.nextInt();
			sc.nextLine();

			// LENDO DADOS AN�NCIOS
			for (int i = 1; i <= nAnuncio; i++) {
				System.out.println();
				System.out.println("Dados do an�ncio #" + i);
				System.out.print("Nome do an�ncio: ");
				String nomeA = sc.nextLine();
				System.out.print("Nome do cliente: ");
				String nomeCliente = sc.nextLine();
				System.out.print("Investimento por dia: R$");
				Double investimentoPorDia = sc.nextDouble();
				sc.nextLine();
				System.out.print("Data de in�cio (dd/mm/aaa): ");
				Date dataInicio = sdf.parse(sc.next());
				sc.nextLine();
				System.out.print("Data de t�rmino (dd/mm/aaa): ");
				Date dataTermino = sdf.parse(sc.next());
				sc.nextLine();

				Anuncio anuncio = new Anuncio(nomeA, nomeCliente, dataInicio, dataTermino, investimentoPorDia);
				clientes.addAnuncio(anuncio);
			}

			// RELAT�RIO POR FILTRO
			System.out.println();
			System.out.print("Deseja filtrar por nome do cliente ou por intervalo de tempo (c/t)? ");
			char c1 = sc.next().charAt(0);
			sc.nextLine();

			if (c1 == 'c' || c1 == 'C') {
				System.out.print("Nome do cliente: ");
				String nomeCliente = sc.nextLine();
				clientes.existeCliente(nomeCliente);
			} else if (c1 == 't' || c1 == 'T') {
				System.out.print("Intervalo de tempo - Data in�cio (dd/mm/aaaa): ");
				String dataInicio = sc.next();
				System.out.print("Intervalo de tempo - Data t�rmino (dd/mm/aaaa): ");
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
					System.out.print("Intervalo de tempo - Data in�cio (dd/mm/aaaa): ");
					String dataInicio = sc.next();
					System.out.print("Intervalo de tempo - Data t�rmino (dd/mm/aaaa): ");
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
			System.out.println("Erro: Valor inv�lido");
		} catch (ParseException e) {
			System.out.println("Erro: Formato de data inv�lido");
		} catch (DomainException e) {
			System.out.println("Erro em an�ncio: " + e.getMessage());
		} catch (RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();
	}

}
