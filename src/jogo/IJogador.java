/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package jogo;

public interface IJogador {
    
    public boolean barco_atingido(int indice_casa);
    public boolean barco_destruido();
    public boolean fim_de_jogo();
    public void posicionar_barcos(Barco b, int indice_casa,String direcao);
    
}
