package petshop;

public class Pet {
    private int id;
    private String nome;
    private String especie;
    private String raca;
    private int idade;
    private float peso;
    private String sexo;

    // Construtor
    public Pet(int id, String nome, String especie, String raca, int idade, float peso, String sexo) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        this.sexo = sexo;
    }

    // Getters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getEspecie() { return especie; }
    public String getRaca() { return raca; }
    public int getIdade() { return idade; }
    public float getPeso() { return peso; }
    public String getSexo() { return sexo; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setRaca(String raca) { this.raca = raca; }
    public void setIdade(int idade) { this.idade = idade; }
    public void setPeso(float peso) { this.peso = peso; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", peso=" + peso +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}