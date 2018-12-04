package br.to.lucaspg.projetofinalrasunho;

import br.to.lucaspg.projetofinalrasunho.AndGraph.AGGameManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGInputManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScene;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScreenManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGSprite;

public class CenaSobre extends AGScene {

    public CenaSobre(AGGameManager manager) {
        super(manager);
    }

    AGSprite fundosobre = null;
    AGSprite sobretext = null;

    @Override
    public void init() {
        float centroY = (AGScreenManager.iScreenHeight / 2);

        fundosobre = createSprite(R.mipmap.fundosobre, 1, 1);
        fundosobre.setScreenPercent(100, 100);
        fundosobre.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        fundosobre.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

        //CHAMADO TODA VEZ QUE UMA CENA É APRESENTADO
//        sobretext.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
//        sobretext.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

        sobretext = createSprite(R.mipmap.sobretext, 1, 1);
        sobretext.setScreenPercent(80, 60);
        // sobretext.vrPosition.setXY(AGScreenManager.iScreenWidth / 2, -sobretext.getSpriteHeight() / 2);
        // sobretext.moveTo(15000, sobretext.vrPosition.fX, AGScreenManager.iScreenHeight + sobretext.getSpriteHeight() / 2);
        sobretext.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        sobretext.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

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
