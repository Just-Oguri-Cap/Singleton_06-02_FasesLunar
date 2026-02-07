package org.example.singleton_0602_rpg;

public class CalculadoraLunar {

    private static final int CICLO_LUNAR = 29;

    public void avancarDia() {
        Lua lua = Lua.getInstancia();
        lua.setDataSelecionada(lua.getDataSelecionada().plusDays(1));
    }

    public void retrocederDia() {
        Lua lua = Lua.getInstancia();
        lua.setDataSelecionada(lua.getDataSelecionada().minusDays(1));
    }

    public FaseLunar calcularFase(int dia) {
        if (dia <= 1) {
            return FaseLunar.NOVA;
        } else if (dia <= 6) {
            return FaseLunar.CRESCENTE_NOVA;
        } else if (dia <= 8) {
            return FaseLunar.QUARTO_CRESCENTE;
        } else if (dia <= 13) {
            return FaseLunar.CRESCENTE_GIBOSA;
        } else if (dia <= 16) {
            return FaseLunar.CHEIA;
        } else if (dia <= 20) {
            return FaseLunar.MINGUANTE_GIBOSA;
        } else if (dia <= 22) {
            return FaseLunar.QUARTO_MINGUANTE;
        } else {
            return FaseLunar.MINGUANTE_NOVA;
        }
    }
}