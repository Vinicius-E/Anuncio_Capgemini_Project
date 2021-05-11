package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Anuncio {

	private String nomeA;
	private String nomeCliente;
	private Date dataInicio;
	private Date dataTermino;
	private Double investimentoPorDia;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Anuncio(String nomeA, String nomeCliente, Date dataInicio, Date dataTermino, Double investimentoPorDia) {
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
		StringBuilder sb = new StringBuilder();
		sb.append("An�ncio: ");
		sb.append(getNomeA());
		sb.append("		    Cliente: ");
		sb.append(getNomeCliente() + "\n");
		sb.append("Data inicial: ");
		sb.append(sdf.format(getDataInicio()));
		sb.append("   	    Data t�rmino: ");
		sb.append(sdf.format(getDataTermino()) + "\n");
		sb.append("Investimento por dia: R$");
		sb.append(String.format("%.2f", getInvestimentoPorDia()) + "\n");
		Calculadora calc = new Calculadora(getNomeA(), getNomeCliente(), getDataInicio(), getDataTermino(),
				getInvestimentoPorDia());
		sb.append("Valor total investido: R$" + String.format("%.2f", calc.totalInvestido()) + "\n");
		sb.append("Quantidade m�xima de vizualiza��es: " + calc.qtdMaxVizualizacoes() + "\n");
		sb.append("Quantidade m�xima de cliques: " + calc.qtdMaxCliques() + "\n");
		sb.append("Quantidade m�xima de compartilhamentos: " + calc.qtdMaxCompartilhamento() + "\n");

		return sb.toString();
	}
}
