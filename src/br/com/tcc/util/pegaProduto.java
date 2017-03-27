/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tcc.util;

import br.com.tcc.entity.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author Leonardo P Souza
 */
public class pegaProduto {
    public static List ConsultarProduto(Query desc) throws Exception {
        EntityManager manager = null;
        String ejbql = "from Produto where numEstoque <= numEstoqueCritico";
        try {
            manager = EntityManagerUtil.getEntityManager();
//            manager.getTransaction().begin();
            Query query = manager.createQuery(ejbql);
//            query.setParameter("parametro", desc + "%");
//            manager.getTransaction().commit();
//            List<Produto> listaProduto = ;
            return query.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw new Exception(e);
        }
    }
}
