package br.mackenzie.ps2.cmdcrud;

import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static br.mackenzie.ps2.utils.ES.*;

@SpringBootApplication
public class Main 
  implements CommandLineRunner {

    @Autowired
    private TitularRepo titularRepo;
    @Autowired
    private BancoRepo bancoRepo;
    public static void main(String[] args) {
            SpringApplication.run(Main.class, args);
    }

    private void criarTitular(){
      print("\n## CRIAÇÃO DE UM NOVO TITULAR:");
      long id = inputLong("\n## Id do novo titular: ");
      String nome = inputString("\n## Nome do novo titular: ");
      String rg = inputString("\n## Rg do novo titular: ");
      String cpf = inputString("\n## CPF do novo titular: ");
      Titular novoTitular = new Titular(id, nome, rg, cpf);
      titularRepo.save(novoTitular);
      print("\n## Novo titular criado com sucesso!");
    }

      

    private void lerTodosTitulares(){
      print("\n## LISTA DE TODOS OS TITULARES:");
      Iterable<Titular> titulares = titularRepo.findAll();
      for (Titular t: titulares) {
        print(String.format("- %s: %s; RG: %s; CPF: %S",
        t.getNroTitular(),t.getNome(),t.getRg(),t.getCpf()));

      }
    }

     private void lerTitularPeloId() {
        long id = inputLong("\n## Id do titular: ");
        Optional<Titular> opt = titularRepo.findById(id);
        if(opt.isPresent()){
            Titular t = opt.get();
            print(String.format("- %s: %s; RG: %s; CPF: %s",
            t.getNroTitular(),t.getNome(),t.getRg(),t.getCpf()));
        }
        else {
        print("\n## Não há um titular com o id "+ id);
        }
        
    }
    private void alterarTitular(){
      print("\n## ALTERAÇÃO DE UM TITULAR:");
      long id = inputLong("\n## Id do titular a ser alterado: ");
      Optional<Titular> opt = titularRepo.findById(id);
        if(opt.isPresent()){
            Titular t = opt.get();
            String nome = inputString(
              String.format("\n## Novo nome [%s]: ", t.getNome()));
            String rg = inputString(
                String.format("\n## Novo rg [%s]: ", t.getRg()));
            String cpf = inputString(
                  String.format("\n## Novo cpf [%s]: ", t.getCpf()));
            t.setNome(nome);
            t.setRg(rg);
            t.setCpf(cpf);
            titularRepo.save(t);
            print("\n## Titular alterado com sucesso!");

        }
        else {
        print("\n## Não há um titular com o id "+ id);
        }
      
    }
    

    private void apagarTitular(){
      print("\n## REMOÇÃO DE UM TITULAR:");
      long id = inputLong("\n## Id do titular a ser apagado: ");
      Optional<Titular> opt = titularRepo.findById(id);
        if(opt.isPresent()){
            Titular t = opt.get();
            titularRepo.delete(t);
            print("\n## Titular deletado com sucesso!");

        }
        else {
        print("\n## Não há um titular com o id "+ id);
        }
      
    }

    private void criarBanco(){
      print("\n## CRIAÇÃO DE UM NOVO BANCO:");
      long id = inputLong("\n## Id do novo banco: ");
      String n = inputString("\n## Nome Fantasia do novo banco: ");
      String r = inputString("\n## Razão Social do novo banco: ");
      String c = inputString("\n## CNPJ do novo banco: ");
      String q = inputString("\n## Quantidade de Agencias do novo banco: ");
      Banco novoBanco = new Banco(id, n, r, c, q);
      bancoRepo.save(novoBanco);
      print("\n## Novo banco criado com sucesso!");
    }

      

    private void lerTodosBancos(){
      print("\n## LISTA DE TODOS OS BANCOS:");
      Iterable<Banco> bancos = bancoRepo.findAll();
      for (Banco b: bancos) {
        print(String.format("- %s: %s; Razão Social: %s; CNPJ: %s; Quantidade de Agencias: %s",
        b.getNroBanco(),b.getNomeFantasia(),b.getRazaoSocial(),b.getCnpj(), b.getQuantidadeAgencias()));

      }
    }

     private void lerBancoPeloId() {
        long id = inputLong("\n## Id do banco: ");
        Optional<Banco> opt = bancoRepo.findById(id);
        if(opt.isPresent()){
            Banco b = opt.get();
            print(String.format("- %s: %s; Razão Social: %s; CNPJ: %s; Quantidade de Agencias: %s",
        b.getNroBanco(),b.getNomeFantasia(),b.getRazaoSocial(),b.getCnpj(), b.getQuantidadeAgencias()));
        }
        else {
        print("\n## Não há um Banco com o id "+ id);
        }
        
    }
    private void alterarBanco(){
      print("\n## ALTERAÇÃO DE UM BANCO:");
      long id = inputLong("\n## Id do banco a ser alterado: ");
      Optional<Banco> opt = bancoRepo.findById(id);
        if(opt.isPresent()){
            Banco b = opt.get();
            String n = inputString(
              String.format("\n## Novo nome fantasia [%s]: ", b.getNomeFantasia()));
            String r = inputString(
                String.format("\n## Nova razão social [%s]: ", b.getRazaoSocial()));
            String c = inputString(
                  String.format("\n## Novo cnpj [%s]: ", b.getCnpj()));
            String q = inputString(
                    String.format("\n## Novo quantidade de agencias [%s]: ", b.getQuantidadeAgencias()));
            b.setNomeFantasia(n);
            b.setRazaoSocial(r);
            b.setCnpj(c);
            b.setQuantidadeAgencias(q);
            bancoRepo.save(b);
            print("\n## Banco alterado com sucesso!");

        }
        else {
        print("\n## Não há um Banco com o id "+ id);
        }
      
    }
    

    private void apagarBanco(){
      print("\n## REMOÇÃO DE UM BANCO:");
      long id = inputLong("\n## Id do banco a ser apagado: ");
      Optional<Banco> opt = bancoRepo.findById(id);
        if(opt.isPresent()){
            Banco b = opt.get();
            bancoRepo.delete(b);
            print("\n## Banco deletado com sucesso!");

        }
        else {
        print("\n## Não há um Banco com o id "+ id);
        }
      
    }
    @Override
    public void run(String... args) {
        print("\n## GERENCIADOR DE TITULARES E BANCOS ##");

        boolean sair = false;
        while(!sair){
          print("\n## MENU:");
          print("(1) Criar titular");
          print("(2) Ler todos os titulares");
          print("(3) Ler titular pelo ID");
          print("(4) Alterar um titular");
          print("(5) Apagar um titular");
          print("(6) Criar banco");
          print("(7) Ler todos os bancos");
          print("(8) Ler banco pelo ID");
          print("(9) Alterar um banco");
          print("(10) Apagar um banco");
          print("(0) Sair");
          int op = inputInt("Escolha uma opção: ");
          switch(op){
          case 1: criarTitular(); break;
          case 2: lerTodosTitulares(); break;
          case 3: lerTitularPeloId(); break;
          case 4: alterarTitular(); break;
          case 5: apagarTitular(); break;
          case 6: criarBanco(); break;
          case 7: lerTodosBancos(); break;
          case 8: lerBancoPeloId(); break;
          case 9: alterarBanco(); break;
          case 10: apagarBanco(); break;
          case 0: sair = true; break;
          default: print("\n## Opção invalida!");

          }
    
        }

        print("\n## FIM DO PROGRAMA! ##");
    }
    
}
