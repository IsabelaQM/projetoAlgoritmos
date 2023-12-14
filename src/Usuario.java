import java.util.ArrayList;

public class Usuario {

  private String nomeUsuario;
  private String email;
  private String cpf;
  private String endereco;
  private ArrayList<Animal> animais;


  public Usuario(String nomeUsuario, String email, String cpf) {
    this.nomeUsuario = nomeUsuario;
    this.email = email;
    this.cpf = cpf;
    animais = new ArrayList<>();
  }
  
   public Usuario(){
    animais = new ArrayList<>();
    }
    
    public ArrayList<Animal> getAnimais(){
    return animais;
    }
    
   public void setAnimais(Animal animal){
    this.animais.add(animal);
   }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
}