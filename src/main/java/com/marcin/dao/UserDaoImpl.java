package com.marcin.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.marcin.model.User;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	public EntityManager entityManager;

	public EntityManager getEm() {
		return entityManager;
	}

	public void setEm(EntityManager em) {
		this.entityManager = em;
	}

	@Override
	public List<User> getUsers() {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<User> cq = builder.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void addUser(User user) {

		entityManager.persist(user);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	@Override
	public void editUser(User userEdit) {
		User user = entityManager.find(User.class, userEdit.getId());
		User editUser = entityManager.merge(user);
		editUser.setName(userEdit.getName());
		editUser.setSurname(userEdit.getSurname());
		editUser.setEmail(userEdit.getEmail());
		editUser.setAge(userEdit.getAge());

	}

	@Override
	public void deleteUser(int id) {
		User user = entityManager.find(User.class, id);
		entityManager.remove(user);
	}

}
