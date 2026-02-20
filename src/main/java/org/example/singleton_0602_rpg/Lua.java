package org.example.singleton_0602_rpg;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Lua {

    private static Lua instancia;
    private LocalDate dataSelecionada;
    private FaseLunar faseAtual;

    // Lua Nova real confirmada: 18 de janeiro de 2026
    private static final LocalDate LUA_NOVA_REFERENCIA = LocalDate.of(2026, 1, 18);
    private static final double CICLO_LUNAR = 29.53;

    private Lua() {
        this.dataSelecionada = LocalDate.now();
        this.faseAtual = calcularFase(this.dataSelecionada);
    }

    public static Lua getInstancia() {
        if (instancia == null) {
            instancia = new Lua();
        }
        return instancia;
    }

    public int getDiaDoCiclo() {
        long diasDesdeReferencia = ChronoUnit.DAYS.between(LUA_NOVA_REFERENCIA, dataSelecionada);
        double cicloPreciso = diasDesdeReferencia % CICLO_LUNAR;
        if (cicloPreciso < 0) {
            cicloPreciso += CICLO_LUNAR;
        }
        return (int) Math.round(cicloPreciso);
    }


    public String getDetalheFase() {
        int dia = getDiaDoCiclo();

        if (dia == 0 || dia == 1) {
            return "Lua totalmente invisível no céu";
        } else if (dia <= 3) {
            return "Pequena faixa iluminada começando a aparecer";
        } else if (dia <= 6) {
            return "Crescente inicial - fina faixa visível";
        } else if (dia <= 9) {
            return "Quarto Crescente - exatamente metade iluminada";
        } else if (dia <= 12) {
            return "Crescente gibosa inicial - mais da metade visível";
        } else if (dia <= 14) {
            return "Crescente gibosa avançada - quase cheia";
        } else if (dia <= 16) {
            return "Lua Cheia - totalmente iluminada e brilhante";
        } else if (dia <= 19) {
            return "Minguante gibosa inicial - começando a escurecer";
        } else if (dia <= 21) {
            return "Minguante gibosa - perdendo luminosidade";
        } else if (dia <= 24) {
            return "Quarto Minguante - metade iluminada";
        } else if (dia <= 27) {
            return "Minguante final - fina faixa visível";
        } else {
            return "Quase lua nova - apenas um filete de luz";
        }
    }

    public double getPercentualIluminacao() {
        int dia = getDiaDoCiclo();

        if (dia <= 15) {
            // Crescente: 0% a 100%
            return (dia / 15.0) * 100;
        } else {
            // Minguante: 100% a 0%
            return ((30 - dia) / 15.0) * 100;
        }
    }

    private FaseLunar calcularFase(LocalDate data) {
        long diasDesdeReferencia = ChronoUnit.DAYS.between(LUA_NOVA_REFERENCIA, data);
        double cicloPreciso = diasDesdeReferencia % CICLO_LUNAR;
        if (cicloPreciso < 0) {
            cicloPreciso += CICLO_LUNAR;
        }

        // 8 fases (29.53 dias ÷ 8 = ~3.69 dias por fase)
        if (cicloPreciso < 1.85) {
            return FaseLunar.NOVA;
        } else if (cicloPreciso < 7.38) {
            return FaseLunar.CRESCENTE_NOVA;
        } else if (cicloPreciso < 11.07) {
            return FaseLunar.QUARTO_CRESCENTE;
        } else if (cicloPreciso < 14.76) {
            return FaseLunar.CRESCENTE_GIBOSA;
        } else if (cicloPreciso < 18.45) {
            return FaseLunar.CHEIA;
        } else if (cicloPreciso < 22.14) {
            return FaseLunar.MINGUANTE_GIBOSA;
        } else if (cicloPreciso < 25.83) {
            return FaseLunar.QUARTO_MINGUANTE;
        } else {
            return FaseLunar.MINGUANTE_NOVA;
        }
    }

    public LocalDate getDataSelecionada() {
        return dataSelecionada;
    }

    public void setDataSelecionada(LocalDate dataSelecionada) {
        this.dataSelecionada = dataSelecionada;
        this.faseAtual = calcularFase(dataSelecionada);
    }

    public FaseLunar getFaseAtual() {
        return faseAtual;
    }

}