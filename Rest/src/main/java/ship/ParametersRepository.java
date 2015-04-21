package ship;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ParametersRepository extends CrudRepository<SavedParameters, Integer> {

    List<SavedParameters> findByRequiredETA(String requiredETA);
}