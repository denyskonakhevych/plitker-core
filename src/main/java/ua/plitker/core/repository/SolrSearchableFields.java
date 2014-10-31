package ua.plitker.core.repository;

import org.springframework.data.solr.core.query.Field;
import org.springframework.stereotype.Component;

import ua.plitker.core.model.Searchable;

public enum SolrSearchableFields implements Field {

	ID(Searchable.ID_FIELD),
	USERNAME(Searchable.USERNAME_FIELD),
	PASSWORD(Searchable.PASSWORD_FIELD),
	EMAIL(Searchable.EMAIL_FIELD),
	FULLNAME(Searchable.FULLNAME_FIELD),
	AVATAR(Searchable.AVATAR_FIELD),
	DESCRIPTION(Searchable.DESCRIPTION_FIELD);

	private final String fieldName;

	private SolrSearchableFields(String fieldName) {
		this.fieldName = fieldName;
	}

	@Override
	public String getName() {
		return fieldName;
	}

}