package colu;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface for queries to the DB
 */
public interface ParametersRepository extends CrudRepository<SavedParameters, Integer> {

    // List<SavedParameters> findByRequiredETA(String requiredETA);
}