/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo;


public class Jogador {
    
    private String nome;
    private boolean turno = false;
    private boolean ataque = false;    
    private JetSki js;
    private PortaAvioes pa;
    private Submarino sb;
    private NaviosTanque nt;
    private Barco barco_selecionado;

    // Retorna o barco que foi escolhido pelo jogador
    public Barco getBarco_selecionado() {
        return barco_selecionado;
    }
    
    // Define o barco escolhido pelo jogador
    public void setBarco_selecionado(Barco barco_selecionado) {
        this.barco_selecionado = barco_selecionado;
    }

    // Verifica se o jogador já atacou na rodada
    public boolean isAtaque() {
        return ataque;
    }

    // Confirma que jogador ja atacou na rodada
    public void setAtaque(boolean ataque) {
        this.ataque = ataque;
    }
            
    
    public JetSki getJs() {
        return js;
    }


    public PortaAvioes getPa() {
        return pa;
    }

    public Submarino getSb() {
        return sb;
    }


    public NaviosTanque getNt() {
        return nt;
    }
 
    // Metodo construtor de jogador
    public Jogador(String nome){        
        this.js = new JetSki("JetSki", 2);
        this.pa = new PortaAvioes("PortaAvioes", 5);
        this.sb = new Submarino("Submarino", 3);
        this.nt = new NaviosTanque("NavioTanque", 4);
        
        
        this.nome = nome;
    }

    // Verifica se a vez do jogador
    public boolean isTurno() {
        return turno;
    }

    // Define a vez do jogador
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    
    // Verfica se o tabuleiro do jogador está pronto
    public boolean tabuleiro_pronto(){
        boolean pronto = false;
        
        if(this.js.isPosicionado() && this.pa.isPosicionado() && this.sb.isPosicionado() && this.nt.isPosicionado()){
            pronto = true;
        }
        
        return pronto;
    }
    
    // Verifica se casa do tabuleiro tem uma parte de barco
    public boolean barco_atingido(int indice_casa){
        boolean atingido = false;
        if(this.js.atingido(indice_casa) || this.nt.atingido(indice_casa) || this.pa.atingido(indice_casa) || this.sb.atingido(indice_casa)){
            atingido = true;            
        }
        
        return atingido;
    }
    
    // Verifica se o barco foi destruido
    public boolean barco_destruido(){
        boolean destruido = false;
        if(this.js.destruido() || this.nt.destruido() || this.pa.destruido() || this.sb.destruido()){
            destruido = true; 
        }
        
        return destruido;
    }
    
    
       
    
    
    // Armazena posição de um barco no tabuleiro
    public void posicionar_barcos(Barco b, int indice_casa, String direcao){
        
         
        if(direcao.equals("Horizontal")){
            for(int posicao_atual = indice_casa; posicao_atual < indice_casa + b.getTamanho(); posicao_atual++){              
               b.addPosicao(posicao_atual);
            }
           
        }else{
            for(int posicao_atual = indice_casa; posicao_atual < indice_casa + (b.getTamanho() * 10); posicao_atual+=10){
               b.addPosicao(posicao_atual);
             
            } 
          
        }
      
       
    }
      
           
}
