package controller;

import java.io.IOException;

import model.Pesquisa;

public interface ISteamController {

	public void busca(Pesquisa p,String caminho)throws IOException;
	
}
