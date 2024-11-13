/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

import java.awt.Color;
import java.util.ArrayList;


public abstract class Barco {
    
    private int tamanho;
    private String nome;
    private int partes_atingidas = 0;
    private ArrayList<Integer> posicoes;
    private Color cor_barco;
    private boolean posicionado = false;
    private boolean alerta_destruicao = false;

  
    // Verfica se barco está posicionado no tabuleiro
    public boolean isPosicionado() {
        return posicionado;
    }
    
    // Confirma que barco está posicionado
    public void setPosicionado(boolean posicionado) {
        this.posicionado = posicionado;
    }
    
    // Retorna a cor do barco
    public Color getCor_barco() {
        return cor_barco;
    }
    
    // Define a cor do barco
    public void setCor_barco(Color cor_barco) {
        this.cor_barco = cor_barco;
    }
    
    // Construtor de barco
    public Barco(String nome, int tamanho){
        this.nome = nome;
        this.tamanho = tamanho;
        this.posicoes = new ArrayList();
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
   
    
    // Verifica se barco esta posicionado em uma casa do tabuleiro
    public boolean posicao_vazia(int indice_casa){
        boolean sem_barco = true;
         
        for(int posicao_atual:this.posicoes){
            if(posicao_atual == indice_casa && sem_barco){                
                sem_barco = false;
            }
        }
        
        return sem_barco;
    }
    
    // Adiciona posicao do barco
    public void addPosicao(int posicao){
        this.posicoes.add(posicao);
       
    }
    
    // Verifica se barco foi atingido
    public boolean atingido(int indice_casa){
        boolean retorno;
        retorno = false;
        for(int posicao_atual:this.posicoes){
            if(posicao_atual == indice_casa){
                this.partes_atingidas++;
                retorno = true;
                this.alerta_destruicao = true;
            }
        }
        return retorno;
    }
    
    // Verifica se barco está destruido
    public boolean destruido(){
        
       boolean retorno = false;
       if(this.tamanho == this.partes_atingidas){
           retorno = true;
       
       }
       
       return retorno;
        
    
    }
    
    
    // Retorna que mensagem de alerta foi enviada
    public boolean isAlertaDestruicao() {
        return alerta_destruicao;
    }
    
    // Define se deve emitir alerta de destruição
    public void setAlertaDestruicao(boolean alerta_destruicao) {
        this.alerta_destruicao = alerta_destruicao;
    }

}