package andkonst88.dao;

import java.util.List;

import andkonst88.entity.Contact;

public interface ContactsDao {

	// CRUD OPERATION
	public Contact addContact(Contact contact) throws DaoException;

	public Contact findById(Integer id) throws DaoException;

	public Contact updateContact(Contact contact) throws DaoException;

	public void deleteContact(Integer id) throws DaoException;

	// QUERIES

	public List<Contact> findAll() throws DaoException;

	public List<Contact> findByCity(String city) throws DaoException;

	public List<Contact> findByCountry(String country) throws DaoException;
}
