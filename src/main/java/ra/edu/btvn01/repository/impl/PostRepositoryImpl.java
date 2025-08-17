package ra.edu.btvn01.repository.impl;

import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.btvn01.model.entity.Post;
import ra.edu.btvn01.repository.PostRepository;

import java.util.List;

@Repository
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public List<Post> findAllByUserId(int userId){
        Session session = sessionFactory.getCurrentSession();
        String hql = "FROM Post p WHERE p.user.id = :userId";
        return session.createQuery(hql, Post.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Post where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public Post findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.createQuery("from Post where id = :id", Post.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }


    @Override
    public void save(Post post) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(post);
    }


}

