package entities;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calculadora extends Anuncio {

	public Calculadora(String nomeA, String nomeCliente, Date dataInicio, Date dataTermino, Double investimentoPorDia) {
		super(nomeA, nomeCliente, dataInicio, dataTermino, investimentoPorDia);
	}

	public int vizualizacaoInicial() {
		int vizualizacaoInicial = (int) (getInvestimentoPorDia() * 30 / 1);
		return vizualizacaoInicial;
	}

	public int qtdCliques() {
		int qtdCliques = vizualizacaoInicial() * 12 / 100;
		return qtdCliques;
	}

	public int qtdCompartilhamento() {
		int qtdCompartilhamento = (qtdCliques() * 3 / 20) * 4;
		return qtdCompartilhamento;
	}

	public int novasVizualizacoes() {
		int novasVizualizacoes = qtdCompartilhamento() * 40;
		return novasVizualizacoes;
	}

	public int qtdDias() {
		long diffEmil = getDataTermino().getTime() - getDataInicio().getTime();
		long diff = TimeUnit.DAYS.convert(diffEmil, TimeUnit.MILLISECONDS);
		int diferencaDias = (int) diff;
		return diferencaDias;
	}

	public int qtdDiasFiltroT(Date dataInicioFiltro, Date getDataTermino) {
		long diffEmil = getDataTermino.getTime() - dataInicioFiltro.getTime();
		long diff = TimeUnit.DAYS.convert(diffEmil, TimeUnit.MILLISECONDS);
		int diferencaDias = (int) diff;
		return diferencaDias;
	}

	public int qtdDiasFiltroI(Date getDataInicio, Date dataTerminoFiltro) {
		long diffEmil = dataTerminoFiltro.getTime() - getDataInicio.getTime();
		long diff = TimeUnit.DAYS.convert(diffEmil, TimeUnit.MILLISECONDS);
		int diferencaDias = (int) diff;
		return diferencaDias;
	}

	public int qtdDiasFiltroTI(Date dataInicioFiltro, Date dataTerminoFiltro) {
		long diffEmil = dataTerminoFiltro.getTime() - dataInicioFiltro.getTime();
		long diff = TimeUnit.DAYS.convert(diffEmil, TimeUnit.MILLISECONDS);
		int diferencaDias = (int) diff;
		return diferencaDias;
	}

	public int qtdMaxVizualizacoes() {
		int qtdMaxVizualizacoes = qtdDias() * (vizualizacaoInicial() + novasVizualizacoes());
		return qtdMaxVizualizacoes;
	}

	public int qtdMaxVizualizacoesFiltroT(Date dataInicioFiltro, Date getDataTermino) {
		int qtdMaxVizualizacoes = qtdDiasFiltroT(dataInicioFiltro, getDataTermino)
				* (vizualizacaoInicial() + novasVizualizacoes());
		return qtdMaxVizualizacoes;
	}

	public int qtdMaxVizualizacoesFiltroI(Date getDataInicio, Date dataTerminoFiltro) {
		int qtdMaxVizualizacoes = qtdDiasFiltroT(getDataInicio, dataTerminoFiltro)
				* (vizualizacaoInicial() + novasVizualizacoes());
		return qtdMaxVizualizacoes;
	}

	public int qtdMaxVizualizacoesFiltroTI(Date dataInicioFiltro, Date dataTerminoFiltro) {
		int qtdMaxVizualizacoes = qtdDiasFiltroT(dataInicioFiltro, dataTerminoFiltro)
				* (vizualizacaoInicial() + novasVizualizacoes());
		return qtdMaxVizualizacoes;
	}

	public double totalInvestido() {
		double totalInvestido = getInvestimentoPorDia() * qtdDias();
		return totalInvestido;
	}

	public double totalInvestidoFiltroT(Date dataInicioFiltro, Date getDataTermino) {
		double totalInvestido = (getInvestimentoPorDia() * qtdDiasFiltroT(dataInicioFiltro, getDataTermino));
		return totalInvestido;
	}

	public double totalInvestidoFiltroI(Date getDataInicio, Date dataTerminoFiltro) {
		double totalInvestido = (getInvestimentoPorDia() * qtdDiasFiltroT(getDataInicio, dataTerminoFiltro));
		return totalInvestido;
	}

	public double totalInvestidoFiltroTI(Date dataInicioFiltro, Date dataTerminoFiltro) {
		double totalInvestido = (getInvestimentoPorDia() * qtdDiasFiltroT(dataInicioFiltro, dataTerminoFiltro));
		return totalInvestido;
	}

	public int qtdMaxCliques() {
		return qtdCliques() * qtdDias();
	}

	public int qtdMaxCliquesFiltroT(Date dataInicioFiltro, Date getDataTermino) {
		return qtdCliques() * qtdDiasFiltroT(dataInicioFiltro, getDataTermino);
	}

	public int qtdMaxCliquesFiltroI(Date getDataInicio, Date dataTerminoFiltro) {
		return qtdCliques() * qtdDiasFiltroT(getDataInicio, dataTerminoFiltro);
	}

	public int qtdMaxCliquesFiltroTI(Date dataInicioFiltro, Date dataTerminoFiltro) {
		return qtdCliques() * qtdDiasFiltroT(dataInicioFiltro, dataTerminoFiltro);
	}

	public int qtdMaxCompartilhamento() {
		return qtdCompartilhamento() * qtdDias();
	}

	public int qtdMaxCompartilhamentoFiltroT(Date dataInicioFiltro, Date dataTerminoFiltro) {
		return qtdCompartilhamento() * qtdDiasFiltroT(dataInicioFiltro, dataTerminoFiltro);
	}

	public int qtdMaxCompartilhamentoFiltroI(Date dataInicioFiltro, Date dataTerminoFiltro) {
		return qtdCompartilhamento() * qtdDiasFiltroT(dataInicioFiltro, dataTerminoFiltro);
	}

	public int qtdMaxCompartilhamentoFiltroTI(Date dataInicioFiltro, Date dataTerminoFiltro) {
		return qtdCompartilhamento() * qtdDiasFiltroT(dataInicioFiltro, dataTerminoFiltro);
	}
}
