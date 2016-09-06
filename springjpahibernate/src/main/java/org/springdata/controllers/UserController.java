package org.springdata.controllers;

import java.util.Collection;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springdata.exception.UserNotFound;
import org.springdata.model.User;
import org.springdata.model.projections.OnlyName;
import org.springdata.repositories.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.querydsl.core.types.Predicate;

@RestController
@RequestMapping(value = "/user")
public class UserController implements IUserController
{
	/*
		@Autowired
		private UserService		userService;
	 */
	@Resource
	private UserRepository	userRepository;

	@Override
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public OnlyName createNewUser(@RequestBody @Valid User user)
	{

		userRepository.save(user);
		// userRepository user
		OnlyName result = getUser(user.getId());
		return result;
	}

	@Override
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Collection<OnlyName> listUsers()
	{

		/*		Predicate predicate = user.firstname.equalsIgnoreCase("dave")
						.and(user.lastname.startsWithIgnoreCase("mathews"));

					userRepository.findAll(predicate);*/
		// List list = (List) userService.findAll();
		Collection<OnlyName> list = userRepository.findAllProjectedBy();
		return list;
	}

	@Override
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public User editUser(@RequestBody User user, @PathVariable Integer id)
		throws UserNotFound
	{
		/*userService.update(user);
		return user;*/

		User updatedShop = userRepository.findOne(user.getId());

		if (updatedShop == null)
		{
			throw new UserNotFound();
		}

		updatedShop.setName(user.getName());
		updatedShop.setEmplNumber(user.getEmplNumber());
		return updatedShop;
	}

	@Override
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public boolean deleteUser(@PathVariable Integer id)
		throws UserNotFound
	{
		User deletedShop = userRepository.findOne(id);

		if (deletedShop == null)
		{
			throw new UserNotFound();
		}

		userRepository.delete(deletedShop);
		return true;
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public OnlyName getUser(@PathVariable Integer id)
	{
		// return userRepository.findOne(id);
		OnlyName result = userRepository.findProjectedById(id);
		return result;
	}

	@RequestMapping(value = "/testdsl", method = RequestMethod.GET)
	Iterable<User> index(
			@QuerydslPredicate(root = User.class) Predicate predicate, //
			@PageableDefault(sort =
				{ "code", "name" }) Pageable pageable, //
			@RequestParam MultiValueMap<String, String> parameters)
	{

		/*ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		builder.replaceQueryParam("page", new Object[0]);*/

		// return userRepository.findAll(predicate, pageable);
		return userRepository.findAll(predicate);
	}
}
