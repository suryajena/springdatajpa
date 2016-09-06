package org.springdata.model.projections;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/*
@Projection(name = "onlyName", types =
	{ User.class })*/
@JsonPropertyOrder(
	{ "tenName", "tenEmpNum" })
public interface OnlyName
{
	@JsonProperty("tenName")
	public String getName();

	@JsonProperty("tenEmpNum")
	int getEmplNumber();

	String getCode();
}
