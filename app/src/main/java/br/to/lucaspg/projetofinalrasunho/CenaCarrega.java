package br.to.lucaspg.projetofinalrasunho;

import br.to.lucaspg.projetofinalrasunho.AndGraph.AGGameManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGInputManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScene;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScreenManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGSprite;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGTimer;

public class CenaCarrega extends AGScene {
    AGTimer intervaloTempo = null;
    AGSprite mastro = null;

    public CenaCarrega(AGGameManager manager) {
        super(manager);
    }

    @Override
    public void init() {
        setSceneBackgroundColor(1, 1, 1);

        intervaloTempo = new AGTimer(1000);

        mastro = createSprite(R.mipmap.mastrogif, 4, 1);
        mastro.setScreenPercent(30, 30);
        mastro.setCurrentAnimation(0);
        mastro.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        mastro.vrPosition.setY(AGScreenManager.iScreenHeight / 2);
        mastro.addAnimation(25, true, 0, 3);
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
    public void loop() {// CHAMDODO  n  VEZES POR  SEGUNDO  QUE IRA CONTROLAR A LOGICA DA CENA NOSSO"ONDRAWFRAME"
        intervaloTempo.update();
        //se clicar ou tempo acabar  ele troca de tela
        if (intervaloTempo.isTimeEnded() || (AGInputManager.vrTouchEvents.screenClicked())) {
            vrGameManager.setCurrentScene(2);
        }


        if (AGInputManager.vrTouchEvents.backButtonClicked()) {
            vrGameManager.setCurrentScene(0);
        }

    }
}
