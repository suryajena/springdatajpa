package org.springdata.repositories;

import java.util.Collection;

import org.springdata.model.QUser;
import org.springdata.model.User;
import org.springdata.model.projections.OnlyName;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

import com.querydsl.core.types.dsl.StringPath;

public interface UserRepository extends CrudRepository<User, Integer>,
QueryDslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser>
{
	Collection<OnlyName> findAllProjectedBy();

	OnlyName findProjectedById(Integer id);

	@Override
	default public void customize(QuerydslBindings bindings, QUser root)
	{

		bindings.bind(String.class)
				.first((StringPath path, String value) -> path.containsIgnoreCase(value));
		// bindings.excluding(root.password);
	}
}
