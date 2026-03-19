package Atividade;

import java.util.Scanner;

public class TV02 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean ligada = false;
        int canal = 1;
        int volume = 10;
        int volumeAntesDoMute = 10;
        int opcaoEscolhida = 0;
        boolean mute = false;

        String menu = """
                --- CONTROLE DA TV ---
                1 -> Ligar televisao
                2 -> Desligar Televisao
                3 -> Subir / Descer Canal
                4 -> Ir para canal Especifico
                5 -> Aumentar Volume
                6 -> Diminuir Volume
                7 -> Mutar / Desmutar
                8 -> Finalizar Programa
                """;

        while (opcaoEscolhida != 8) {
            System.out.println("\n STATUS: " + (ligada ? "LIGADA" : "DESLIGADA") + " | CANAL: " + canal + " | VOLUME: " + (mute ? "MUDO" : volume) + " ]"); //aqui usei operador ternario, meio que um "if else" de uma unica linha
            System.out.println("\n" + menu);
            System.out.println("Escolha uma opcao: ");
            opcaoEscolhida = sc.nextInt();
            sc.nextLine();
            
            switch (opcaoEscolhida) {
                case 1:
                    if (ligada) {
                        System.out.println("TV ja esta ligada!");
                    } else {
                        ligada = true;
                        System.out.println("TV ligada com sucesso");
                    }
                    break;
                case 2:
                    if (!ligada) {
                        System.out.println("A TV ja esta desligada!");
                    } else {
                        ligada = false;
                        System.out.println("TV desligada com sucesso");
                    }
                    break;
                case 3:
                    if (!ligada) {
                        System.out.println(" ->ERRO: Ligue a TV primeiro!!!");
                    } else {
                        System.out.println("Digite 1 para Subir de canal ou 2 para Descer o canal: ");
                        int acaoCanal = sc.nextInt();
                        sc.nextLine();
                        if (acaoCanal == 1) {
                            canal ++;
                        } else if (acaoCanal == 2 && canal > 1) {
                            canal --;
                        } else {
                            System.out.println("Acao invalida ou limite do canal atingido.");
                        }
                    }
                    break;
                case 4:
                    if (!ligada) {
                        System.out.println(" ->ERRO: Primeiro ligue a TV");
                    } else {
                        System.out.println("Digite o numero do canal: ");
                        int novoCanal = sc.nextInt();
                        sc.nextLine();
                        if (novoCanal > 0) {
                            canal = novoCanal;
                        } else {
                            System.out.println("Canal Invalido!!!");
                        }
                    }
                    break;
                case 5:
                    if (!ligada) {
                        System.out.println(" ->ERRO: Primeiro ligue a TV");
                    } else {
                        if (mute) {
                            mute = false;
                            volume = volumeAntesDoMute;
                        }// Tira o mute se mexer no volume

                        if (volume < 100) {
                            volume ++;
                        } else {
                            System.out.println("Volume Maximo Atingido!!!");
                        }
                    }
                    break;
                case 6:
                    if (!ligada) {
                        System.out.println(" ->ERRO: Primeiro ligue a TV");
                } else {

                    if (mute) {
                        mute = false;
                        volume = volumeAntesDoMute;
                    }// Tira o mute se mexer no volume

                    if (volume > 0) {
                        volume --;
                    } else {
                        System.out.println("Volume Minimo Atingido!!!");
                    }
                }
                    break;
                case 7:
                    if (!ligada) {
                        System.out.println(" ->ERRO: Primeiro ligue a TV");
                    } else {
                        if (mute) {
                            mute = false;
                            volume = volumeAntesDoMute; // Devolve o volume antigo
                        } else {
                            mute = true;
                            volumeAntesDoMute = volume; // Salva o volume atual
                            volume = 0;
                        }
                    }
                    break;
                case 8:
                    System.out.println(" ->Desligando o sistema...");
                    break;
                default:
                    System.out.println(" ->ERRO: Opcao invalida!!! Tente novamente.");
            }
        }
        sc.close();
    }
}
