package dev.felipeazsantos.restaurant.dao;

import dev.felipeazsantos.restaurant.entity.Address;
import dev.felipeazsantos.restaurant.vo.CustomerVo;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Objects;

public class AddressDao {

    private final EntityManager entityManager;

    public AddressDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<CustomerVo> findCustomers(final String uf, final String city, final String street) {
        String jpql = "SELECT new dev.felipeazsantos.restaurant.vo.CustomerVo(a.customer.cpf, a.customer.name) " +
                        " FROM Address a " +
                        " WHERE 1 = 1 ";

        if (Objects.nonNull(uf)) {
            jpql = jpql.concat(" AND UPPER(a.uf) = UPPER(:uf)");
        }

        if (Objects.nonNull(city)) {
            jpql = jpql.concat("AND UPPER(a.city) = UPPER(:city)");
        }

        if (Objects.nonNull(street)) {
            jpql = jpql.concat("AND UPPER(a.street) = UPPER(:street)");
        }

        TypedQuery<CustomerVo> query = this.entityManager.createQuery(jpql, CustomerVo.class);

        if (Objects.nonNull(uf)) {
            query.setParameter("uf", uf);
        }

        if (Objects.nonNull(city)) {
            query.setParameter("city", city);
        }

        if (Objects.nonNull(street)) {
            query.setParameter("street", street);
        }

        return query.getResultList();
    }

    public List<CustomerVo> findCustomersCriteria(final String uf, final String city, final String street) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerVo> criteriaQuery = builder.createQuery(CustomerVo.class);
        Root<Address> root = criteriaQuery.from(Address.class);
        criteriaQuery.multiselect(root.get("customer").get("cpf"), root.get("customer").get("name"));
        Predicate predicate = builder.and();

        if (Objects.nonNull(uf)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("uf")), uf.toUpperCase()));
        }

        if (Objects.nonNull(city)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("city")), city.toUpperCase()));
        }

        if (Objects.nonNull(street)) {
            predicate = builder.and(predicate, builder.equal(builder.upper(root.get("street")), street.toUpperCase()));
        }

        criteriaQuery.where(predicate);
        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }
}
