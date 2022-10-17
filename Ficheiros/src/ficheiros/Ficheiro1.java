
package ficheiros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


class Ficheiro1 {
    
    static void criaFicheiro() {
            String nome;
        System.out.println("Insira o nome do ficheiro a criar");
        nome = Ficheiros.ler.nextLine();
        nome = Ficheiros.ler.next();
        File ficheiro = new File (nome);
        if(!ficheiro.exists()){
                try {
                    ficheiro.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
        }
    }

    static void verificaFicheiro() {
       String nome;
        System.out.println("Insira o nome do ficheiro a criar");
        nome = Ficheiros.ler.nextLine();
        nome = Ficheiros.ler.next();
        File ficheiro = new File (nome);
        if(!ficheiro.exists()){
               System.out.println("O ficheiro não existe");
            
        } else{
            System.out.println("O ficheiro existe");
            
    }
    }

    static void escreveNoFinalFicheiro() {
        String nome;
        System.out.println("Insira o nome do ficheiro a criar");
        nome = Ficheiros.ler.nextLine();
        nome = Ficheiros.ler.next();
        File ficheiro = new File (nome);
        try {
            if(!ficheiro.exists()){        
                ficheiro.createNewFile(); 
                } 
                FileWriter fw = new FileWriter(ficheiro, true);
                BufferedWriter bw = new BufferedWriter (fw);
                String texto;
                System.out.println("Insira o conteudo");
                texto = Ficheiros.ler.nextLine();
                texto = Ficheiros.ler.nextLine();
                bw.write(texto);
                bw.newLine();
                bw.close();
                fw.close();
            } catch (IOException ex){
                ex.printStackTrace(); }
        
          }
    
    static void escreveFicheiroNovo() {
        String nome;
        System.out.println("Insira o nome do ficheiro a criar");
        nome = Ficheiros.ler.nextLine();
        nome = Ficheiros.ler.next();
        File ficheiro = new File (nome);
        try {
            if(!ficheiro.exists()){        
                ficheiro.createNewFile(); 
            } 
                FileWriter fw = new FileWriter(ficheiro);
                BufferedWriter bw = new BufferedWriter (fw);
                String texto;
                System.out.println("Insira o conteudo");
                texto = Ficheiros.ler.nextLine();
                texto = Ficheiros.ler.nextLine();
                bw.write(texto);
                bw.newLine();
                bw.close();
                fw.close();
            } catch (IOException ex){
                ex.printStackTrace(); }
        
          }

    static void mostraConteudoFicheiro() {
        String nome;
        System.out.println("Insira o nome do ficheiro....");
        nome = Ficheiros.ler.nextLine();
        nome = Ficheiros.ler.nextLine();
        File ficheiro = new File (nome);
        
        if (!ficheiro.exists()){
            System.out.println("O ficheiro não existe");
            
        } else{
            try{
                FileReader fr = new FileReader(ficheiro);
                BufferedReader br = new BufferedReader(fr);
                while (br.ready()){
                    String linha = br.readLine();
                    System.out.println(linha);
                }
                br.close();
                fr.close();
            }catch (FileNotFoundException ex){
                ex.printStackTrace();
            } catch (IOException ioe){
                ///falta codigo
            }
        
         }
    }

    static void mostraListaFicheiros() {
        File ficheiro = new File("C:\\Users\\AnaCoelho\\Desktop\\Projeto_Java\\Ficheiros");
        File [] lista = ficheiro.listFiles();
        System.out.println(">>> Lista de Ficheiros <<<");
        for (int x = 0; x < lista.length;x++){
            System.out.println(lista[x].getName());
    }
           }
    
    
}
