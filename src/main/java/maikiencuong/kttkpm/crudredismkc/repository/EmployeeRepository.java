package maikiencuong.kttkpm.crudredismkc.repository;

import maikiencuong.kttkpm.crudredismkc.entity.Employee;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private RedisTemplate redisTemplate;
    private HashOperations hashOperations;
    private ListOperations listOperations;
    private SetOperations setOperations;

    public EmployeeRepository(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        hashOperations = this.redisTemplate.opsForHash();
        listOperations = this.redisTemplate.opsForList();
        setOperations = this.redisTemplate.opsForSet();
    }

    public void save(Employee employee) {
//        hashOperations.put("employee", employee.getId(), employee);
//        listOperations.rightPush("employee", employee);
        setOperations.add("employee", employee);
    }

    public void delete(Employee employee) {
//        hashOperations.delete("employee",employee.getId());
//        listOperations.remove("employee", 1, employee);
        setOperations.remove("employee", employee);
    }

    public Employee findById(Long id) {
//        return (Employee) hashOperations.get("employee", id);
//        return (Employee) listOperations.range("employee", 0, - 1).stream()
//                .filter(x -> ((Employee) x).getId().equals(id))
//                .findFirst().orElse(null);

        return (Employee) setOperations.members("employee").stream()
                .filter(x -> ((Employee) x).getId().equals(id))
                .findFirst().orElse(null);
    }

    public List<Employee> findAll() {
//        return hashOperations.values("employee");
//        return listOperations.range("employee", 0, - 1);
        return (List<Employee>) setOperations.members("employee").stream().collect(Collectors.toList());
    }

}
