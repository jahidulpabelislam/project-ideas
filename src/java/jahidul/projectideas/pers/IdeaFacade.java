/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jahidul.projectideas.pers;

import jahidul.projectideas.ents.Idea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author up733474
 */
@Stateless
public class IdeaFacade extends AbstractFacade<Idea> {

    @PersistenceContext(unitName = "Project-IdeasPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public IdeaFacade() {
        super(Idea.class);
    }

}
