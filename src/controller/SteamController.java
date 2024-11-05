package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import br.edu.fateczl.Lista.Lista;
import model.Pesquisa;

public class SteamController implements ISteamController{

	@Override
	public void busca(Pesquisa p,String caminho) throws IOException {
		
		Lista <Pesquisa> pesq=new Lista<>();
		
		File dir=new File(caminho);
		
		if(dir.exists()&&dir.isFile()){
			
		BufferedReader br=new BufferedReader(new FileReader(dir));
		
		String linha=br.readLine();
		
		while(linha!=null) {
			String[]vetlinha=linha.split(",");
			if(vetlinha[2].equals(p.getMes())&&vetlinha[1].equals(p.getAno())&&Double.parseDouble(vetlinha[3])>=p.getMedia()) {
				Pesquisa aux=new Pesquisa();
				aux.setAno(vetlinha[1]);
				aux.setNome(vetlinha[0]);
				aux.setMes(vetlinha[2]);
				aux.setMedia(Double.parseDouble(vetlinha[3]));
				pesq.addFirst(aux);
			}
			linha=br.readLine();		
		}
		br.close();		
		}
		
//		while(!pesq.isEmpty()) {
//			
//			try {
//				Pesquisa aux2;
//				aux2 = pesq.get(0);
//				System.out.println(aux2.getNome() +"\t"+aux2.getMedia());
//				pesq.removeFirst();
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			
//		}
		//novoarquivo(pesq);
		
	}

	//private void //novoarquivo(Lista<Pesquisa> pesq) {
		// TODO Auto-generated method stub
		
	//}

	
}
