package org.example.singleton_0602_rpg;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LuaController {

    @FXML
    private Label lblDia;

    @FXML
    private Label lblFase;

    @FXML
    private Label lblDetalhe;

    @FXML
    private Label lblEmojiGigante;

    @FXML
    private Label lblPercentual;

    @FXML
    private DatePicker seletorData;

    @FXML
    private ProgressBar barraIluminacao;

    private final Lua lua;
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public LuaController() {
        this.lua = Lua.getInstancia();
    }

    @FXML
    public void initialize() {
        seletorData.setValue(lua.getDataSelecionada());
        atualizarTela();
    }

    @FXML
    private void aoSelecionarData(ActionEvent evento) {
        LocalDate dataSelecionada = seletorData.getValue();
        if (dataSelecionada != null) {
            lua.setDataSelecionada(dataSelecionada);
            atualizarTela();
        }
    }

    @FXML
    private void aoDiaSeguinte(ActionEvent evento) {
        avancarDia();
        seletorData.setValue(lua.getDataSelecionada());
        atualizarTela();
    }

    @FXML
    private void aoDiaAnterior(ActionEvent evento) {
        retrocederDia();
        seletorData.setValue(lua.getDataSelecionada());
        atualizarTela();
    }

    // Comandos de avançar e retroceder o dia
    private void avancarDia() {
        Lua lua = Lua.getInstancia();
        lua.setDataSelecionada(lua.getDataSelecionada().plusDays(1));
    }

    private void retrocederDia() {
        Lua lua = Lua.getInstancia();
        lua.setDataSelecionada(lua.getDataSelecionada().minusDays(1));
    }

    private void atualizarTela() {
        // Atualiza textos
        lblDia.setText(String.format("Data: %s | Dia do ciclo: %d/29",
                lua.getDataSelecionada().format(FORMATADOR),
                lua.getDiaDoCiclo()));

        lblFase.setText(lua.getFaseAtual().getNome());
        lblDetalhe.setText(lua.getDetalheFase());
        lblEmojiGigante.setText(lua.getFaseAtual().getEmoji());

        // Atualiza barra de iluminação
        double percentual = lua.getPercentualIluminacao();
        barraIluminacao.setProgress(percentual / 100.0);
        lblPercentual.setText(String.format("%.0f%%", percentual));
    }
}