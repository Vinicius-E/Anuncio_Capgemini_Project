package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.exception.DomainException;

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
		@SuppressWarnings("deprecation")
		Date dataInicioFiltro = new Date((anoI - 1900), (mesI - 1), diaI); // TRABALHANDO COM VERSÃO DESATUALIZADA...
		@SuppressWarnings("deprecation")
		Date dataTerminoFiltro = new Date((anoT - 1900), (mesT - 1), diaT);

		for (Anuncio a : anuncios) {
			if (dataInicioFiltro.getTime() == a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() == a.getDataTermino().getTime()) {

				System.out.println(a.toString());
				System.out.println();

			} else if (dataInicioFiltro.getTime() >= a.getDataInicio().getTime()
					&& dataInicioFiltro.getTime() < a.getDataTermino().getTime()
					&& dataTerminoFiltro.getTime() >= a.getDataTermino().getTime()) {

				System.out.println(a.toStringT(dataInicioFiltro, a.getDataTermino()));
				System.out.println();

			} else if (dataInicioFiltro.getTime() < a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() > a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() <= a.getDataTermino().getTime()) {

				System.out.println(a.toStringI(a.getDataInicio(), dataTerminoFiltro));
				System.out.println();

			} else if (dataInicioFiltro.getTime() >= a.getDataInicio().getTime()
					&& dataTerminoFiltro.getTime() <= a.getDataTermino().getTime()) {
				if (!dataTerminoFiltro.after(dataInicioFiltro)) {
					throw new DomainException("Data de término deve ser posterior a data de início");
				}

				System.out.println(a.toStringTI(dataInicioFiltro, dataTerminoFiltro));
				System.out.println();

			} else if (dataInicioFiltro.getTime() < a.getDataTermino().getTime()
					&& dataTerminoFiltro.getTime() >= a.getDataTermino().getTime()) {

				System.out.println(a.toString());
				System.out.println();

			}
		}
	}
}
