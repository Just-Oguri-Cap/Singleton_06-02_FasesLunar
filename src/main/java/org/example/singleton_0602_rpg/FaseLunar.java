package org.example.singleton_0602_rpg;

public enum FaseLunar {
    NOVA("🌑", "Lua Nova"),
    CRESCENTE_NOVA("🌒", "Crescente Nova"),
    QUARTO_CRESCENTE("🌓", "Quarto Crescente"),
    CRESCENTE_GIBOSA("🌔", "Crescente Gibosa"),
    CHEIA("🌕", "Lua Cheia"),
    MINGUANTE_GIBOSA("🌖", "Minguante Gibosa"),
    QUARTO_MINGUANTE("🌗", "Quarto Minguante"),
    MINGUANTE_NOVA("🌘", "Minguante Nova");

    private final String emoji;
    private final String nome;

    FaseLunar(String emoji, String nome) {
        this.emoji = emoji;
        this.nome = nome;
    }

    public String getEmoji() {
        return emoji;
    }

    public String getNome() {
        return nome;
    }
}
