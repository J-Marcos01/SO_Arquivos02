package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import br.edu.fateczl.Lista.Lista;
import model.Pesquisa;

public class SteamController implements ISteamController {

	@Override
	public void busca(Pesquisa p, String caminho) throws IOException {

		Lista<Pesquisa> pesq = new Lista<>();

		File dir = new File(caminho);

		if (dir.exists() && dir.isFile()) {

			BufferedReader br = new BufferedReader(new FileReader(dir));

			String linha = br.readLine();
			System.out.printf("%-35s %-25s%n", "Nome Jogo", "Média de Jogadores ativos");

			while (linha != null) {
				String[] vetlinha = linha.split(",");

				if (vetlinha[2].equals(p.getMes()) && vetlinha[1].equals(p.getAno())
						&& Double.parseDouble(vetlinha[3]) >= p.getMedia()) {

					Pesquisa aux = new Pesquisa();

					aux.setAno(vetlinha[1]);
					aux.setNome(vetlinha[0]);
					aux.setMes(vetlinha[2]);
					aux.setMedia(Double.parseDouble(vetlinha[3]));

					System.out.printf("%-35s %-25s%n", aux.getNome(), aux.getMedia());

					pesq.addFirst(aux);

				}
				linha = br.readLine();
			}
			br.close();
		}

		try {
			novoarquivo(pesq, "C:\\TEMP\\nome.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void novoarquivo(Lista<Pesquisa> pesq, String path) throws Exception {

		File caminho = new File(path);
		FileWriter wr = new FileWriter(caminho);

		if (caminho.exists() && caminho.isFile()) {

			Pesquisa aux;
			StringBuffer sb = new StringBuffer();
			wr.write("Nome do jogo;Média de jogadores ativos\r\n");
			while (!pesq.isEmpty()) {

				try {

					aux = pesq.get(0);

					sb.append(aux.getNome());
					sb.append(";");
					sb.append(aux.getMedia());
					wr.write(sb.toString() + "\r\n");
					sb.setLength(0);// zerei meu bufferstring para receber novos dados

					pesq.removeFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			wr.close();
		} else {
			System.out.println("Caminho inválido");
		}
	}
}
