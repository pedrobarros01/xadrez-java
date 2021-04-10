package Xadrez.aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import Xadrez.xadrezin.cor;
import Xadrez.xadrezin.jogador;
import Xadrez.xadrezin.partidaxadrez;
import Xadrez.xadrezin.xadrezpeca;
import Xadrez.xadrezin.xadrezposicao;

public class UI {
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	    public static final String ANSI_RESET = "\u001B[0m";
	    public static final String ANSI_BLACK = "\u001B[30m";
	    public static final String ANSI_RED = "\u001B[31m";
	    public static final String ANSI_GREEN = "\u001B[32m";
	    public static final String ANSI_YELLOW = "\u001B[33m";
	    public static final String ANSI_BLUE = "\u001B[34m";
	    public static final String ANSI_PURPLE = "\u001B[35m";
	    public static final String ANSI_CYAN = "\u001B[36m";
	    public static final String ANSI_WHITE = "\u001B[37m";

	    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    public static void limparTelaConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static String[] lerNomes(Scanner scan){
        String[] nome = new String[2];
        for (int i = 0; i < nome.length; i++) {
            System.out.print("Digite seu nome jogador #"+ (i+1) + ":");
            nome[i] = scan.next();
        }
        return nome;
    }

    public static xadrezposicao lerPosicaoXadrez(Scanner scan){
        try{
        String s = scan.nextLine();
        char coluna = s.charAt(0);
        int linha = Integer.parseInt(s.substring(1));
        return new xadrezposicao(coluna, linha);
        }
        catch(RuntimeException e){
            throw new InputMismatchException("erro lendo posicao de xadrez, valores validos sao de a1 a h8");
        }

    }
    public static void printarPartida(partidaxadrez partidaxadrez, String[] nome){
        printartabuleiro(partidaxadrez.getpecas());
        System.out.println();
        System.out.println("Turno: " + partidaxadrez.getTurno());
        if(partidaxadrez.getJogador().getCorjogadoratual() == cor.WHITE){
            partidaxadrez.getJogador().setNome(nome[0]);
            System.out.println("Esperando "+ partidaxadrez.getJogador().getNome()+ " jogar");

        }else{
            partidaxadrez.getJogador().setNome(nome[1]);
            System.out.println("Esperando "+ partidaxadrez.getJogador().getNome() + " jogar");
        }

        
    }
    public static void printartabuleiro(xadrezpeca[][] pecas){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarpeca(pecas[i][j], false);
                
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");

    }
    public static void printartabuleiro(xadrezpeca[][] pecas, boolean[][] possiveismovimentos){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8-i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarpeca(pecas[i][j], possiveismovimentos[i][j]);
                
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
        

    }
    private static void printarpeca(xadrezpeca peca, boolean telaDeFundo){
        if(telaDeFundo == true){
            System.out.print(ANSI_CYAN_BACKGROUND);
        }
        if(peca == null){
            System.out.print("-" + ANSI_RESET);
        }else{
            if(peca.getCorzinha() == cor.WHITE){
                System.out.print(ANSI_WHITE + peca + ANSI_RESET);
            }else{
                System.out.print(ANSI_RED + peca + ANSI_RESET);
            }
        }
        System.out.print(" ");

    }

}
