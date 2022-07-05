import java.util.Scanner;

import javax.xml.transform.Source;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Date;

public class App {
    

    public static void main(String[] args) throws Exception {


      


        


        String[] perguntas = {"Qual o seu tipo de música favorita ?",
        "Você quer ouvir uma piada ?",
         "Qual a sua idade ?", "Ferrari"};

       
       

        Scanner leitor = new Scanner(System.in);
       
       
        

        
        System.out.println("........................................................");
        System.out.print("Olá tudo bem? Eu sou a Nina !\n \n Como você se chama ? \n:");
        String nomeUsuario = leitor.nextLine();
        System.out.println("\nEi "+ nomeUsuario + " Prazer em te conhecer !\n");
        System.out.print(" Você quer começar o programa ? \n  Digite s para sim e n para não.\n:");
        String inciarPrograma = leitor.nextLine().toLowerCase();


        
        if (inciarPrograma.equals("s") || inciarPrograma.equals("sim")){
            for(int i = 0 ; i < 4; i++){
                String pergunta = perguntas[i];
                System.out.println(pergunta);
                String resposta = leitor.nextLine();
                if (pergunta.equals(perguntas[0])){
                    
                    System.out.println("Eu também gosto de "+ resposta);
                }
                if(pergunta.equals(perguntas[1])){
                    while (resposta.equals("sim")|| resposta.equals("s")) {
                        contarPiada();
                        System.out.println(".....................");
                        System.out.print("Você quer ouvir outra piada  s ou n ?\n :");
                        resposta = leitor.nextLine();
                    }
                    
                    
                }
                if(pergunta.equals(perguntas[2])){

                    int res = Integer.parseInt(resposta);
                    System.out.print("Em que mês você nasceu ? \n :");
                    String mes = leitor.nextLine().toLowerCase();
                    int anoNascido = descobrirAno(res,mes );
                    System.out.println("Um vejo que você nasceu em "+ anoNascido);
                    System.out.print(".................");
                    DateTimeFormatter mesAtual = DateTimeFormatter.ofPattern("MM");
                    String m = mesAtual.format(LocalDateTime.now());
                    int mm = Integer.parseInt(m);
                    int ms = 7;
                    int c = mm -ms;
                    if(c <0){
                        c = -c;
                    }


                    Thread.sleep(3000);

                    System.out.println("Você está vivo há "+res +" anos e "+c+" meses");

                }

                    
                }
                
            }

        
        else{
            System.out.println("Que pena "+ nomeUsuario +" queria falar com você");
        }

        leitor.close();


    }
    public static String geraPergunta(String perguntas[]){
        //**Estou tentado implementar essa classe ainda  */

        
        Random seletor = new Random();
        int indice = seletor.nextInt(4);
        String pergunta = perguntas[indice];
        return pergunta;
        
    }


    public static int descobrirAno(int idade, String mesDeNascimento){
        
        String meses[]={"janeiro", "fevereiro", "março", "abril", "maio", "junho", "julho", "agosto", "setembro", "outubro", "novembro" ,"dezembro"
        };

        int mes = buscaIndice(meses, mesDeNascimento);
        DateTimeFormatter ano = DateTimeFormatter.ofPattern("yyyy");
        
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH:mm:ss ");

        DateTimeFormatter mesAtual = DateTimeFormatter.ofPattern("MM");
        String m = mesAtual.format(LocalDateTime.now());
        int mm = Integer.parseInt(m);

        String dia = ano.format(LocalDateTime.now());

        int n = Integer.parseInt(dia);
        
        Boolean s = mm > mes;
        if(s){
            
        idade = n - idade;
         
        }
        else{
            idade = n - idade-1;
        }
        return idade;

        
    }



    public static void contarPiada() throws FileNotFoundException, InterruptedException{
        Scanner scanner = new Scanner(new FileReader("C:\\Users\\JYrik\\chatBot\\chatBot\\src\\piadas.txt")) .useDelimiter("\\\\||\\\\n"); 
        Random seletor = new Random();
        int indice;
        do{
        indice = seletor.nextInt(81);
        }
        while( indice % 3 !=0);
        String piada;

        for(int i = 0 ; i < indice+2; i++){
            piada = scanner.nextLine();
            if ( i == indice){
            System.out.println(piada);
            Thread.sleep(3000);
            System.out.print("......");
            Thread.sleep(3000);
            System.out.println(scanner.nextLine());
            }
        }

        scanner.close();
         
           
       
    }




    public static int buscaIndice(String array[], String procurar){
        int indice;
        int achado = 0 ;
        for(indice = 0 ; indice< array.length ; indice++){
            if(array[indice].equals(procurar)){
                achado = indice;
            }

        }
        return achado+1;

    }
   
    
}