package br.to.lucaspg.projetofinalrasunho;

import java.util.Random;

import br.to.lucaspg.projetofinalrasunho.AndGraph.AGGameManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGInputManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScene;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGScreenManager;
import br.to.lucaspg.projetofinalrasunho.AndGraph.AGSprite;

public class CenaPlay extends AGScene {

    private final float POSICAO_ESQUERDA = AGScreenManager.iScreenWidth / 4.60f;
    private final float POSICAO_DIREITA = AGScreenManager.iScreenWidth / 1.3f;
    AGSprite vida = null;
    AGSprite vida2 = null;
    AGSprite vida3 = null;
    AGSprite riogif = null;
    AGSprite barco = null;
    AGSprite setadireita = null;
    AGSprite bracodireito = null;
    AGSprite setaesquerda = null;
    AGSprite bracoesquerdo = null;
    AGSprite peixe = null;
    AGSprite chapeu = null;
    private int score = 0, tempScore = 0;
    private AGSprite[] vetPeixe = null;
    private AGSprite[] vetScore = null;
    int contVida;

    public CenaPlay(AGGameManager manager) {
        super(manager);
    }

    @Override
    public void init() {

        riogif = createSprite(R.mipmap.riogif, 2, 3);
        riogif.setScreenPercent(100, 100);
        riogif.setCurrentAnimation(0);
        riogif.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        riogif.vrPosition.setY(AGScreenManager.iScreenHeight / 2);
        riogif.addAnimation(5, true, 0, 5);

        barco = createSprite(R.mipmap.barcocentro, 1, 1);
        barco.setScreenPercent(20, 40);
        barco.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        barco.vrPosition.setY(AGScreenManager.iScreenHeight / 3.5f);

        setadireita = createSprite(R.mipmap.setadireita, 1, 1);
        setadireita.setScreenPercent(20, 10);
        setadireita.vrPosition.setX(AGScreenManager.iScreenWidth / 1.15f);
        setadireita.vrPosition.setY(AGScreenManager.iScreenHeight / 10);
        setadireita.fAlpha = 0.8f;

        setaesquerda = createSprite(R.mipmap.setaesquerda, 1, 1);
        setaesquerda.setScreenPercent(20, 10);
        setaesquerda.vrPosition.setX(AGScreenManager.iScreenWidth / 6);
        setaesquerda.vrPosition.setY(AGScreenManager.iScreenHeight / 10);
        setaesquerda.fAlpha = 0.8f;

        vida = createSprite(R.mipmap.coracao, 1, 1);
        vida.setScreenPercent(4, 3);
        vida.vrPosition.setX(AGScreenManager.iScreenWidth / 4.50f);
        vida.vrPosition.setY(AGScreenManager.iScreenHeight / 1.05f);

        vida2 = createSprite(R.mipmap.coracao, 1, 1);
        vida2.setScreenPercent(4, 3);
        vida2.vrPosition.setX(AGScreenManager.iScreenWidth / 6.50f);
        vida2.vrPosition.setY(AGScreenManager.iScreenHeight / 1.05f);

        vida3 = createSprite(R.mipmap.coracao, 1, 1);
        vida3.setScreenPercent(4, 3);
        vida3.vrPosition.setX(AGScreenManager.iScreenWidth / 10.10f);
        vida3.vrPosition.setY(AGScreenManager.iScreenHeight / 1.05f);

        bracoesquerdo = createSprite(R.mipmap.bracoesquerdo, 1, 1);
        bracoesquerdo.setScreenPercent(25, 15);
        bracoesquerdo.vrPosition.setX(AGScreenManager.iScreenWidth / 3.2f);
        bracoesquerdo.vrPosition.setY(AGScreenManager.iScreenHeight / 4.2f);
        bracoesquerdo.fadeOut(0);
        bracoesquerdo.bVisible = false;

        bracodireito = createSprite(R.mipmap.bracodireito, 1, 1);
        bracodireito.setScreenPercent(25, 15);
        bracodireito.vrPosition.setX(AGScreenManager.iScreenWidth / 1.45f);
        bracodireito.vrPosition.setY(AGScreenManager.iScreenHeight / 4.2f);
        bracodireito.fadeOut(0);
        bracodireito.bVisible = false;

        chapeu = createSprite(R.mipmap.chapeu, 1, 1);
        chapeu.setScreenPercent(20, 15);
        chapeu.vrPosition.setX(AGScreenManager.iScreenWidth / 2);
        chapeu.vrPosition.setY(AGScreenManager.iScreenHeight / 5);
        contVida = 3;

        //Cria os Sprites do Score e configura suas animacoes
        vetScore = new AGSprite[3];
        for (int iIndex = vetScore.length - 1; iIndex >= 0; iIndex--) {
            vetScore[iIndex] = createSprite(R.mipmap.fonte, 4, 4);
            vetScore[iIndex].setScreenPercent(8, 8);
            vetScore[iIndex].vrPosition.setXY(AGScreenManager.iScreenWidth - iIndex * vetScore[iIndex].getSpriteWidth() - 10, AGScreenManager.iScreenHeight - vetScore[iIndex].getSpriteHeight() / 2);
            vetScore[iIndex].bAutoRender = false;

            for (int jIndex = 0; jIndex < 10; jIndex++) {
                vetScore[iIndex].addAnimation(1, false, jIndex);
            }
        }
        desenhaPeixe();
    }

    //GERADOR DE PEIXES,SORTEIA QUAL MODELO DE PEIXE CRIAR
    public void randomPeixe() {

        Random randomico = new Random();

        int numeroAleatorio = randomico.nextInt(3);

        if (numeroAleatorio == 0) {
            peixe = createSprite(R.mipmap.peixe1, 1, 1);
        }
        if (numeroAleatorio == 1) {
            peixe = createSprite(R.mipmap.peixe2, 1, 1);
        }
        if (numeroAleatorio == 2) {
            peixe = createSprite(R.mipmap.peixe3, 1, 1);
        }
        if (numeroAleatorio == 3) {
            peixe = createSprite(R.mipmap.peixe4, 1, 1);
        }
        peixe.setScreenPercent(7, 10);

    }

    public void randomLado() { // SORTEIA QUAL LADO SERÁ CRIADO O PEIXE

        Random randomico = new Random();
        int qLado = randomico.nextInt(2);
        if (qLado == 1) {
            peixe.vrPosition.setX(AGScreenManager.iScreenWidth / 4.60f);
            peixe.iMirror = AGSprite.HORIZONTAL;
        }
        if (qLado == 0) {
            peixe.vrPosition.setX(AGScreenManager.iScreenWidth / 1.3f);
        }
    }

    //Sobrescreve o metodo de rendering
    public void render() {
        super.render();

        for (AGSprite digit : vetScore) {
            digit.render();
        }
    }

    private void verificaPeixeNaRede() { //METODO  PARA VERIFICAR SE O PEIXE TOCOU NA REDE


        if (bracodireito.bVisible != false) {
            if (peixe.collide(bracodireito)) {
                peixe.bVisible = false;
                updateScore();
                desenhaPeixe();
            }
        }
        if (bracoesquerdo.bVisible != false) {
            if (peixe.bVisible && peixe.collide(bracoesquerdo)) {
                peixe.bVisible = false;
                updateScore();
                desenhaPeixe();
            }
        }
    }

    //Atualiza o movimeto dos paixes
    private void atualizarPeixe() {
        peixe.vrPosition.setY(peixe.vrPosition.getY() + -50);
        if (peixe.vrPosition.getY() < AGScreenManager.iScreenHeight / 1 * 0) {
            peixe.bVisible = false;
            desenhaPeixe();
            if (contVida == 3) {
                vida.bVisible = false;
            }
            if (contVida == 2) {
                vida2.bVisible = false;
            }
            if (contVida == 1) {
                vida3.bVisible = false;
            }
            if (contVida == 0) {
                vrGameManager.setCurrentScene(5);
            }
            contVida--;
        }
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
        verificaPeixeNaRede();
        jogarRede();
        atualizarPeixe();
        voltarTela();
    }

    public void desenhaPeixe() {
        //Instancia o array de peixes e configura seus tamanhos e direcoes
        vetPeixe = new AGSprite[1];

        for (int i = 0; i < vetPeixe.length; i++) {
            randomPeixe();
            randomLado();
            vetPeixe[i] = peixe;
            vetPeixe[i].setScreenPercent(7, 10);
            vetPeixe[i].vrPosition.setY(AGScreenManager.iScreenHeight / 1);
        }
    }

    public void jogarRede() {
        //peixe.vrPosition.setY(peixe.vrPosition.getY() + x);
        if (AGInputManager.vrTouchEvents.screenClicked()) { //Quando receber o clique do usuário...
            if (setaesquerda.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                //ajusta braço
                bracoesquerdo.fadeIn(0);
                try {
                    bracodireito.bVisible = false;
                } catch (Exception e) {
                }
            }
        }
        if (AGInputManager.vrTouchEvents.screenClicked()) { //Quando receber o clique do usuário...
            //VERIFICA SE A SETA DIREIA
            if (setadireita.collide(AGInputManager.vrTouchEvents.getLastPosition())) {
                bracodireito.fadeIn(0);
                try {
                    bracoesquerdo.bVisible = false;
                } catch (Exception e) {
                }
            }
        }
    }

    //METODO CHAMADO QUANDO O BOTÃO VOLTAR DO ANDROID FOR CLICADO
    public void voltarTela() {
        if (AGInputManager.vrTouchEvents.backButtonClicked()) {//Quando receber o clique do usuário...
            vrGameManager.setCurrentScene(0);
        }
    }

    //Metodo utilizado para atualizar o placar
    private void updateScore() {
        score++;
        vetScore[0].setCurrentAnimation((int) score % 10);
        vetScore[1].setCurrentAnimation(((int) score % 100) / 10);
        vetScore[2].setCurrentAnimation(((int) score % 1000) / 100);

    }
}
