class Animal {
  private String nomeAnimal;
  // private String nomeTutor;
  private double peso;
  private String observacoes;
  private String raca;
  private int idade;

  public Animal(String nomeAnimal, double peso, String observacoes, String raca, int idade) {
    this.nomeAnimal = nomeAnimal;
    this.peso = peso;
    this.observacoes = observacoes;
    this.raca = raca;
    this.idade = idade;
  }

  public Animal(){
    
  }

  public String getNomeAnimal() {
    return nomeAnimal;
  }

  public void setNomeAnimal(String nomeAnimal) {
    this.nomeAnimal = nomeAnimal;
  }

  public double getPeso() {
    return peso;
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }

  public String getObservacoes() {
    return observacoes;
  }

  public void setObservacoes(String observacoes) {
    this.observacoes = observacoes;
  }

  public String getRaca() {
    return raca;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public String toString() {
      return "Nome: " + nomeAnimal + ", Peso: " + peso + ", Raça: " + raca + ", Idade: " + idade + ", Observações: " + observacoes;
  }

}