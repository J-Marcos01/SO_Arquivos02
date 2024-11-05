package view;

import java.io.IOException;

import javax.swing.JOptionPane;

import controller.SteamController;
import model.Pesquisa;

public class Principal {

	public static void main(String[] args) {
		
		SteamController steam = new SteamController();
		
		String caminho="C:\\TEMP\\SteamCharts.csv";
		Pesquisa pesquisa = new Pesquisa();
		String mes=JOptionPane.showInputDialog(null,"Digite o mês : ","Pesquisa de jogo",JOptionPane.INFORMATION_MESSAGE);
		String ano=JOptionPane.showInputDialog(null,"Digite o ano : ","Pesquisa de jogo",JOptionPane.INFORMATION_MESSAGE);
		Double media=Double.parseDouble(JOptionPane.showInputDialog(null,"Digite a média de jogadores desejada : ","Pesquisa de jogo",JOptionPane.INFORMATION_MESSAGE));
		
		pesquisa.setMes(mes);
		pesquisa.setAno(ano);
		pesquisa.setMedia(media);
		
		try {
			steam.busca(pesquisa, caminho);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
