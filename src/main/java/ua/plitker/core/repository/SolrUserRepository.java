package ua.plitker.core.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.solr.repository.support.SimpleSolrRepository;
import org.springframework.stereotype.Repository;

import ua.plitker.core.model.User;

public class SolrUserRepository extends SimpleSolrRepository<User, Long> implements UserRepository {

}
