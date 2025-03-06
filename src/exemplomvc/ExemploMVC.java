/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemplomvc;

import dao.ProdutoDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelo.Produto;

/**
 *
 * @author euzebio
 */
public class ExemploMVC {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        
        Scanner s = new Scanner(System.in);
        int op;
        Integer id;
        Produto produto = new Produto();
        ProdutoDao produtoDao = new ProdutoDao();
        List<Produto> produtos = new ArrayList<Produto>();
        
        do{
            System.out.println("<!--------MENU PRINCIPAL--------!>");
            System.out.println("<1> INSERIR");
            System.out.println("<2> ALTERAR");
            System.out.println("<3> EXCLUIR");
            System.out.println("<4> PESQUISAR");
            System.out.println("<5> LISTAR");
            System.out.println("<0> SAIR");
            op = s.nextInt();
            switch(op){
                case 1: 
                    System.out.print("Nome do produto: ");
                    produto.setNome(s.next());
                    System.out.print("Descricao: ");
                    s.nextLine();
                    produto.setDescricao(s.nextLine());
                    System.out.print("Codigo: ");
                    produto.setCodigo(s.next());
                    System.out.print("preco: ");
                    produto.setPreco(s.nextDouble());
                    produtoDao.inserir(produto);
                    System.out.println("Produto cadastrado com sucesso!");
                
                break;
                case 2:
                    System.out.print("ID do produto: ");
                    id = s.nextInt();
                    produto = produtoDao.pesquisarPorId(id);
                    System.out.println("Nome "+produto.getNome());
                    produto.setNome(s.next());
                    System.out.println("Descricao "+produto.getDescricao());
                    s.nextLine();
                    produto.setDescricao(s.nextLine());                    
                    System.out.println("Codigo "+produto.getCodigo());
                    produto.setCodigo(s.next());
                    System.out.println("Preco "+produto.getPreco());
                    produto.setPreco(s.nextDouble());
                    produtoDao.alterar(produto);
                    System.out.println("Produto alterado com sucesso!");
                break;
                case 3: 
                    System.out.print("Nome o id do produto: ");
                    id = s.nextInt();
                    produtoDao.excluir(id);
                    System.out.println("Produto excluido com sucesso!");
                
                break;
                case 4: 
                    System.out.print("ID do produto: ");
                    id = s.nextInt();
                    produto = produtoDao.pesquisarPorId(id);
                    System.out.println("Nome "+produto.getNome());
                    System.out.println("Descricao "+produto.getDescricao());
                    System.out.println("Codigo "+produto.getCodigo());
                    System.out.println("Preco "+produto.getPreco());
                    
                break;
                case 5: 
                    produtos.clear();
                    produtos = produtoDao.listar();
                    System.out.print("ID\t");
                    System.out.print("Nome\t");
                    System.out.print("Descricao\t");
                    System.out.print("Codigo\t");
                    System.out.print("preco\t");
                    System.out.println("");
                    for(Produto p: produtos){
                        System.out.print(p.getId()+"\t");
                        System.out.print(p.getNome()+"\t");
                        System.out.print(p.getDescricao()+"\t");
                        System.out.print(p.getCodigo()+"\t");
                        System.out.print(p.getPreco()+"\t");
                        System.out.println("");
                    
                    }
                    System.out.println("");
                break;
            }
        }while(op!=0);
    }
    
}
