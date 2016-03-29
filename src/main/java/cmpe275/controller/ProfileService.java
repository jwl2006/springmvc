package cmpe275.controller;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by wanghao on 3/23/16.
 */
@Service
public class ProfileService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<Profile> getAll() {
        List<Profile> result = em.createQuery("SELECT p from Profile p", Profile.class).getResultList();
        return result;
    }

    @Transactional
    public Profile get(Integer id) {
        Profile p1 = null;
        p1 = (Profile)em.find(Profile.class,id);
        return p1;
    }
    @Transactional
    public void add(Profile p) {
        em.persist(p);
    }

    @Transactional
    public void update(Profile p) {
        em.merge(p);
    }

    @Transactional
    public void delete(Integer id) {
        Profile p1 = (Profile)em.find(Profile.class,id);
        em.remove(p1);
    }
}
