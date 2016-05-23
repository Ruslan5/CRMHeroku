package ua.com.feiron.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.feiron.domain.SignInForm;

import java.util.List;

@Repository
@Transactional
public class SignInRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void addsignup(SignInForm signInForm) {
        this.sessionFactory.getCurrentSession().save(signInForm);
    }
    public List<SignInForm> listAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from SignInForm").list();
    }

}
