package com.biblioteca;

import org.junit.Assert;
import org.junit.Test;

public class LivroVendaTest {

    @Test
    public void testConstrutorComParametros() {

        Autor autor = new Autor("Nome do Autor", "Sobrenome do Autor");
        Editora editora = new Editora("Nome da Editora");
        Livro livro = new Livro(autor, editora, "1234567890", "Título do Livro", 200);
        int exemplares = 10;
        double valor =10.0;

        LivroEstoque livroEstoque = new LivroEstoque(livro, exemplares,valor);
        int quantidade = 10;
        LivroVenda livroVenda = new LivroVenda(livroEstoque,quantidade );

        Assert.assertEquals(10, livroVenda.quantidade);
        Assert.assertEquals("Nome do Autor", livroVenda.livroDoEstoque.livro.autor.nome);
        Assert.assertEquals("Nome da Editora", livroVenda.livroDoEstoque.livro.editora.nome);
        Assert.assertEquals("1234567890", livroVenda.livroDoEstoque.livro.isbn);
        Assert.assertEquals("Título do Livro", livroVenda.livroDoEstoque.livro.titulo);
        Assert.assertEquals(200, livroVenda.livroDoEstoque.livro.paginas);


    }

     @Test
     public void testConstrutorPadrao() {
         LivroVenda livroVenda = new LivroVenda();
         Assert.assertNull(livroVenda.livroDoEstoque);
         Assert.assertEquals(0,livroVenda.quantidade);
         
     }

    @Test
    public void testIncremento1() {
        
        LivroEstoque livroEstoque = new LivroEstoque();
        int quantidade = 10;
        LivroVenda livroVenda = new LivroVenda(livroEstoque,quantidade);
        livroVenda.IncrementarQuantidade();
        int expected = 11;   

        Assert.assertEquals(expected, livroVenda.quantidade);
     }
     
 @Test
    public void testIncremento2() {
        
        LivroEstoque livroEstoque = new LivroEstoque();
        int quantidade = 10;
        LivroVenda livroVenda = new LivroVenda(livroEstoque,quantidade);
        livroVenda.IncrementarQuantidade(10);
        int expected = 20;   

        Assert.assertEquals(expected, livroVenda.quantidade);
    }
     @Test
    public void testIncremento3() {
        
        LivroEstoque livroEstoque = new LivroEstoque();
        int quantidade = 10;
        LivroVenda livroVenda = new LivroVenda(livroEstoque,quantidade);
        boolean retorno = livroVenda.DecrementarQuantidade();

        int expected = 9;   

        Assert.assertEquals(true, retorno);
        Assert.assertEquals(expected, livroVenda.quantidade);

    }
      @Test
    public void testIncremento4() {
        
        LivroEstoque livroEstoque = new LivroEstoque();
        int quantidade = 10;
        LivroVenda livroVenda = new LivroVenda(livroEstoque,quantidade);
        boolean retorno = livroVenda.DecrementarQuantidade(5);

        int expected = 9;   

        Assert.assertEquals(true, retorno);
        Assert.assertEquals(expected, livroVenda.quantidade);

    }


}
