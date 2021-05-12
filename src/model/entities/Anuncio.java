package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import model.exception.DomainException;

public class Anuncio {

	private String nomeA;
	private String nomeCliente;
	private Date dataInicio;
	private Date dataTermino;
	private Double investimentoPorDia;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Anuncio(String nomeA, String nomeCliente, Date dataInicio, Date dataTermino, Double investimentoPorDia) {
		if (!dataTermino.after(dataInicio)) {
			throw new DomainException("Data de término deve ser posterior a data de início");
		}

		this.nomeA = nomeA;
		this.nomeCliente = nomeCliente;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.investimentoPorDia = investimentoPorDia;
	}

	public String getNomeA() {
		return nomeA;
	}

	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Double getInvestimentoPorDia() {
		return investimentoPorDia;
	}

	public void setInvestimentoPorDia(Double investimentoPorDia) {
		this.investimentoPorDia = investimentoPorDia;
	}

	@Override
	public String toString() {
		Calculadora calc = new Calculadora(getNomeA(), getNomeCliente(), getDataInicio(), getDataTermino(),
				getInvestimentoPorDia());

		StringBuilder sb = new StringBuilder();
		sb.append("Anúncio: ");
		sb.append(getNomeA());
		sb.append("		    Cliente: ");
		sb.append(getNomeCliente() + "\n");
		sb.append("Data inicial: ");
		sb.append(sdf.format(getDataInicio()));
		sb.append("   	    Data término: ");
		sb.append(sdf.format(getDataTermino()) + "\n");
		sb.append("Investimento por dia: R$");
		sb.append(String.format("%.2f", getInvestimentoPorDia()) + "\n");
		sb.append("Valor total investido: R$" + String.format("%.2f", calc.totalInvestido()) + "\n");
		sb.append("Quantidade máxima de vizualizações: " + calc.qtdMaxVizualizacoes() + "\n");
		sb.append("Quantidade máxima de cliques: " + calc.qtdMaxCliques() + "\n");
		sb.append("Quantidade máxima de compartilhamentos: " + calc.qtdMaxCompartilhamento() + "\n");
		return sb.toString();
	}

	public String toStringT(Date dataInicioFiltro, Date getDataTermino) {
		Calculadora calc = new Calculadora(getNomeA(), getNomeCliente(), getDataInicio(), getDataTermino(),
				getInvestimentoPorDia());

		StringBuilder sb = new StringBuilder();
		sb.append("Anúncio: ");
		sb.append(getNomeA());
		sb.append("		    Cliente: ");
		sb.append(getNomeCliente() + "\n");
		sb.append("Data inicial: ");
		sb.append(sdf.format(dataInicioFiltro));
		sb.append("   	    Data término: ");
		sb.append(sdf.format(getDataTermino()) + "\n");
		sb.append("Investimento por dia: R$");
		sb.append(String.format("%.2f", getInvestimentoPorDia()) + "\n");
		sb.append("Valor total investido: R$");
		sb.append(String.format("%.2f", calc.totalInvestidoFiltroT(dataInicioFiltro, getDataTermino())));
		sb.append("\nQuantidade máxima de vizualizações: ");
		sb.append(calc.qtdMaxVizualizacoesFiltroT(dataInicioFiltro, getDataTermino()));
		sb.append("\nQuantidade máxima de cliques: ");
		sb.append(calc.qtdMaxCliquesFiltroT(dataInicioFiltro, getDataTermino()));
		sb.append("\nQuantidade máxima de compartilhamentos: ");
		sb.append(calc.qtdMaxCompartilhamentoFiltroT(dataInicioFiltro, getDataTermino()));
		return sb.toString();
	}

	public String toStringI(Date getDataIinicio, Date dataTerminoFiltro) {
		Calculadora calc = new Calculadora(getNomeA(), getNomeCliente(), getDataInicio(), getDataTermino(),
				getInvestimentoPorDia());

		StringBuilder sb = new StringBuilder();
		sb.append("Anúncio: ");
		sb.append(getNomeA());
		sb.append("		            Cliente: ");
		sb.append(getNomeCliente() + "\n");
		sb.append("Data inicial: ");
		sb.append(sdf.format(getDataInicio()));
		sb.append("   	    Data término: ");
		sb.append(sdf.format(dataTerminoFiltro) + "\n");
		sb.append("Investimento por dia: R$");
		sb.append(String.format("%.2f", getInvestimentoPorDia()) + "\n");
		sb.append("Valor total investido: R$");
		sb.append(String.format("%.2f", calc.totalInvestidoFiltroI(getDataInicio(), dataTerminoFiltro)));
		sb.append("\nQuantidade máxima de vizualizações: ");
		sb.append(calc.qtdMaxVizualizacoesFiltroI(getDataInicio(), dataTerminoFiltro));
		sb.append("\nQuantidade máxima de cliques: ");
		sb.append(calc.qtdMaxCliquesFiltroI(getDataInicio(), dataTerminoFiltro));
		sb.append("\nQuantidade máxima de compartilhamentos: ");
		sb.append(calc.qtdMaxCompartilhamentoFiltroI(getDataInicio(), dataTerminoFiltro));
		return sb.toString();
	}

	public String toStringTI(Date dataInicioFiltro, Date dataTerminoFiltro) {
		Calculadora calc = new Calculadora(getNomeA(), getNomeCliente(), getDataInicio(), getDataTermino(),
				getInvestimentoPorDia());

		StringBuilder sb = new StringBuilder();
		sb.append("Anúncio: ");
		sb.append(getNomeA());
		sb.append("		    Cliente: ");
		sb.append(getNomeCliente() + "\n");
		sb.append("Data inicial: ");
		sb.append(sdf.format(dataInicioFiltro));
		sb.append("   	    Data término: ");
		sb.append(sdf.format(dataTerminoFiltro) + "\n");
		sb.append("Investimento por dia: R$");
		sb.append(String.format("%.2f", getInvestimentoPorDia()) + "\n");
		sb.append("Valor total investido: R$");
		sb.append(String.format("%.2f", calc.totalInvestidoFiltroTI(dataInicioFiltro, dataTerminoFiltro)));
		sb.append("\nQuantidade máxima de vizualizações: ");
		sb.append(calc.qtdMaxVizualizacoesFiltroTI(dataInicioFiltro, dataTerminoFiltro));
		sb.append("\nQuantidade máxima de cliques: ");
		sb.append(calc.qtdMaxCliquesFiltroTI(dataInicioFiltro, dataTerminoFiltro));
		sb.append("\nQuantidade máxima de compartilhamentos: ");
		sb.append(calc.qtdMaxCompartilhamentoFiltroTI(dataInicioFiltro, dataTerminoFiltro));
		return sb.toString();
	}
}
