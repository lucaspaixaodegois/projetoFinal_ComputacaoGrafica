package br.to.lucaspg.projetofinalrasunho.AndGraph;

import br.to.lucaspg.projetofinalrasunho.R;

public class CenaGaming extends AGScene {
    AGTimer intervaloTempo = null;
    AGSprite fundoplay = null;
    AGSprite peixe1 = null;
    AGSprite peixe2 = null;
    AGSprite peixe3 = null;
    AGSprite peixe4 = null;


    public CenaGaming(AGGameManager manager) {
        super(manager);
    }

    @Override
    public void init() {
        //CHAMADO TODA VEZ QUE UMA CENA É APRESENTADO
        setSceneBackgroundColor(1, 1, 0);
        intervaloTempo = new AGTimer(9000);

        // AGSoundManager.vrMusic.loadMusic("musica");
        // AGSoundManager.vrMusic.play();
      //  fundoplay = createSprite(R.mipmap.fundoplay, 1, 1);
        fundoplay.setScreenPercent(130, 100);
        fundoplay.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        fundoplay.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

        peixe1 = createSprite(R.mipmap.peixe1, 1, 1);
        peixe1.setScreenPercent(40, 10);
        peixe1.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        peixe1.vrPosition.setY(AGScreenManager.iScreenHeight / 1.25f);

        peixe2 = createSprite(R.mipmap.peixe2, 1, 1);
        peixe2.setScreenPercent(40, 10);
        peixe2.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        peixe2.vrPosition.setY(AGScreenManager.iScreenHeight / 1.50f);

        peixe3 = createSprite(R.mipmap.peixe3, 1, 1);
        peixe3.setScreenPercent(40, 10);
        peixe3.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        peixe3.vrPosition.setY(AGScreenManager.iScreenHeight / 1.85f);

        peixe4 = createSprite(R.mipmap.peixe4, 1, 1);
        peixe4.setScreenPercent(40, 10);
        peixe4.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        peixe4.vrPosition.setY(AGScreenManager.iScreenHeight / 2.50f);

//        pernalonga = createSprite(R.mipmap.pernalonga, 1, 1);
//        pernalonga.setScreenPercent(40, 30);
//        pernalonga.vrPosition.setX(AGScreenManager.iScreenHeight / 2);
//        pernalonga.vrPosition.setX(AGScreenManager.iScreenWidth / 2);

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
        intervaloTempo.update();
        //se clicar ou tempo acabar  ele troca de tela
        if (intervaloTempo.isTimeEnded() || (AGInputManager.vrTouchEvents.screenClicked())) {
            vrGameManager.setCurrentScene(1);
        }
        //se tiver nessa tela  clicar no botao voltar é para fechar  o app


    }
}
