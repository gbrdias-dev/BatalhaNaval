/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;

public class Jogo {
    private Jogador jg1, jg2;
    private int status_partida = 0;
    public final int POSICIONANDO = 0, JOGANDO =1, FINALIZADO = 3;   
    
    // Construtor de jogo
    public Jogo(String nome_jogador1, String nome_jogador2){ 
        jg1 = new Jogador(nome_jogador1);
        jg2 = new Jogador(nome_jogador2);
        this.jg1 = jg1;
        this.jg2 = jg2;
    }
    
    
    // Verifica se um barco pode ser colocado na casa selecionada pelo jogador
    public boolean posicao_valida(Barco barco, int indice_casa, String direcao){
        boolean js_valido = false;
        boolean pa_valido = false;
        boolean sb_valido = false;
        boolean nt_valido = false;
        boolean casa_vazia = true;
        
        int linha = (int)Math.floor(indice_casa/10);
        int casa_fim = linha * 10 + 9;
        
            
            if(direcao.equals("Horizontal")){
                if(indice_casa + barco.getTamanho() - 1 > casa_fim){
                    casa_vazia = false;
                }else{
                    for(int posicao_testada = indice_casa; posicao_testada < indice_casa + barco.getTamanho() && casa_vazia; posicao_testada++){
                        if(jg1.isTurno()){
                            js_valido = this.jg1.getJs().posicao_vazia(posicao_testada);
                            pa_valido = this.jg1.getPa().posicao_vazia(posicao_testada);
                            sb_valido = this.jg1.getSb().posicao_vazia(posicao_testada);
                            nt_valido = this.jg1.getNt().posicao_vazia(posicao_testada);
                        }else{
                            js_valido = this.jg2.getJs().posicao_vazia(posicao_testada);
                            pa_valido = this.jg2.getPa().posicao_vazia(posicao_testada);
                            sb_valido = this.jg2.getSb().posicao_vazia(posicao_testada);
                            nt_valido = this.jg2.getNt().posicao_vazia(posicao_testada);  
                        }
                        casa_vazia=js_valido && pa_valido && sb_valido && nt_valido;
                    }      
                }
            }else{
                if(indice_casa + (barco.getTamanho()* 10) - 10 > 99){
                    casa_vazia = false;
                }else{
                    for(int posicao_testada = indice_casa; posicao_testada < indice_casa + (barco.getTamanho() * 10) && casa_vazia; posicao_testada+=10){
                      if(jg1.isTurno()){  
                        js_valido = this.jg1.getJs().posicao_vazia(posicao_testada);
                        pa_valido = this.jg1.getPa().posicao_vazia(posicao_testada);
                        sb_valido = this.jg1.getSb().posicao_vazia(posicao_testada);
                        nt_valido = this.jg1.getNt().posicao_vazia(posicao_testada);
                      }else{
                        js_valido = this.jg2.getJs().posicao_vazia(posicao_testada);
                        pa_valido = this.jg2.getPa().posicao_vazia(posicao_testada);
                        sb_valido = this.jg2.getSb().posicao_vazia(posicao_testada);
                        nt_valido = this.jg2.getNt().posicao_vazia(posicao_testada);  
                      } 
                       casa_vazia=js_valido && pa_valido && sb_valido && nt_valido;
                    }
                }    
          
            }
           
        
        return casa_vazia;
    }
    
    // Define o estado da partida
    public int status(){
        
        return this.status_partida;
    }
    
    // Verifica se os dois jogadores montaram o tabuleiro e altera o estado da partida
    public void verifica_tabuleiros(){
        if(jg1.tabuleiro_pronto() && jg2.tabuleiro_pronto()){
            this.status_partida = this.JOGANDO;
        }
    }
    
    // Verifica se partida acabou
    public boolean fim_de_jogo(){
        boolean retorno = false;
        
        if(this.jg1.getJs().destruido() && this.jg1.getNt().destruido() && this.jg1.getPa().destruido() && this.jg1.getSb().destruido() || this.jg2.getJs().destruido() && this.jg2.getNt().destruido() && this.jg2.getPa().destruido() && this.jg2.getSb().destruido()){
            
            retorno = true;
            this.status_partida = this.FINALIZADO;
        }
        
        return retorno;
    }
    
    public Jogador jogador1(){
        
        return this.jg1;
    }
    
     public Jogador jogador2(){
        
        return this.jg2;
    }
    

            
     
}
