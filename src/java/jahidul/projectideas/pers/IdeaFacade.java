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

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public IdeaFacade() {
        super(Idea.class);
    }
    
    public List<Idea> findProvisionalIdeas() {
        TypedQuery<Idea> query = em.createQuery("SELECT i FROM Idea i WHERE i.status = 'Provisional'", Idea.class);
        return query.getResultList();
    }

    public List<Idea> findApprovedButUnallocatedIdeas() {
        TypedQuery<Idea> query = em.createQuery("SELECT i FROM Idea i WHERE i.status = 'Approved' AND i.appliedStudent IS NULL", Idea.class);
        return query.getResultList();
    }
    
    public List<Idea> findIdeasByText(String search) {
        TypedQuery<Idea> query = em.createQuery("SELECT i FROM Idea i WHERE lower(i.title) LIKE lower(:search)", Idea.class);
        query.setParameter("search", "%"+search+"%");
        return query.getResultList();
    }
}
