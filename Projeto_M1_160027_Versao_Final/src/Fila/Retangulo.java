/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Seven
 */
public class Retangulo 
{
    private int x = 0;
    private int y = 28;
    private int largura = 30;
    private int altura = 30;
    private Color cor = Color.BLACK; 
    
    private Boolean boarda = false;
    private final int limBoarda = 2;
    
    public Retangulo(int x,int y) 
    {
        this.x = x;
        this.y = y;
    }

    Retangulo() {
    }
    
    public void desenha(Graphics g) 
    {
        if (boarda) 
        {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, largura, altura);
            g.setColor(cor);
            g.fillRect(x+limBoarda, y+limBoarda, largura-limBoarda*2, altura-limBoarda*2);
        }
        else
        {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, largura, altura);
            g.setColor(cor);
            g.fillRect(x, y+limBoarda, largura, altura-limBoarda*2);
        }
        
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Boolean getBoarda() {
        return boarda;
    }

    public void setBoarda(Boolean boarda) {
        this.boarda = boarda;
    }
    
    
    
}
