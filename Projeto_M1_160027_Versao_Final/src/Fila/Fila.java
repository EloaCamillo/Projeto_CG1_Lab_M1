/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fila;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Fila
{

    private List<Retangulo> objetos = new LinkedList<Retangulo>();
    private int limite;
    private Retangulo base;
    private final int espaco = 5; //Espaço de cada retagulo dentro da fila
    private boolean ctrCheio = false;
    private boolean ctrVazio = false;
    
    Fila(int limite, int x, int y) 
    {
        this.limite = limite;
        base = new Retangulo(x, y);
        base.setLargura(espaco * (limite + 1) + base.getLargura() * limite);
        base.setCor(Color.ORANGE);
    }

    //Desenha a base de acordo com os atributos colocado
    public void desenha(Graphics g)
    {
        String s = "Yudi coloque algo aqui!";
                
        base.desenha(g);
        
        objetos.forEach((objeto) -> { objeto.desenha(g);});
        /*for (Retangulo objeto : objetos) 
        {
            objeto.desenha(g);
        }*/
      
        g.setColor(Color.BLACK);
        g.setFont (new Font ("Arial", 8, 17));
        g.drawString("SAIDA", base.getX(), base.getY()+base.getAltura()+limite*2);
        g.drawString("ENTRADA", base.getX()+base.getLargura()-limite*7, base.getY()+base.getAltura()+limite*2);
        
        g.drawString("Controle: [Right - Inserir] [Left - Remove]", base.getX(), base.getY()-2*limite);
        
        if (ctrCheio) 
        {
            s = "\n\n\nFila cheia!";
        }
        if (ctrVazio) 
        {
            s = "\n\n\nFila vazia!";
        }
        
        if (ctrVazio || ctrCheio) 
        {
            g.setColor(Color.red);
            g.drawString(s, base.getX(), base.getY()+base.getAltura()+4*limite);
        }
        
    }
    
    public void inserir(Retangulo r) throws Exception 
    {   
        ctrCheio = ctrVazio = false;
        if (limite > objetos.size()) 
        {
            r.setBoarda(Boolean.TRUE);
            r.setY(base.getY() + espaco);
            r.setAltura(this.base.getAltura() - espaco * 2);
            r.setCor
            (
                new Color
                (
                    new Random().nextInt(255),
                    new Random().nextInt(255), 
                    new Random().nextInt(255)
                )
            );
            
            this.objetos.add(r);
            
            organizar();
            
        }
        else
        {
            ctrCheio = true;
            throw new Exception("Passo do limite, Limite atual: "+ limite+" tamanho atual: " +objetos.size());
        }
        
    }

    public Retangulo remove() throws Exception 
    {
        ctrCheio = ctrVazio = false;
        if (!vazia()) 
        {
            Retangulo temp = this.objetos.remove(0);
            
            organizar();
            
            return temp;
        }
        else
        {
            ctrVazio = true;
            throw new Exception("Fila esta vazia, Limite atual: "+ limite+" tamanho atual: " +objetos.size());
        }
        
    }

    public boolean vazia() 
    {
        return this.objetos.isEmpty();
    }

    private void organizar() 
    {   
        int i = 0;
        for (Retangulo objeto : objetos) 
        {
            objeto.setX(base.getX() + espaco * (i + 1) + objeto.getLargura() * i);
            i++;
        }
        
    }

    public int quantidade() 
    {
        return objetos.size();
    }
    
}
