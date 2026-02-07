package org.example.singleton_0602_rpg;

public class Mesa {
    private String identificador = null;
    private int quantidadeDeJogadores = 0;

    private static Mesa MesaUnica = null;

    private  Mesa(String identificador){
        this.identificador = identificador;
    }

    public static Mesa getInstanciaDaMesa(String identificador){
        if(MesaUnica == null)
            MesaUnica = new Mesa(identificador);
        return MesaUnica;
    }

    public String getIdentificador(){return identificador;}

    public int getQuantidadeDeJogadores() {
        return quantidadeDeJogadores;
    }

    public void setQuantidadeDeJogadores() {
        this.quantidadeDeJogadores++;
    }

}
