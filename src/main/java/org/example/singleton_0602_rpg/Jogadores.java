package org.example.singleton_0602_rpg;


public class Jogadores {
    private String nome = "";
    private Mesa Mesa = null;
    private String classe = "";
    private int nivel;
    private int hp;
    private int mana;
    private int ca;

    public Jogadores(String nome,String classe, int nivel,int hp,int mana, int ca, Mesa jogo){
        this.nome = nome;
        this.nivel = nivel;
        this.classe = classe;
        this.hp = hp;
        this.mana = mana;
        this.ca = ca;
        Mesa = jogo;
        jogo.setQuantidadeDeJogadores();
    }
    public String descricao(){
        String saida = "Dados do Jogador \n";
        saida += "Nome: " + nome + "\n";
        saida += "Classe: " + classe + "\n";
        saida += "Nível: " + nivel + "\n";
        saida += "HP: " + hp + "\n";
        saida += "Mana: " + mana + "\n";
        saida += "CA: " + ca + "\n";
        saida += "Mesa: " + Mesa.getIdentificador() + "\n";
        saida += "Quantidade de Jogadores: " + Mesa.getQuantidadeDeJogadores() + "\n";
        saida += "Codigo: " + Mesa.hashCode();
        return saida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Mesa getMesa() {
        return Mesa;
    }

    public void setMesa(Mesa mesa) {
        Mesa = mesa;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }
}
