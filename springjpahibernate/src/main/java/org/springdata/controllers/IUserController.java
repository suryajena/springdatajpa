package org.springdata.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springdata.exception.UserNotFound;
import org.springdata.model.User;
import org.springdata.model.projections.OnlyName;
import org.springframework.web.bind.annotation.PathVariable;

public interface IUserController
{

	public OnlyName createNewUser(@Valid User user);

	public Collection<OnlyName> listUsers();

	public User editUser(@Valid User user, @PathVariable Integer id)
			throws UserNotFound;

	public boolean deleteUser(@PathVariable Integer id)
			throws UserNotFound;

	OnlyName getUser(Integer id);

}
