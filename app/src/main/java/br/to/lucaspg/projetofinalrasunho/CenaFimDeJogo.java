package br.to.lucaspg.projetofinalrasunho;

import br.to.lucaspg.projetofinalrasunho.AndGraph.AGGameManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGInputManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScene;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScreenManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGSprite;

public class CenaFimDeJogo extends AGScene {

    public CenaFimDeJogo(AGGameManager manager) {
        super(manager);
    }

    AGSprite fundoCenaFimDeJogo = null;

    @Override
    public void init() {
        float centroY = (AGScreenManager.iScreenHeight / 2);

        fundoCenaFimDeJogo = createSprite(R.mipmap.gameover, 1, 1);
        fundoCenaFimDeJogo.setScreenPercent(100, 100);
        fundoCenaFimDeJogo.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        fundoCenaFimDeJogo.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

    }

    @Override
    public void restart() {
// CHAMADO  NA VOLTA DE UMA INTERRUPCAO NOTTIFICACAO EXTERNA DO APP

    }

    @Override
    public void stop() {
// CHAMADOQUANDO A INTERRUPCAO OCORRER
    }

    @Override
    public void loop() {
// CHAMDODO  n  VEZES POR  SEGUNDO  QUE IRA CONTROLAR A LOGICA DA CENA NOSSO"ONDRAWFRAME"
        if (AGInputManager.vrTouchEvents.backButtonClicked()) {
            vrGameManager.setCurrentScene(0);
        }

    }
}
