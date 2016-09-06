package org.springdata.model;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.PathInits;
import com.querydsl.core.types.dsl.StringPath;

/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User>
{

	private static final long		serialVersionUID	= -470386923L;

	private static final PathInits	INITS				= PathInits.DIRECT2;

	public static final QUser		user				= new QUser("user");

	public final StringPath			name				= createString("name");
	public final StringPath			code				= createString("code");

	public QUser(String variable)
	{
		this(User.class, forVariable(variable), INITS);
	}

	public QUser(Path<? extends User> path)
	{
		this(path.getType(), path.getMetadata(), PathInits.getFor(
				path.getMetadata(), INITS));
	}

	public QUser(PathMetadata metadata)
	{
		this(metadata, PathInits.getFor(metadata, INITS));
	}

	public QUser(PathMetadata metadata, PathInits inits)
	{
		this(User.class, metadata, inits);
	}

	public QUser(
		Class<? extends User> type,
		PathMetadata metadata,
		PathInits inits)
	{
		super(type, metadata, inits);

	}

}
