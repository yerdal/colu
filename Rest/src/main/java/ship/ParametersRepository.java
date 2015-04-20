package ship;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ParametersRepository extends CrudRepository<SavedParameters, Long> {

    List<SavedParameters> findByRequiredETA(String requiredETA);
}