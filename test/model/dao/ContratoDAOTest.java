/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.bean.Contrato;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Master
 */
public class ContratoDAOTest {
    
    public ContratoDAOTest() {
    }

    @Test
    @Ignore
    public void testSaveContrato() {
        
        Contrato contrato = new Contrato();
        
        contrato.setTipodesc("Contrato de teste");
        contrato.setContexto("Reparo de teste");
        contrato.setValor(500.00);
        
        ContratoDAO dao = new ContratoDAO();
        
        if(dao.saveContrato(contrato)){
            System.out.println("Salvo com sucesso!! ");
        }else{
            fail("Erro ao Salvar!! ");
        }
    }
    
    @Test
    @Ignore
    public void testeUpdateContrato(){
        Contrato contrato = new Contrato();
        
        contrato.setTipodesc("Contrato de teste3");
        contrato.setContexto("Reparo de teste3");
        contrato.setValor(700.00);
        contrato.setIdcontrato(2);
        
        ContratoDAO dao = new ContratoDAO();
        
        if(dao.updateContrato(contrato)){
            System.out.println("Teste Atualizado com sucesso!! ");
        }else{
            fail("Teste Erro ao Atualizar!! ");
        }
    }
    
    @Test
    @Ignore
    public void deleteContrato(){
        
        Contrato contrato = new Contrato();
        
        contrato.setIdcontrato(3);
        
        ContratoDAO dao = new ContratoDAO();
        
        if (dao.deleteContrato(contrato)){
            System.out.println("Excluido com sucesso!! ");
        }else{
            fail("Erro ao Escluir!! ");
        }
    }
    
}
