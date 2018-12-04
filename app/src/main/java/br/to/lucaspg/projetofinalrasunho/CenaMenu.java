package br.to.lucaspg.projetofinalrasunho;

import br.to.lucaspg.projetofinalrasunho.AndGraph.AGGameManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGInputManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScene;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScreenManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGSoundManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGSprite;

public class CenaMenu extends AGScene {

    AGSprite pernalonga = null;
    AGSprite menu = null;
    AGSprite pescar = null;
    AGSprite ajuda = null;
    AGSprite sobre = null;
    AGSprite sair = null;
    int codigoSom;

    public CenaMenu(AGGameManager manager) {
        super(manager);
    }

    @Override
    public void init() {
        //CHAMADO TODA VEZ QUE UMA CENA É APRESENTADO
        setSceneBackgroundColor(1, 1, 0);

        AGSoundManager.vrMusic.loadMusic("calm.mp3", true); // inicia a musica quando abrir app
        AGSoundManager.vrMusic.play(); // da play na musica
        codigoSom = AGSoundManager.vrSoundEffects.loadSoundEffect("toc.wav"); //efeito pra clic do botao

        menu = createSprite(R.mipmap.menu, 1, 1);
        menu.setScreenPercent(130, 100);
        menu.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        menu.vrPosition.setY(AGScreenManager.iScreenHeight / 2);

        pescar = createSprite(R.mipmap.pescar, 1, 1);
        pescar.setScreenPercent(40, 10);
        pescar.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        pescar.vrPosition.setY(AGScreenManager.iScreenHeight / 1.25f);

        ajuda = createSprite(R.mipmap.ajuda, 1, 1);
        ajuda.setScreenPercent(40, 10);
        ajuda.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        ajuda.vrPosition.setY(AGScreenManager.iScreenHeight / 1.50f);

        sobre = createSprite(R.mipmap.sobre, 1, 1);
        sobre.setScreenPercent(40, 10);
        sobre.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        sobre.vrPosition.setY(AGScreenManager.iScreenHeight / 1.85f);

        sair = createSprite(R.mipmap.sair, 1, 1);
        sair.setScreenPercent(40, 10);
        sair.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        sair.vrPosition.setY(AGScreenManager.iScreenHeight / 2.50f);
//          exemplo de sprite
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

        if (AGInputManager.vrTouchEvents.backButtonClicked()) { //se tiver nessa tela  clicar no botao voltar é para fechar  o app

            vrGameManager.vrActivity.finish(); //fechar app
        }

        if (AGInputManager.vrTouchEvents.screenClicked()) { //Quando receber o clique do usuário...
            if (pescar.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                AGSoundManager.vrSoundEffects.play(codigoSom);
                AGSoundManager.vrMusic.pause();

                this.vrGameManager.setCurrentScene(1); //...a cena CenaPlay é chamada
                return; //volta para garantir que nao tenha erro
            }
        }
        if (AGInputManager.vrTouchEvents.screenClicked()) { //Quando receber o clique do usuário...
            if (ajuda.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                AGSoundManager.vrSoundEffects.play(codigoSom);

                this.vrGameManager.setCurrentScene(3); //...a cenaAjuda  é chamada
                return;
            }
        }
        if (AGInputManager.vrTouchEvents.screenClicked()) { //Quando receber o clique do usuário...
            if (sobre.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                AGSoundManager.vrSoundEffects.play(codigoSom);

                this.vrGameManager.setCurrentScene(4); //...a cena Cenasobre é chamada
                return;
            }
        }
        if (AGInputManager.vrTouchEvents.screenClicked()) { //Quando receber o clique do usuário...
            if (sair.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                AGSoundManager.vrSoundEffects.play(codigoSom);
                vrGameManager.vrActivity.finish();
                return;
            }
        }

    }
}
