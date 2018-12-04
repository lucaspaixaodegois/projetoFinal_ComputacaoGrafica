package br.to.lucaspg.projetofinalrasunho;

import android.os.Bundle;

import br.to.lucaspg.projetofinalrasunho.AndGraph.AGActivityGame;

public class Principal extends AGActivityGame {

    CenaMenu menu = null;
    CenaCarrega carrega = null;
    CenaPlay play = null;
    CenaSobre sobre = null;
    CenaAjuda ajuda = null;
    CenaFimDeJogo fimDeJogo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //METODO CHAMADO QUANDO O APP E INICIADO
        super.onCreate(savedInstanceState);

        //Dá a partida no motor
        init(this, false);

        //INSTANCIA O OBJETO DE CENA
        menu = new CenaMenu(getGameManager());
        carrega = new CenaCarrega(getGameManager());
        play = new CenaPlay(getGameManager());
        sobre = new CenaSobre(getGameManager());
        ajuda = new CenaAjuda(getGameManager());
        fimDeJogo = new CenaFimDeJogo(getGameManager());

        //REGISTRA A CENA AO GERENCIADOR 0
        getGameManager().addScene(menu);

        //REGISTRA A CENA AO GERENCIADOR 1
        getGameManager().addScene(carrega);

        //REGISTRA A CENA AO GERENCIADOR 2
        getGameManager().addScene(play);

        //REGISTRA A CENA AO GERENCIADOR 3
        getGameManager().addScene(ajuda);

        //REGISTRA A CENA AO GERENCIADOR 4
        getGameManager().addScene(sobre);

        //REGISTRA A CENA AO GERENCIADOR 5
        getGameManager().addScene(fimDeJogo);
    }
}