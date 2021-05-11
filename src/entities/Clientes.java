package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Clientes {

	public List<Anuncio> anuncios = new ArrayList<>();

	public Clientes() {

	}

	public List<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(List<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public void addAnuncio(Anuncio anuncios) {
		this.anuncios.add(anuncios);
	}

	public void removeAnuncio(Anuncio anuncios) {
		this.anuncios.remove(anuncios);
	}

	public void existeCliente(String nomeCLiente) {
		for (Anuncio a : anuncios) {
			if (a.getNomeCliente().equals(nomeCLiente)) {
				System.out.println(a.toString());
			}
		}
	}

	public void existeTempo(int diaI, int mesI, int anoI, int diaT, int mesT, int anoT) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		@SuppressWarnings("deprecation")
		Date dataInicioFiltro = new Date((anoI - 1900), (mesI - 1), diaI); // TRABALHANDO COM VERSÃO DESATUALIZADA...
		@SuppressWarnings("deprecation")
		Date dataTerminoFiltro = new Date((anoT - 1900), (mesT - 1), diaT);
		System.out.println(sdf.format(dataInicioFiltro) + " - " + sdf.format(dataTerminoFiltro));

		for (Anuncio a : anuncios) {
			if (dataInicioFiltro.getTime() == a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() == a.getDataTermino().getTime()) {
				
				System.out.println(a.toString());
				System.out.println();
				
			} else if (dataInicioFiltro.getTime() > a.getDataInicio().getTime()
					&& dataInicioFiltro.getTime() < a.getDataTermino().getTime()
					&& dataTerminoFiltro.getTime() >= a.getDataTermino().getTime()) {

				Calculadora calc = new Calculadora(a.getNomeA(), a.getNomeCliente(), a.getDataInicio(),
						a.getDataTermino(), a.getInvestimentoPorDia());

				StringBuilder sb = new StringBuilder();
				sb.append("Anúncio: ");
				sb.append(a.getNomeA());
				sb.append("		    Cliente: ");
				sb.append(a.getNomeCliente() + "\n");
				sb.append("Data inicial: ");
				sb.append(sdf.format(dataInicioFiltro));
				sb.append("   	    Data término: ");
				sb.append(sdf.format(a.getDataTermino()) + "\n");
				sb.append("Investimento por dia: R$");
				sb.append(String.format("%.2f", a.getInvestimentoPorDia()) + "\n");
				sb.append("Valor total investido: R$");
				sb.append(String.format("%.2f", calc.totalInvestidoFiltroT(dataInicioFiltro, a.getDataTermino())));
				sb.append("\nQuantidade máxima de vizualizações: ");
				sb.append(calc.qtdMaxVizualizacoesFiltroT(dataInicioFiltro, a.getDataTermino()));
				sb.append("\nQuantidade máxima de cliques: ");
				sb.append(calc.qtdMaxCliquesFiltroT(dataInicioFiltro, a.getDataTermino()));
				sb.append("\nQuantidade máxima de compartilhamentos: ");
				sb.append(calc.qtdMaxCompartilhamentoFiltroT(dataInicioFiltro, a.getDataTermino()));

				System.out.println(sb.toString());
				System.out.println();
				
			} else if (dataInicioFiltro.getTime() <= a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() > a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() <= a.getDataTermino().getTime()) {

				Calculadora calc = new Calculadora(a.getNomeA(), a.getNomeCliente(), a.getDataInicio(),
						a.getDataTermino(), a.getInvestimentoPorDia());

				StringBuilder sb = new StringBuilder();
				sb.append("Anúncio: ");
				sb.append(a.getNomeA());
				sb.append("		            Cliente: ");
				sb.append(a.getNomeCliente() + "\n");
				sb.append("Data inicial: ");
				sb.append(sdf.format(a.getDataInicio()));
				sb.append("   	    Data término: ");
				sb.append(sdf.format(dataTerminoFiltro) + "\n");
				sb.append("Investimento por dia: R$");
				sb.append(String.format("%.2f", a.getInvestimentoPorDia()) + "\n");
				sb.append("Valor total investido: R$");
				sb.append(String.format("%.2f", calc.totalInvestidoFiltroI(a.getDataInicio(), dataTerminoFiltro)));
				sb.append("\nQuantidade máxima de vizualizações: ");
				sb.append(calc.qtdMaxVizualizacoesFiltroI(a.getDataInicio(), dataTerminoFiltro));
				sb.append("\nQuantidade máxima de cliques: ");
				sb.append(calc.qtdMaxCliquesFiltroI(a.getDataInicio(), dataTerminoFiltro));
				sb.append("\nQuantidade máxima de compartilhamentos: ");
				sb.append(calc.qtdMaxCompartilhamentoFiltroI(a.getDataInicio(), dataTerminoFiltro));

				System.out.println(sb.toString());
				System.out.println();
				
			} else if (dataInicioFiltro.getTime() >= a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() <= a.getDataTermino().getTime()) {

				Calculadora calc = new Calculadora(a.getNomeA(), a.getNomeCliente(), a.getDataInicio(),
						a.getDataTermino(), a.getInvestimentoPorDia());

				StringBuilder sb = new StringBuilder();
				sb.append("Anúncio: ");
				sb.append(a.getNomeA());
				sb.append("		    Cliente: ");
				sb.append(a.getNomeCliente() + "\n");
				sb.append("Data inicial: ");
				sb.append(sdf.format(dataInicioFiltro));
				sb.append("   	    Data término: ");
				sb.append(sdf.format(dataTerminoFiltro) + "\n");
				sb.append("Investimento por dia: R$");
				sb.append(String.format("%.2f", a.getInvestimentoPorDia()) + "\n");
				sb.append("Valor total investido: R$"
						+ String.format("%.2f", calc.totalInvestidoFiltroTI(dataInicioFiltro, dataTerminoFiltro))
						+ "\n");
				sb.append("Quantidade máxima de vizualizações: "
						+ calc.qtdMaxVizualizacoesFiltroTI(dataInicioFiltro, dataTerminoFiltro) + "\n");
				sb.append("Quantidade máxima de cliques: "
						+ calc.qtdMaxCliquesFiltroTI(dataInicioFiltro, dataTerminoFiltro) + "\n");
				sb.append("Quantidade máxima de compartilhamentos: "
						+ calc.qtdMaxCompartilhamentoFiltroTI(dataInicioFiltro, dataTerminoFiltro) + "\n");

				System.out.println(sb.toString());
				System.out.println();

			} else if (dataInicioFiltro.getTime() < a.getDataTermino().getTime()
					&& dataTerminoFiltro.getTime() >= a.getDataTermino().getTime()) {

				System.out.println(a.toString());
				System.out.println();

			} else {
				System.out.println("Intervalo de tempo não possui nenhum anúncio!");
			}
		}
	}
}
