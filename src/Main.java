import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  private static Scanner s;
  private static Usuario atual;
  private static ArrayList<Animal> animais = new ArrayList<>();
  private static ArrayList<Usuario> usuarios = new ArrayList<>();
  private static Map<String, String> usuariosCredenciais = new HashMap<>();
  private static int op = 0;

  static {
    usuariosCredenciais.put("joao", "senha1");
    usuariosCredenciais.put("maria", "senha2");
    usuariosCredenciais.put("isabela", "12345a");
  }

  public static void main(String[] args) {

    s = new Scanner(System.in);

    System.out.println("Digite o seu login: ");

    String usuarioDigitado = s.nextLine();

    System.out.println("Digite a senha: ");

    String senhaDigitada = s.nextLine();

    if (autenticarUsuario(usuarioDigitado, senhaDigitada)) {
      System.out.println("Usuário autenticado. Bem-vindo, " + usuarioDigitado + "!");
      atual = new Usuario();
      while (op != 12) {
        menu();
      }
    } else {
      System.out.println("Credenciais inválidas. Acesso negado.");
    }
  }

  public static boolean autenticarUsuario(String usuario, String senha) {
    String senhaArmazenada = usuariosCredenciais.get(usuario);
    return senhaArmazenada != null && senhaArmazenada.equals(senha);
  }

  private static void menu() {

    System.out.println("\n----------Menu----------");
    System.out.println("\n----------USUARIO----------");
    System.out.println("1. Cadastrar novo usuário");

    if (atual != null) {
      System.out.println("2. Editar dados do usuário.");
      System.out.println("3. Apagar usuário atual.");

      if (!animais.isEmpty())
        System.out.println("4. Vincular Animal ao Usuário.");
      System.out.println("5. Mostrar os dados do Usuário atual.");
      System.out.println("6. Listar os Animais deste Usuário");
    }
    System.out.println("------- ANIMAIS -------");
    System.out.println("7. Cadastrar novo animal");
    if (!animais.isEmpty()) {
      System.out.println("8. Editar Animal");
      System.out.println("9. Listar os animais cadastrados");
    }
    System.out.println("------- LOGIN -------");
    System.out.println("10.Adicionar credenciais de Login");
    System.out.println("11.Listar as credenciais de Login");
    System.out.println("12.Sair");

    op = s.nextInt();
    s.nextLine();

    switch (op) {
      case 1:
        cadastrarUsuario();
        break;
      case 2:
        if (atual != null) {
          mostrarUsuario();
          editarUsuario();
        }
        break;
      case 3:
        if (atual != null) {
          mostrarUsuario();
          apagarUsuario();
        }
        break;
      case 4:
        if (atual != null) {
          listarAnimais(animais);
          Animal selecionado = selecionaAnimal();
          if (selecionado != null) {
            vincularAnimal(selecionado);
            System.out.println("Animal vinculado com sucesso!!!!");
          } else
            System.out.println("Animal nao encontrado!!!!");
        }
        break;
      case 5: // mostrar Usuario
        if (atual != null) {
          mostrarUsuario();
        }
        break;
      case 6: // Animais do Usuario
        if (atual != null) {
          listarAnimais(atual.getAnimais());
        }
        break;
      case 7: // Cadastrar Animal
        cadastrarAnimal();
        break;
      case 8: // Editar Animal
        if (!animais.isEmpty()) {
          listarAnimais(animais);
          Animal modificado = selecionaAnimal();
          if (modificado != null)
            editarAnimal(modificado);
          else
            System.out.println("Nao foi possivel encontrar esse animal");
        }
        break;
      case 9: // Animais
        listarAnimais(animais);
        break;
      case 10:
        cadastrarLogin();
        break;
      case 11:
        listarLogins();
        break;
      case 12:
        sair();
        break;
    }
  }

  public static void editarAnimal(Animal modificado) {
    mostraAnimal(modificado);

    System.out.println("Digite qual item deseja modificar: ");
    System.out.println("1 - Observacoes");
    System.out.println("2 - Peso");
    int opMod = s.nextInt();
    s.nextLine();
    if (opMod == 1) {
      System.out.println("Digite as novas observacoes: ");
      modificado.setObservacoes(s.nextLine());
    } else if (opMod == 2) {
      System.out.println("Digite o novo peso: ");
      modificado.setPeso(s.nextDouble());
      s.nextLine();
    }
    System.out.println("\n------- Dados do animal editados com sucesso! -------\n");
  }

  private static void mostraAnimal(Animal modificado) {
    System.out.println("\n------- Animal --------");
    System.out.println("Nome do Animal: " + modificado.getNomeAnimal());
    System.out.println("Peso: " + modificado.getPeso());
    System.out.println("Observacoes: " + modificado.getObservacoes());
    System.out.println("Raca: " + modificado.getRaca());
    System.out.println("Idade: " + modificado.getIdade());
  }

  private static void cadastrarAnimal() {
    Animal novo = new Animal();

    System.out.println("\n---------------- Novo Animal ----------------");
    System.out.println("Digite o nome do animal: ");
    String nomeAnimal = s.nextLine();
    novo.setNomeAnimal(nomeAnimal);
    System.out.println("Digite o peso do animal: ");
    double peso = s.nextDouble();
    s.nextLine();
    novo.setPeso(peso);
    System.out.println("Digite as observacoes do animal: ");
    String observacoes = s.nextLine();
    novo.setObservacoes(observacoes);
    System.out.println("Digite a raca do animal: ");
    String raca = s.nextLine();
    novo.setRaca(raca);
    System.out.println("Digite a idade do animal: ");
    int idade = s.nextInt();
    s.nextLine();
    novo.setIdade(idade);
    animais.add(novo);
    System.out.println("\n------- Dados cadastrados com sucesso!-------");
  }

  private static void vincularAnimal(Animal selecionado) {
    atual.getAnimais().add(selecionado);
  }

  private static Animal selecionaAnimal() {
    System.out.print("\nDigite o numero do animal : ");
    int pos = s.nextInt();
    pos--;
    s.nextLine();
    if (pos < animais.size())
      return animais.get(pos);
    else
      return null;
  }

  private static void listarAnimais(ArrayList<Animal> lista) {
    System.out.println("\n------- Animais -------");
    int cont = 1;
    for (Animal a : lista) {
      System.out.println(cont++ + " - " + a);
    }
  }


  public static void listarUsuarios() {
    for (Usuario usuario : usuarios) {
      System.out.println("---------- USUARIO ----------");
      System.out.println("Nome do usuario: " + usuario.getNomeUsuario());
      System.out.println("Email: " + usuario.getEmail());
      System.out.println("CPF: " + usuario.getCpf());
      System.out.println("Endereco: " + usuario.getEndereco());

      System.out.println("Animais:");

      for (Animal animal : usuario.getAnimais()) {
        System.out.println(" - Nome do animal: " + animal.getNomeAnimal());
        System.out.println(" - Especie: " + animal.getPeso());
        System.out.println(" - Raca: " + animal.getRaca());
        System.out.println(" - Idade: " + animal.getIdade());
        System.out.println(" - Observacoes: " + animal.getObservacoes());
      }
      System.out.println("-------------------");
    }
  }

  private static void editarUsuario() {
    System.out.println("Digite qual item deseja modificar: ");
    System.out.println("1 - Email");
    System.out.println("2 - Endereco");
    int op = s.nextInt();
    s.nextLine();
    if (op == 1) {
      System.out.println("Digite o novo e-mail:");
      atual.setEmail(s.nextLine());
    } else {
      System.out.println("Digite o novo Endereco:");
      atual.setEndereco(s.nextLine());
    }
    System.out.println("\n-------Dados cadastrados com sucesso!-------\n");
  }

  private static void mostrarUsuario() {
    System.out.println("\n------- Usuario -------");
    System.out.println("Nome: " + atual.getNomeUsuario());
    System.out.println("Email: " + atual.getEmail());
    System.out.println("CPF: " + atual.getCpf());
    System.out.println("Endereco: " + atual.getEndereco());
  }

  private static void cadastrarUsuario() {
    atual = new Usuario();
    System.out.println("\n---------------- NOVO USUARIO -----------------");
    System.out.println("Digite o nome do usuario: ");
    atual.setNomeUsuario(s.nextLine());
    System.out.println("Digite o CPF do usuario: ");
    atual.setCpf(s.nextLine());
    System.out.println("Digite o email do usuario: ");
    atual.setEmail(s.nextLine());
    System.out.println("Digite o endereco do usuario: ");
    atual.setEndereco(s.nextLine());
    System.out.println("\n----------------Dados cadastrados com sucesso!-----------------");
  }

  private static void apagarUsuario() {
    System.out.println("Gostaria de apagar este Usuario? (S - sim)");
    char c = s.nextLine().charAt(0);
    if (c == 'S') {
      atual = null;
      System.out.println("Usuario apagado!");
    }
  }

  private static void cadastrarLogin() {
    System.out.println("-------Cadastrar novas credenciais-------");
    System.out.println("Digite o nome do novo usuario: ");
    String novoUser = s.nextLine();
    System.out.println("Digite a senha do novo usuario: ");
    String novaSenha = s.nextLine();
    usuariosCredenciais.put(novoUser, novaSenha);
    System.out.println("Usuario adicionado com sucesso!");
  }

  private static void listarLogins() {
    System.out.println("\n------- Credenciais -------");
    int cont = 1;
    for (Map.Entry<String, String> u : usuariosCredenciais.entrySet()) {
      System.out.println(cont++ + " : " + u.getKey() + " - " + u.getValue());
    }
  }

  public static void sair() {
    s.close();
    System.out.println("!!!!! Fim !!!!");
  }

}