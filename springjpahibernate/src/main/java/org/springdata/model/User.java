package org.springdata.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "testuser")
/*@JsonPropertyOrder(
	{ "emplNumber", "name" })*/
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @JsonIgnore
	private int		id;

	@NotBlank(message = "testing")
	@Size(min = 2, max = 14)
	// @JsonProperty(value = "tenant_name")
	@Column(name = "tenant_name")
	private String	name;

	@NotBlank(message = "testing")
	@Size(min = 2, max = 14)
	// @JsonProperty(value = "tenant_name")
	@Column(name = "tenant_code")
	private String	code;
	// @JsonProperty(value = "TenantActive", defaultValue = "true")
	private Boolean	active;

	public Boolean isActive()
	{
		return active;
	}

	public void setActive(Boolean active)
	{
		this.active = active;
	}

	@Column(name = "employees_number")
	// @Min(2)
	@Range(min = 1, max = 30)
	private int	emplNumber;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getEmplNumber()
	{
		return emplNumber;
	}

	public void setEmplNumber(int emplNumber)
	{
		this.emplNumber = emplNumber;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}
}
