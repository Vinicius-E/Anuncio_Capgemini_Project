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
			else {
				System.out.println("Este cliente não possui nenhum anúncio!");
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
				
			} else if (dataInicioFiltro.getTime() >= a.getDataInicio().getTime()
					&& dataInicioFiltro.getTime() < a.getDataTermino().getTime()
					&& dataTerminoFiltro.getTime() >= a.getDataTermino().getTime()) {

				System.out.println("CAIU NO SEGUNDO");
				System.out.println(a.toStringT(dataInicioFiltro, a.getDataTermino()));
				System.out.println();
				
			} else if (dataInicioFiltro.getTime() < a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() > a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() <= a.getDataTermino().getTime()) {
				
				System.out.println("CAIU NO TERCEIRO");
				System.out.println(a.toStringI(a.getDataInicio(), dataTerminoFiltro));
				System.out.println();
				
			} else if (dataInicioFiltro.getTime() >= a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() <= a.getDataTermino().getTime()) {
				
				System.out.println("CAIU NO QUARTO");
				System.out.println(a.toStringTI(dataInicioFiltro, dataTerminoFiltro));
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
