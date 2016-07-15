package principal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;


public class GerarCPF {

	public static void imprimir(ArrayList<String> aux){
		for(String a : aux){
			System.out.println(a.toString());
		}
	}

	public static String[] partir(){
		String[] retorno = new String[2];
		String fim = "10749305410+1234";
		StringTokenizer st = new StringTokenizer(fim, "+", false);
		int posicao = 0;
//		while(st.hasMoreTokens()){
		retorno[posicao] = st.nextToken();
		posicao++;
		retorno[posicao] = st.nextToken();
		//		}

		return retorno;
	}



	public static void main(String[] args) {
		ArrayList<String> cpf = new ArrayList<String>();

		int quantidadeCpfs = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Digite a quantidade de CPF's a serem gerados: ");
		quantidadeCpfs = scan.nextInt();

		for(int i = 0; i < quantidadeCpfs; i++){
			String aux = geradorDeCPF();
			while(!cpf.contains(aux)){
				cpf.add(aux);
			}
		}

		imprimir(cpf);

//		String[] resultado = partir();
//		for(int i = 0; i < resultado.length; i++){
//			System.out.println(resultado[i]);
//		}

	}

	public static int aleatoriar(int minimo, int maximo) {
	    Random random = new Random();
	    return random.nextInt((maximo - minimo) + 1) + minimo;
	}

	public static String geradorDeCPF(){
		int soma = 0, resto = 0;
        int[] multiplicador1 = { 10, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] multiplicador2 = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2 };

		String semente = Integer.toString(aleatoriar(100000000, 999999999));

		for (int i = 0; i < 9; i++){
            soma += Integer.parseInt(Character.toString(semente.charAt(i))) * multiplicador1[i];
		}

		resto = soma % 11;
        if (resto < 2){
        	resto = 0;
        }
        else{
        	resto = 11 - resto;
        }

        semente = semente + resto;
        soma = 0;

        for (int i = 0; i < 10; i++){
            soma += Integer.parseInt(Character.toString(semente.charAt(i))) * multiplicador2[i];
        }

        resto = soma % 11;

        if (resto < 2){
        	resto = 0;
        }
        else{
        	resto = 11 - resto;
        }

        semente = semente + resto;
        return semente;


	}



}
