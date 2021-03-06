package ru.gb.classwork5.dao;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.gb.classwork5.entity.Manufacturer;


import java.util.Collections;
import java.util.List;

//@Repository
@RequiredArgsConstructor
public class HibernateManufacturerDao implements ManufacturerDao {

    private final SessionFactory sessionFactory;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Manufacturer> findAll() {
        return Collections.unmodifiableList(sessionFactory.getCurrentSession().createQuery("from Manufacturer m").list());


    }

    @Override
    public Manufacturer save(Manufacturer manufacturer) {
        sessionFactory.getCurrentSession().saveOrUpdate(manufacturer);
        return manufacturer;
    }

    @Override
    @Transactional(readOnly = true)
    public Manufacturer findById(Long id) {
        return (Manufacturer) sessionFactory.getCurrentSession().getNamedQuery("Manufacturer.findById")
                .setParameter("id", id).uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public String findNameById(Long id) {
        return (String) sessionFactory.getCurrentSession().getNamedQuery("Manufacturer.findNameById")
                .setParameter("id", id).uniqueResult();
    }

    @Override
    public void insert(Manufacturer manufacturer) {

    }

    @Override
    public void update(Manufacturer manufacturer) {

    }

    @Override
    public void deleteById(Long id) {
        final Manufacturer manufacturer = new Manufacturer();
        manufacturer.setId(id);
        sessionFactory.getCurrentSession().delete(manufacturer);
    }
}
