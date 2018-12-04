package br.to.lucaspg.projetofinalrasunho;

import br.to.lucaspg.projetofinalrasunho.AndGraph.AGGameManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGInputManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScene;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScreenManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGSprite;

public class CenaAjuda extends AGScene {
    AGSprite fundoajuda = null;
    AGSprite passo = null;

    public CenaAjuda(AGGameManager manager) {
        super(manager);
    }

    @Override
    public void init() {
        //CHAMADO TODA VEZ QUE UMA CENA É APRESENTADO
        setSceneBackgroundColor(0, 0, 0);

        fundoajuda = createSprite(R.mipmap.fundoajuda, 1, 3);
        fundoajuda.setScreenPercent(100, 100);
        fundoajuda.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        fundoajuda.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

        passo = createSprite(R.mipmap.passo1, 1, 1);
        passo.setScreenPercent(90, 14);
        passo.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        passo.vrPosition.setY(AGScreenManager.iScreenHeight / 1.22f);

        passo = createSprite(R.mipmap.passo2, 1, 1);
        passo.setScreenPercent(90, 15);
        passo.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        passo.vrPosition.setY(AGScreenManager.iScreenHeight / 1.57f);

        passo = createSprite(R.mipmap.passo3, 1, 1);
        passo.setScreenPercent(90, 15);
        passo.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        passo.vrPosition.setY(AGScreenManager.iScreenHeight / 2.2f);

        passo = createSprite(R.mipmap.passo4, 1, 1);
        passo.setScreenPercent(90, 14);
        passo.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        passo.vrPosition.setY(AGScreenManager.iScreenHeight / 3.5f);
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
